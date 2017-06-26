package com.yundian.imc.service;

import com.yundian.imc.common.base.BaseService;
import com.yundian.imc.entity.Station;

public interface StationService extends BaseService<Station, Long> {
    Station findStationByStationId(String stationId);

    int countStationsByAreaCode(String area);
}
