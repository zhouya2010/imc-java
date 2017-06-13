package com.yundian.imc.common.service;


import com.yundian.imc.common.Filter;
import com.yundian.imc.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Service - 基类
 *
 * @author Milanosoft Team
 * @version 4.0
 */
public interface BaseService<T extends BaseEntity<ID>, ID extends Serializable> {

    /**
     * 查找实体对象
     *
     * @param id ID
     * @return 实体对象，若不存在则返回null
     */
    T find(ID id);

    /**
     * 查找所有实体对象集合
     *
     * @return 所有实体对象集合
     */
    List<T> findAll();



    /**
     * 查询实体对象总数
     *
     * @return 实体对象总数
     */
    long count();

//    /**
//     * 查询实体对象数量
//     *
//     * @param filters 筛选
//     * @return 实体对象数量
//     */
//    long count(Filter... filters);

    /**
     * 判断实体对象是否存在
     *
     * @param id ID
     * @return 实体对象是否存在
     */
    boolean exists(ID id);

//    /**
//     * 判断实体对象是否存在
//     *
//     * @param filters 筛选
//     * @return 实体对象是否存在
//     */
//    boolean exists(Filter... filters);

    /**
     * 保存实体对象
     *
     * @param entity 实体对象
     * @return 实体对象
     */
    T save(T entity);

    /**
     * 更新实体对象
     *
     * @param entity 实体对象
     * @return 实体对象
     */
    T update(T entity);

//    /**
//     * 更新实体对象
//     *
//     * @param entity           实体对象
//     * @param ignoreProperties 忽略属性
//     * @return 实体对象
//     */
//    T update(T entity, String... ignoreProperties);

    /**
     * 删除实体对象
     *
     * @param id ID
     */
    void delete(ID id);

    /**
     * 删除实体对象
     *
     * @param ids ID
     */
    void delete(ID... ids);

    /**
     * 删除实体对象
     *
     * @param entity 实体对象
     */
    void delete(T entity);


    /**
     * 批量保存实体
     */
    boolean saves(List<T> list);

    /**
     * 批量更新实体
     */
    boolean updates(List<T> list);

    /**
     * 批量删除实体
     */
    boolean deletes(List<T> list);

}