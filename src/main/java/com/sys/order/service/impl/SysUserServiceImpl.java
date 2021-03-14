package com.sys.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sys.order.entity.SysUser;
import com.sys.order.dao.SysUserMapper;
import com.sys.order.service.ISysUserService;
import com.sys.order.vo.SysMenuVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yewei
 * @since 2021-03-11
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    private final SysUserMapper sysUserMapper;

    public SysUserServiceImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    /**
     * 用户登录
     * @param sysUser 登录账号密码
     * @return 菜单数据
     */
    @Override
    public List<SysMenuVo> login(SysUser sysUser) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("U.USER_NAME", sysUser.getUserName());
        wrapper.eq("U.PASSWORD", sysUser.getPassword());
        return this.sysUserMapper.login(wrapper);
    }

}
