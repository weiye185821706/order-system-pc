package com.sys.order.service.impl;

import com.sys.order.common.message.MessageReceiverDefinition;
import com.sys.order.entity.*;
import com.sys.order.dao.OrderMapper;
import com.sys.order.exception.MyException;
import com.sys.order.service.IDishesService;
import com.sys.order.service.IOrderService;
import com.sys.order.service.IOrderDishesService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author yewei
 * @since 2021-03-11
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, Order> implements IOrderService {

    private final IOrderDishesService orderDishesService;
    private final IDishesService dishesService;

    // 解决循环依赖
    @Lazy
    public OrderServiceImpl(IOrderDishesService orderDishesService, IDishesService dishesService) {
        this.orderDishesService = orderDishesService;
        this.dishesService = dishesService;
    }


    /**
     * 用户下单接口
     * @param dishesIds 菜品id集合
     * @return
     */
    @Override
    @Transactional
    public void placeAnOrder(List<Long> dishesIds) {
        // 计算订单的金额
        BigDecimal all = this.orderPrice(dishesIds);
        // 创建订单
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setStatus(StatusEnum.ORDER_START.getValue());
        order.setOrderPrice(all);
        this.insert(order);
        // 创建订单中的菜品
        dishesIds.forEach(id -> {
            OrderDishes orderDishes = new OrderDishes();
            orderDishes.setOrderId(order.getId());
            orderDishes.setDishesId(id);
            orderDishes.setStatus(StatusEnum.ON_START.getValue());
            this.orderDishesService.insert(orderDishes);
        });
        // 通知厨师服务员用户下单
        MessageReceiverDefinition.notification("用户已经下单，请服务员厨师抓紧做菜上菜",MessageTypeEnum.WAITER, MessageTypeEnum.CHEF);
    }

    /**
     * 用户退单接口
     * @param id 订单id
     */
    @Override
    @Transactional
    public void returnOrder(Long id) {
        // 校验是否可以退订单
        this.checkOrder(id);
        Order order = this.selectById(id);
        order.setStatus(StatusEnum.ORDER_RETURN.getValue());
        order.setUpdateTime(new Date());
        this.updateById(order);
        // todo 发送通知服务员，厨师
        MessageReceiverDefinition.notification("用户已经退单，请服务员厨师知晓",MessageTypeEnum.WAITER, MessageTypeEnum.CHEF);
    }

    /**
     * 厨师接单接口
     * @param id 订单id
     */
    @Override
    @Transactional
    public void pickUpOrder(Long id) {
        Order order = this.selectById(id);
        if (StatusEnum.ORDER_RETURN.getValue().equals(order.getStatus())) {
            throw new MyException("该订单已经被客户退掉，接单失败");
        }
        order.setStatus(StatusEnum.ORDER_PICK_UP.getValue());
        order.setUpdateTime(new Date());
        this.updateById(order);
    }

    /**
     * 服务员完成订单接口
     * @param id 订单id
     */
    @Override
    public void carryOutOrder(Long id) {
        Order order = this.selectById(id);
        if (StatusEnum.ORDER_RETURN.getValue().equals(order.getStatus())) {
            throw new MyException("该订单已经被客户退掉，无法完成订单");
        }
        order.setStatus(StatusEnum.ORDER_SUCCESS.getValue());
        order.setUpdateTime(new Date());
        this.updateById(order);
        MessageReceiverDefinition.notification("该用户订单已经完成，厨师幸苦了，再接再厉", MessageTypeEnum.CHEF);
    }

    /**
     * 校验是否支持退单
     * @param id 订单id
     */
    private void checkOrder(Long id) {
        Order order = this.selectById(id);
        if (StatusEnum.ORDER_START.getValue().equals(order.getStatus()) ||
           StatusEnum.ORDER_PICK_UP.getValue().equals(order.getStatus())) {
            OrderDishes orderDishes = new OrderDishes();
            orderDishes.setOrderId(id);
            if (this.orderDishesService.checkOrderDishes(orderDishes)) {
                throw new MyException("厨师已经接单，并开始制作菜品，不支持退单。请查看详情退单个菜品");
            }
        } else {
            throw new MyException("订单已经完成，不支持退单");
        }
    }

    /**
     * 计算这笔订单总金额
     * @param dishesIds 菜品id
     * @return
     */
    private BigDecimal orderPrice(List<Long> dishesIds) {
        List<Dishes> dishes = this.dishesService.selectBatchIds(dishesIds);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        dishes.forEach(e -> {
            if (e.getDishesPrice() == null) {
                throw new MyException("订单创建异常");
            } else {
                bigDecimal.add(e.getDishesPrice());
            }
        });
        return bigDecimal;
    }

}
