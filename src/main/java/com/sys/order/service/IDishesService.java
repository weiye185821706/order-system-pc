package com.sys.order.service;

import com.sys.order.entity.Dishes;
import com.sys.order.service.BaseService;

/**
 * <p>
 * 菜品表 服务类
 * </p>
 *
 * @author yewei
 * @since 2021-03-11
 */
public interface IDishesService extends BaseService<Dishes> {

    /**
     * 用户加菜接口
     *
     * @param orderId  订单id
     * @param dishesId 菜品id
     */
    void addDishes(Long orderId, Long dishesId);

    /**
     * 用户退菜接口
     *
     * @param orderId  订单id
     * @param dishesId 菜品id
     */
    void returnDishes(Long orderId, Long dishesId);

    /**
     * 厨师做菜接口
     *
     * @param orderId  订单id
     * @param dishesId 菜品id
     */
    void startDishes(Long orderId, Long dishesId);

    /**
     * 厨师完成做菜接口
     *
     * @param orderId  订单id
     * @param dishesId 菜品id
     */
    void carryOutDishes(Long orderId, Long dishesId);

    /**
     * 服务员完成上菜接口
     *
     * @param orderId  订单id
     * @param dishesId 菜品id
     */
    void dishesOk(Long orderId, Long dishesId);
}
