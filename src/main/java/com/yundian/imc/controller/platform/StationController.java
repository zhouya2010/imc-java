package com.yundian.imc.controller.platform;

import com.yundian.imc.dao.StationDao;
import com.yundian.imc.entity.Station;
import com.yundian.imc.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class StationController {

    @Autowired
    private StationService stationService;

    @RequestMapping(value = "stations",method = RequestMethod.GET)
    public String getStations(@RequestParam(name = "page",defaultValue = "0",required = false) int page,
                              @RequestParam(name = "size",defaultValue = "20",required = false) int size) {

        PageRequest pageRequest = new PageRequest(page,size);
        Page<Station> stationPage = stationService.findAll(pageRequest);

        System.out.println("total 1===>" + stationPage.getTotalPages());
        System.out.println("total 2===>" + stationPage.getTotalElements());
        stationPage.getContent().forEach(station ->System.out.println( station.getStationId()));
        return "station";
    }

}
