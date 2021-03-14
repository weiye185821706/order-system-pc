package com.sys.order.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.sys.order.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sys.order.vo.SysMenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yewei
 * @since 2021-03-11
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysMenuVo> login(@Param(Constants.WRAPPER) QueryWrapper<SysUser> wrapper);

}
