package com.sys.order.controller;


import com.sys.order.entity.SysUser;
import com.sys.order.service.ISysUserService;
import com.sys.order.vo.ResultVo;
import com.sys.order.vo.SysMenuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 登录前端控制器
 * </p>
 *
 * @author yewei
 * @since 2021-03-11
 */
@RestController
@RequestMapping("/user")
@Api(tags = "登录相关接口")
public class SysUserController {

    private final ISysUserService userService;

    public SysUserController(ISysUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @ApiOperation("用户登录返回菜单，没有做权限")
    public ResultVo<List<SysMenuVo>> login(@RequestBody SysUser sysUser) {
        return ResultVo.success(this.userService.login(sysUser));
    }

}

