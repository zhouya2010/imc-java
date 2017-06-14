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

import java.util.Optional;

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

    @RequestMapping(value = "stations/{id}",method = RequestMethod.GET)
    public String getStation(@PathVariable Long id, ModelMap model) {
        model.addAttribute("station",stationService.findOne(id));
//        System.out.println(stationService.findOne(id).getPoles().size());
//        System.out.println("====>" + Optional.of(stationService.findOne(id).getPoles()).isPresent());
        return "station-edit";
    }

}
