package com.sys.order.service.impl;

import com.sys.order.common.message.MessageReceiverDefinition;
import com.sys.order.entity.*;
import com.sys.order.dao.DishesMapper;
import com.sys.order.exception.MyException;
import com.sys.order.service.IDishesService;
import com.sys.order.service.IOrderDishesService;
import com.sys.order.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 菜品表 服务实现类
 * </p>
 *
 * @author yewei
 * @since 2021-03-11
 */
@Service
public class DishesServiceImpl extends BaseServiceImpl<DishesMapper, Dishes> implements IDishesService {

    private final IOrderDishesService orderDishesService;
    private final IOrderService orderService;

    public DishesServiceImpl(IOrderDishesService orderDishesService, IOrderService orderService) {
        this.orderDishesService = orderDishesService;
        this.orderService = orderService;
    }

    /**
     * 用户加菜接口
     *
     * @param orderId  订单id
     * @param dishesId 菜品id
     */
    @Override
    @Transactional
    public void addDishes(Long orderId, Long dishesId) {
        OrderDishes orderDishes = new OrderDishes();
        orderDishes.setDishesId(dishesId);
        orderDishes.setOrderId(orderId);
        orderDishes.setStatus(StatusEnum.ON_START.getValue());
        this.orderDishesService.insert(orderDishes);
        // 更新订单价格
        this.updateOrderPrice(orderId, dishesId, 1);
        Dishes dishes = this.selectById(dishesId);
        // todo 通知服务员和厨师
        MessageReceiverDefinition.notification("用户新加了" + dishes.getDishesName(), MessageTypeEnum.WAITER, MessageTypeEnum.CHEF);
    }

    /**
     * 用户退菜接口
     *
     * @param orderId  订单id
     * @param dishesId 菜品id
     */
    @Override
    public void returnDishes(Long orderId, Long dishesId) {
        // 校验用户是否可以退菜
        OrderDishes orderDishes = new OrderDishes();
        orderDishes.setOrderId(orderId);
        orderDishes.setDishesId(dishesId);
        if (this.orderDishesService.checkOrderDishes(orderDishes)) {
            throw new MyException("该菜品正在制作中，不支持退菜");
        }
        // 更新菜品状态为退菜
        OrderDishes dishes = this.orderDishesService.selectOne(orderDishes);
        dishes.setDishesId(dishesId);
        dishes.setOrderId(orderId);
        dishes.setStatus(StatusEnum.RETURN_DIS.getValue());
        this.orderDishesService.updateById(dishes);
        // 更新订单价格
        this.updateOrderPrice(orderId, dishesId, 2);
        Dishes dishe = this.selectById(dishesId);
        // todo 通知服务员，和厨师
        MessageReceiverDefinition.notification("用户退了" + dishe.getDishesName(),MessageTypeEnum.WAITER, MessageTypeEnum.CHEF);
    }

    /**
     * 厨师做菜接口
     *
     * @param orderId  订单id
     * @param dishesId 菜品id
     */
    @Override
    public void startDishes(Long orderId, Long dishesId) {
        OrderDishes orderDishes = new OrderDishes();
        orderDishes.setOrderId(orderId);
        orderDishes.setDishesId(dishesId);
        OrderDishes dishes = this.orderDishesService.selectOne(orderDishes);
        if (StatusEnum.RETURN_DIS.getValue().equals(dishes.getStatus())) {
            throw new MyException("该菜品已经被客户退菜，不能制作");
        }
        // 更新菜品状态为开始制作
        dishes.setStatus(StatusEnum.START.getValue());
        this.orderDishesService.updateById(dishes);
        // todo 通知用户
        MessageReceiverDefinition.notification("厨师正在开始做菜中", MessageTypeEnum.USER);
    }

    /**
     * 厨师完成做菜接口
     *
     * @param orderId  订单id
     * @param dishesId 菜品id
     */
    @Override
    public void carryOutDishes(Long orderId, Long dishesId) {
        OrderDishes orderDishes = new OrderDishes();
        orderDishes.setOrderId(orderId);
        orderDishes.setDishesId(dishesId);
        OrderDishes dishes = this.orderDishesService.selectOne(orderDishes);
        // 更新菜品状态为开始制作
        dishes.setStatus(StatusEnum.SUCCESS.getValue());
        this.orderDishesService.updateById(dishes);
        // todo 通知服务员
        MessageReceiverDefinition.notification("厨师已经做好菜品，请服务员上菜",MessageTypeEnum.WAITER);
    }

    /**
     * 服务员完成上菜接口
     *
     * @param orderId  订单id
     * @param dishesId 菜品id
     */
    @Override
    public void dishesOk(Long orderId, Long dishesId) {
        OrderDishes orderDishes = new OrderDishes();
        orderDishes.setOrderId(orderId);
        orderDishes.setDishesId(dishesId);
        OrderDishes dishes = this.orderDishesService.selectOne(orderDishes);
        if (!StatusEnum.SUCCESS.getValue().equals(dishes.getStatus())) {
            throw new MyException("该菜品尚未制作完成，请稍等");
        }
        // 更新菜品状态为开始制作
        dishes.setStatus(StatusEnum.OK.getValue());
        this.orderDishesService.updateById(dishes);
        // todo 通知用户，厨师
        MessageReceiverDefinition.notification("服务员完成上菜", MessageTypeEnum.CHEF, MessageTypeEnum.USER);
    }

    /**
     * 更新订单总金额
     *
     * @param orderId  订单id
     * @param dishesId 菜品id
     * @param status   1表示加菜，2表示退菜
     */
    private void updateOrderPrice(Long orderId, Long dishesId, int status) {
        Order order = this.orderService.selectById(orderId);
        Dishes dishes = this.selectById(dishesId);
        if (status == 1) {
            order.setOrderPrice(order.getOrderPrice().add(dishes.getDishesPrice()));
        } else if (status == 2) {
            order.setOrderPrice(order.getOrderPrice().subtract(dishes.getDishesPrice()));
        } else {
            throw new MyException("订单总金额更新失败，未知类型");
        }
        order.setUpdateTime(new Date());
        this.orderService.updateById(order);
    }

}
