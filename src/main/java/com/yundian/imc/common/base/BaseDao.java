package com.yundian.imc.common.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

public interface BaseDao<T, ID extends Serializable> extends PagingAndSortingRepository<T,ID> {
    Page<T> findAllByDelFlagFalse(Pageable pageable);
}
