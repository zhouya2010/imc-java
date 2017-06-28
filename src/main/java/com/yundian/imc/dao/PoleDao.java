package com.yundian.imc.dao;

import com.yundian.imc.common.base.BaseDao;
import com.yundian.imc.entity.Pole;

public interface PoleDao extends BaseDao<Pole,Long> {
    Pole findPoleByPoleId(String poleId);
}
