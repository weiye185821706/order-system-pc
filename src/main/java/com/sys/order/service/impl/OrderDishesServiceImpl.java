package com.sys.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sys.order.entity.OrderDishes;
import com.sys.order.dao.OrderDishesMapper;
import com.sys.order.entity.StatusEnum;
import com.sys.order.service.IOrderDishesService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单和菜品关联表 服务实现类
 * </p>
 *
 * @author yewei
 * @since 2021-03-11
 */
@Service
public class OrderDishesServiceImpl extends BaseServiceImpl<OrderDishesMapper, OrderDishes> implements IOrderDishesService {

    private final OrderDishesMapper orderDishesMapper;

    public OrderDishesServiceImpl(OrderDishesMapper orderDishesMapper) {
        this.orderDishesMapper = orderDishesMapper;
    }

    /**
     * 订单菜品退单校验
     *
     * @param orderDishes 订单参数
     * @return true 表示菜品正在制作，或者制作完成，不支持退单
     */
    @Override
    public boolean checkOrderDishes(OrderDishes orderDishes) {
        QueryWrapper<OrderDishes> wrapper = new QueryWrapper<>();
        // 校验订单退单的条件
        wrapper.eq("ORDER_ID", orderDishes.getOrderId());
        // 校验菜品退菜的条件
        wrapper.eq(orderDishes.getDishesId() != null, "DISHES_ID", orderDishes.getDishesId());
        wrapper.notIn("STATUS", StatusEnum.ON_START.getValue(), StatusEnum.RETURN_DIS.getValue());
        Integer integer = this.orderDishesMapper.selectCount(wrapper);
        return integer > 0;
    }
}
