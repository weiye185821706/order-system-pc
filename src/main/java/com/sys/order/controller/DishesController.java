package com.sys.order.controller;


import com.sys.order.entity.Dishes;
import com.sys.order.service.IDishesService;
import com.sys.order.vo.PageVO;
import com.sys.order.vo.RequestVo;
import com.sys.order.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 菜品表 前端控制器
 * </p>
 *
 * @author yewei
 * @since 2021-03-11
 */
@RestController
@RequestMapping("/dishes")
@Api(tags = "菜品接口")
public class DishesController {


    private final IDishesService dishesService;

    public DishesController(IDishesService dishesService) {
        this.dishesService = dishesService;
    }

    @PostMapping("/page")
    @ApiOperation("菜品分页查询")
    public PageVO<Dishes> page(@RequestBody RequestVo<Dishes> requestVo) {
        return dishesService.selectPage(requestVo);
    }

    @GetMapping("/addDishes")
    @ApiOperation("用户加菜接口")
    public ResultVo<String> addDishes(@ApiParam(name = "订单id") @RequestParam("orderId") Long orderId,
                                      @ApiParam(name = "菜品id") @RequestParam("dishesId") Long dishesId) {
        this.dishesService.addDishes(orderId, dishesId);
        return ResultVo.success("加菜成功，请稍等片刻");
    }

    @GetMapping("/returnDishes")
    @ApiOperation("用户退菜接口")
    public ResultVo<String> returnDishes(@ApiParam(name = "订单id") @RequestParam("orderId") Long orderId,
                                         @ApiParam(name = "菜品id") @RequestParam("dishesId") Long dishesId) {
        this.dishesService.returnDishes(orderId, dishesId);
        return ResultVo.success("退菜成功");
    }

    @GetMapping("/startDishes")
    @ApiOperation("厨师开始做菜接口")
    public ResultVo<String> startDishes(@ApiParam(name = "订单id") @RequestParam("orderId") Long orderId,
                                        @ApiParam(name = "菜品id") @RequestParam("dishesId") Long dishesId) {
        this.dishesService.startDishes(orderId, dishesId);
        return ResultVo.success("操作成功");
    }

    @GetMapping("/carryOutDishes")
    @ApiOperation("厨师完成做菜接口")
    public ResultVo<String> carryOutDishes(@ApiParam(name = "订单id") @RequestParam("orderId") Long orderId,
                                           @ApiParam(name = "菜品id") @RequestParam("dishesId") Long dishesId) {
        this.dishesService.carryOutDishes(orderId, dishesId);
        return ResultVo.success("菜品完成成功，等待服务员传菜");
    }

    @GetMapping("/dishesOk")
    @ApiOperation("服务员完成上菜接口")
    public ResultVo<String> dishesOk(@ApiParam(name = "订单id") @RequestParam("orderId") Long orderId,
                                     @ApiParam(name = "菜品id") @RequestParam("dishesId") Long dishesId) {
        this.dishesService.dishesOk(orderId, dishesId);
        return ResultVo.success("上菜完成");
    }

}

