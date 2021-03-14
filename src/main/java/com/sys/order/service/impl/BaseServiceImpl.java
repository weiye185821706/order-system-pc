package com.sys.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sys.order.service.BaseService;
import com.sys.order.util.MybatisUtils;
import com.sys.order.vo.PageVO;
import com.sys.order.vo.RequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 公共service实现
 * @param <T>
 */
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BaseServiceImpl<S extends BaseMapper<T>, T> implements BaseService<T> {

    @Autowired
    private S mapper;

    @Override
    @Transactional
    public int insert(T entity) {
        return this.mapper.insert(entity);
    }

    @Override
    @Transactional
    public int deleteById(Serializable id) {
        return this.mapper.deleteById(id);
    }

    @Override
    @Transactional
    public int updateById(T entity) {
        return this.mapper.updateById(entity);
    }

    @Override
    public T selectById(Serializable id) {
        return this.mapper.selectById(id);
    }

    @Override
    public List<T> selectBatchIds(List<Long> idList) {
        return this.mapper.selectBatchIds(idList);
    }

    @Override
    public T selectOne(T entity) {
        return this.mapper.selectOne(MybatisUtils.conditionSql(entity));
    }

    @Override
    public List<T> selectList(T entity) {
        return this.mapper.selectList(MybatisUtils.conditionSql(entity));
    }

    @Override
    public PageVO<T> selectPage(RequestVo<T> requestVo) {
        return new PageVO<>(this.mapper.selectPage(new Page<>(requestVo.getPage(), requestVo.getSize()), MybatisUtils.conditionSql(requestVo.getParams())));
    }

    @Override
    public PageVO<T> selectPage(long page, long size) {
        return new PageVO<>(this.mapper.selectPage(new Page<>(page, size), new QueryWrapper<>()));
    }
}
