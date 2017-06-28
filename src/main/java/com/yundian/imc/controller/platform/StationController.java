package com.yundian.imc.controller.platform;

import com.yundian.imc.entity.Pole;
import com.yundian.imc.entity.Station;
import com.yundian.imc.service.StationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("admin")
public class StationController {

    private Logger logger = LoggerFactory.getLogger(StationController.class);


    @Autowired
    private StationService stationService;

    @RequestMapping(value = "stations", method = RequestMethod.GET)
    public String getStations(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                              @RequestParam(name = "size", defaultValue = "20", required = false) int size,
                              @RequestParam(name = "stationName", defaultValue = "", required = false) String stationName,
                              ModelMap model) {
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();

        PageRequest pageRequest = new PageRequest(page, size);
        Page<Station> stationPage;
        if (stationName.length() > 0) {
            stationPage = stationService.searchByStationName(stationName,pageRequest);
        }
        else {
            stationPage = stationService.findAllByDelFlagFalse(pageRequest);
        }
        model.addAttribute("stations", stationPage.getContent());
        model.addAttribute("total", stationPage.getTotalPages());
        model.addAttribute("page",page);
        model.addAttribute("size",size);

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
        model.addAttribute("page",0);
        model.addAttribute("size",20);
        return "stations";
    }

    @RequestMapping(value = "stations/{stationId}", method = RequestMethod.GET)
    public String getStation(@PathVariable String stationId, ModelMap model) {
        model.addAttribute("station", stationService.findStationByStationId(stationId));
        return "station-edit";
    }

    //待完善
    @RequestMapping(value = "stations/{stationId}", method = RequestMethod.DELETE)
    public String deleteStation(@PathVariable String stationId, ModelMap model) {
        Station station =  stationService.findStationByStationId(stationId);
        station.setDelFlag(true);
        stationService.save(station);
        model.addAttribute("station", stationService.findStationByStationId(stationId));
        return "station-edit";
    }

    @RequestMapping(value = "stations/new", method = RequestMethod.GET)
    public String newStation() {
        return "station-new";
    }

    @RequestMapping(value = "stations/details/{stationId}", method = RequestMethod.GET)
    public String detailsStation(@PathVariable String stationId, ModelMap model) {
        Station station =  stationService.findStationByStationId(stationId);
//        station.getPoles().forEach(pole -> System.err.println("poleId ==>" + pole.getPoleId()));
//        station.getPoles().forEach(pole -> Optional.ofNullable(pole.getConnectors()).ifPresent(connectors -> connectors.forEach(connector ->System.err.println("connectorId ==>" + connector.getConnectorId()))));

        if (station.getPoles() != null) {
            for (Pole pole : station.getPoles()){
                if (pole.getConnectors() != null) {
                    System.err.println("connectorId ==>" +  pole.getConnectors().size());
                }
            }
        }
        model.addAttribute("station", station);
        return "station-details";
    }

}
