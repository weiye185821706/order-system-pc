package com.sys.order.service;

import com.sys.order.entity.SysUser;
import com.sys.order.service.BaseService;
import com.sys.order.vo.SysMenuVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yewei
 * @since 2021-03-11
 */
public interface ISysUserService extends BaseService<SysUser> {

    /**
     * 用户登录
     * @param sysUser 登录账号密码
     * @return 菜单数据
     */
    List<SysMenuVo> login(SysUser sysUser);
}
