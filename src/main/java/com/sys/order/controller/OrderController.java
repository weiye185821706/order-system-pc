package com.sys.order.controller;


import com.sys.order.entity.Order;
import com.sys.order.service.IOrderService;
import com.sys.order.vo.PageVO;
import com.sys.order.vo.RequestVo;
import com.sys.order.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author yewei
 * @since 2021-03-11
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单相关接口")
public class OrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/page")
    @ApiOperation("订单分页查询")
    public PageVO<Order> page(@RequestBody RequestVo<Order> requestVo) {
        return this.orderService.selectPage(requestVo);
    }

    @PostMapping("/placeAnOrder")
    @ApiOperation("用户下单接口")
    public ResultVo<String> placeAnOrder(@ApiParam("菜品id集合") @RequestBody List<Long> dishesIds) {
        this.orderService.placeAnOrder(dishesIds);
        return ResultVo.success("下单成功，厨师正在努力炒菜，稍等片刻");
    }

    @GetMapping("/returnOrder")
    @ApiOperation("用户退单接口")
    public ResultVo<String> returnOrder(@ApiParam("订单id") @RequestParam("id") Long id) {
        this.orderService.returnOrder(id);
        return ResultVo.success("退单成功");
    }

    @GetMapping("/pickUpOrder")
    @ApiOperation("厨师接单接口")
    public ResultVo<String> pickUpOrder(@ApiParam("订单id") @RequestParam("id") Long id) {
        this.orderService.pickUpOrder(id);
        return ResultVo.success("厨师接单成功");
    }

    @GetMapping("/carryOutOrder")
    @ApiOperation("服务员完成订单接口")
    public ResultVo<String> carryOutOrder(@ApiParam("订单id") @RequestParam("id") Long id) {
        this.orderService.carryOutOrder(id);
        return ResultVo.success("订单完成成功");
    }

}

