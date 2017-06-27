package com.yundian.imc.dao;

import com.yundian.imc.common.base.BaseDao;
import com.yundian.imc.entity.Station;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StationDao extends BaseDao<Station, Long> {
    Station findStationByStationId(String stationId);
    int countStationsByAreaCode(String area);
    Page<Station> findAllByDelFlagFalse(Pageable pageable);

    /*
    *原生 SQL 方法
     */
    @Query(value = "select * from t_station where del_flag = false  limit 10 ",nativeQuery = true)
    List<Station> findAllByCustomQuery();

    /*
   *Spring Data SQL 方法
   */
    @Query(value = "select t from Station t where del_flag = false ")
    List<Station> findAllByCustomQuery2();

    List<Station> findTop10ByDelFlagFalse();
}
