package com.yundian.imc.common.base;

import com.yundian.imc.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.io.Serializable;

@Transactional
public abstract class BaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable> implements BaseService<T,ID> {

    private BaseDao<T, ID> baseDao;

    @Autowired
    protected void setBaseDao(BaseDao<T, ID> baseDao) {
        this.baseDao = baseDao;
    }


    @Override
    public Iterable<T> findAll(Sort sort) {
        return baseDao.findAll(sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return baseDao.findAll(pageable);
    }

    @Override
    public <S extends T> S save(S s) {
        return baseDao.save(s);
    }

    @Override
    public <S extends T> Iterable<S> save(Iterable<S> iterable) {
        return baseDao.save(iterable);
    }

    @Override
    public T findOne(ID id) {
        return baseDao.findOne(id);
    }

    @Override
    public boolean exists(ID id) {
        return baseDao.exists(id);
    }

    @Override
    public Iterable<T> findAll() {
        return baseDao.findAll();
    }

    @Override
    public Iterable<T> findAll(Iterable<ID> iterable) {
        return baseDao.findAll(iterable);
    }

    @Override
    public long count() {
        return baseDao.count();
    }

    @Override
    public void delete(ID id) {
        baseDao.delete(id);
    }

    @Override
    public void delete(T t) {
        baseDao.delete(t);
    }

    @Override
    public void delete(Iterable<? extends T> iterable) {
        baseDao.delete(iterable);
    }

    @Override
    public void deleteAll() {
        baseDao.deleteAll();
    }
}
