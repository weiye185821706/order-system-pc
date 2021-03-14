package com.sys.order.service;

import com.sys.order.entity.Order;
import com.sys.order.service.BaseService;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author yewei
 * @since 2021-03-11
 */
public interface IOrderService extends BaseService<Order> {

    /**
     * 用户下单接口
     * @param dishesIds 菜品id集合
     * @return
     */
    void placeAnOrder(List<Long> dishesIds);

    /**
     * 用户退单接口
     * @param id 订单id
     */
    void returnOrder(Long id);

    /**
     * 厨师接单接口
     * @param id 订单id
     */
    void pickUpOrder(Long id);

    /**
     * 服务员完成订单接口
     * @param id 订单id
     */
    void carryOutOrder(Long id);
}
