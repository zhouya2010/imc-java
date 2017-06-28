package com.yundian.imc.service.impl;

import com.yundian.imc.common.base.BaseServiceImpl;
import com.yundian.imc.dao.StationDao;
import com.yundian.imc.entity.Station;
import com.yundian.imc.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StationServiceImpl extends BaseServiceImpl<Station, Long> implements StationService {

    @Autowired
    private StationDao stationDao;


    @Override
    public Station findStationByStationId(String stationId) {
        return stationDao.findStationByStationId(stationId);
    }

    @Override
    public int countStationsByAreaCode(String area) {
        return stationDao.countStationsByAreaCode(area);
    }

    @Override
    public Page<Station> findAllByDelFlagFalse(Pageable pageable) {
        return stationDao.findAllByDelFlagFalse(pageable);
    }

    @Override
    public Page<Station> searchByStationName(String stationName, Pageable pageable) {
        return stationDao.findAllByDelFlagFalseAndStationNameContains(stationName,pageable);

    }
}
