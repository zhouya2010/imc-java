package com.yundian.imc.dao;

import com.yundian.imc.common.base.BaseDao;
import com.yundian.imc.entity.Station;

public interface StationDao extends BaseDao<Station, Long> {
    Station findStationByStationId(String stationId);
    int countStationsByAreaCode(String area);
}
