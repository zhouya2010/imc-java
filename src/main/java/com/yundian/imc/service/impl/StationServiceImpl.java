package com.yundian.imc.service.impl;

import com.yundian.imc.common.base.BaseServiceImpl;
import com.yundian.imc.dao.StationDao;
import com.yundian.imc.entity.Station;
import com.yundian.imc.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StationServiceImpl extends BaseServiceImpl<Station, Long> implements StationService {

    @Autowired
    private StationDao stationDao;


    @Override
    public Station findStationByStationId(String stationId) {
        return stationDao.findStationByStationId(stationId);
    }
}
