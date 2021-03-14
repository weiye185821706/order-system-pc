package com.sys.order.service;

import com.sys.order.entity.OrderDishes;

/**
 * <p>
 * 订单和菜品关联表 服务类
 * </p>
 *
 * @author yewei
 * @since 2021-03-11
 */
public interface IOrderDishesService extends BaseService<OrderDishes> {

    /**
     * 订单菜品退单校验
     *
     * @param orderDishes 订单参数
     * @return
     */
    boolean checkOrderDishes(OrderDishes orderDishes);
}
