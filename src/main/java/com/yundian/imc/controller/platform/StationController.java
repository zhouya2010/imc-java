package com.yundian.imc.controller.platform;

import com.yundian.imc.entity.Station;
import com.yundian.imc.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin")
public class StationController {

    @Autowired
    private StationService stationService;

    @RequestMapping(value = "stations",method = RequestMethod.GET)
    public String getStations(@RequestParam(name = "page",defaultValue = "0",required = false) int page,
                              @RequestParam(name = "size",defaultValue = "20",required = false) int size,
                              ModelMap model) {

        PageRequest pageRequest = new PageRequest(page,size);
        Page<Station> stationPage = stationService.findAll(pageRequest);

        stationPage.getContent().forEach(station -> System.out.println(station.getStationId() + "    " + station.getPoles().size()));

        model.addAttribute("stations", stationPage.getContent());
        model.addAttribute("total",stationPage.getTotalPages());
        return "stations";
    }

    @RequestMapping(value = "stations/{stationId}",method = RequestMethod.GET)
    public String getStation(@PathVariable String stationId, ModelMap model) {
        System.err.println("id ======> "+ stationId);

//        model.addAttribute("station",stationService.findOne(id));
        model.addAttribute("station",stationService.findStationByStationId(stationId));
//        System.out.println(stationService.findOne(id).getPoles().size());
        System.out.println("====>" + stationService.findStationByStationId(stationId).getPoles().size());
        return "station-edit";
    }

}
