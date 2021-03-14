package com.sys.order.service;

import com.sys.order.vo.PageVO;
import com.sys.order.vo.RequestVo;

import java.io.Serializable;
import java.util.List;

/**
 * 公共service接口
 * @param <T>
 */
public interface BaseService<T> {
    /**
     * 插入一条记录
     *
     * @param entity 实体对象
     */
    int insert(T entity);

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    int deleteById(Serializable id);

    /**
     * 根据 ID 修改
     *
     * @param entity 实体对象
     */
    int updateById(T entity);

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    T selectById(Serializable id);

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表(不能为 null 以及 empty)
     */
    List<T> selectBatchIds(List<Long> idList);

    /**
     * 根据 entity 条件，查询一条记录
     *
     * @param entity 实体对象封装操作类（可以为 null）（条件判断只支持=条件）
     */
    T selectOne(T entity);

    /**
     * 根据 entity 条件，查询全部记录（条件判断只支持=条件）
     *
     * @param entity 实体对象封装操作类（可以为 null）
     */
    List<T> selectList(T entity);

    /**
     * 根据 entity 条件，查询全部记录（并翻页）（条件判断只支持=条件）
     *
     * @param requestVo 查询参数
     */
    PageVO<T> selectPage(RequestVo<T> requestVo);

    /**
     * 无条件分页查询
     * @param page  页码
     * @param size  大小
     */
    PageVO<T> selectPage(long page, long size);
}
