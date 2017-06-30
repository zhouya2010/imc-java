package com.yundian.imc.common.base;


import com.yundian.imc.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

/**
 * Service - 基类
 */
public interface BaseService<T extends BaseEntity<ID>, ID extends Serializable> extends BaseDao<T, ID>{
    Page<T> findAllByDelFlagFalse(Pageable pageable);
}