package com.yundian.imc.common.service;

import com.yundian.imc.common.Filter;
import com.yundian.imc.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Service - 基类
 */
@Transactional
public abstract class BaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable> implements BaseService<T, ID> {


    /**
     * BaseDao
     */
    private CrudRepository<T, ID> baseDao;

    @Autowired
    protected void setBaseDao(CrudRepository<T, ID> baseDao) {
        this.baseDao = baseDao;
    }

    @Transactional(readOnly = true)
    @Override
    public T find(ID id) {
        return baseDao.findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<T> findAll() {
        return findList(null, null, null, null);
    }

    @Override
    public long count() {
        return baseDao.count();
    }

//    @Override
//    public long count(Filter... filters) {
//        return baseDao;
//    }

    @Override
    public boolean exists(ID id) {
        return false;
    }

//    @Override
//    public boolean exists(Filter... filters) {
//        return false;
//    }

    @Override
    public T save(T entity) {
        return null;
    }

    @Override
    public T update(T entity) {
        return null;
    }

//    @Override
//    public T update(T entity, String... ignoreProperties) {
//        return null;
//    }

    @Override
    public void delete(ID id) {

    }

    @Override
    public void delete(ID[] ids) {

    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public boolean saves(List<T> list) {
        return false;
    }

    @Override
    public boolean updates(List<T> list) {
        return false;
    }

    @Override
    public boolean deletes(List<T> list) {
        return false;
    }

    @Transactional(readOnly = true)
    public List<T> findList(ID... ids) {
        List<T> result = new ArrayList<T>();
        if (ids != null) {
            for (ID id : ids) {
                T entity = find(id);
                if (entity != null) {
                    result.add(entity);
                }
            }
        }

        return result;
    }



}