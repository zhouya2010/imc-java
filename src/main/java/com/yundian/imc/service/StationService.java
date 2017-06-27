package com.yundian.imc.service;

import com.yundian.imc.common.base.BaseService;
import com.yundian.imc.entity.Station;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StationService extends BaseService<Station, Long> {
    Station findStationByStationId(String stationId);

    int countStationsByAreaCode(String area);
    Page<Station> findAllByDelFlagFalse(Pageable pageable);

}
