package com.yundian.imc.common.base;


import com.yundian.imc.entity.BaseEntity;

import java.io.Serializable;

/**
 * Service - 基类
 */
public interface BaseService<T extends BaseEntity<ID>, ID extends Serializable> extends BaseDao<T, ID>{

}