package com.yundian.imc.controller.platform;

import com.yundian.imc.entity.Station;
import com.yundian.imc.service.StationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("admin")
public class StationController {

    private Logger logger = LoggerFactory.getLogger(StationController.class);


    @Autowired
    private StationService stationService;

    @RequestMapping(value = "stations", method = RequestMethod.GET)
    public String getStations(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                              @RequestParam(name = "size", defaultValue = "20", required = false) int size,
                              ModelMap model) {

        PageRequest pageRequest = new PageRequest(page, size);
        Page<Station> stationPage = stationService.findAll(pageRequest);

        model.addAttribute("stations", stationPage.getContent());
        model.addAttribute("total", stationPage.getTotalPages());
        return "stations";
    }

    @RequestMapping(value = "stations", method = RequestMethod.POST)
    public String createStations( @Valid Station station, ModelMap model) {
        if (station.getStationId() == null || station.getStationId().equals("")) {
            int count = stationService.countStationsByAreaCode(station.getAreaCode()) + 1;
            station.setStationId(station.getAreaCode() + String.format("%05d", count) + String.format("%04d", (int) (Math.random() * 10000)));
        }
        stationService.save(station);
        PageRequest pageRequest = new PageRequest(0, 20);
        Page<Station> stationPage = stationService.findAll(pageRequest);

        model.addAttribute("stations", stationPage.getContent());
        model.addAttribute("total", stationPage.getTotalPages());
        return "stations";
    }

    @RequestMapping(value = "stations/{stationId}", method = RequestMethod.GET)
    public String getStation(@PathVariable String stationId, ModelMap model) {
        model.addAttribute("station", stationService.findStationByStationId(stationId));
        return "station-edit";
    }

    @RequestMapping(value = "stations/new", method = RequestMethod.GET)
    public String newStation() {
        return "station-new";
    }

}
