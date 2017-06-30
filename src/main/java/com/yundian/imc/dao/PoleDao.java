package com.yundian.imc.dao;

import com.yundian.imc.common.base.BaseDao;
import com.yundian.imc.entity.Pole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PoleDao extends BaseDao<Pole,Long> {
    Pole findPoleByPoleId(String poleId);
    Page<Pole> findAllByDelFlagFalseAndPoleIdContains(String poleId,Pageable pageable);
}
