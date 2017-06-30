package com.yundian.imc.controller.platform;

import com.yundian.imc.entity.Pole;
import com.yundian.imc.service.PoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class PoleController {

    private Logger logger = LoggerFactory.getLogger(PoleController.class);


    @Autowired
    private PoleService poleService;

    @RequestMapping(value = "pole", method = RequestMethod.GET)
    public String getAllPole(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                              @RequestParam(name = "size", defaultValue = "20", required = false) int size,
                              @RequestParam(name = "poleId", defaultValue = "", required = false) String poleId,
                              ModelMap model) {

        PageRequest pageRequest = new PageRequest(page, size);
        Page<Pole> polePage;
        if (poleId.length() > 0) {
            polePage = poleService.searchPole(poleId, pageRequest);
        } else {
            polePage = poleService.findAllByDelFlagFalse(pageRequest);
        }
        model.addAttribute("poles", polePage.getContent());
        model.addAttribute("total", polePage.getTotalPages());
        model.addAttribute("page", page);
        model.addAttribute("size", size);

        return "pole";
    }

//    @RequestMapping(value = "stations", method = RequestMethod.POST)
//    public String createStations(@Valid Station station, ModelMap model) {
//        if (station.getStationId() == null || station.getStationId().equals("")) {
//            int count = stationService.countStationsByAreaCode(station.getAreaCode()) + 1;
//            station.setStationId(station.getAreaCode() + String.format("%05d", count) + String.format("%04d", (int) (Math.random() * 10000)));
//        }
//        stationService.save(station);
//        PageRequest pageRequest = new PageRequest(0, 20);
//        Page<Station> stationPage = stationService.findAll(pageRequest);
//
//        model.addAttribute("stations", stationPage.getContent());
//        model.addAttribute("total", stationPage.getTotalPages());
//        model.addAttribute("page", 0);
//        model.addAttribute("size", 20);
//        return "stations";
//    }
//
//    @RequestMapping(value = "stations", method = RequestMethod.PUT, produces = {"application/json"})
//    @ResponseBody
//    public String updateStations(@RequestBody @Valid Station station, ModelMap model) {
//
//
//        stationService.save(station);
////        PageRequest pageRequest = new PageRequest(0, 20);
////        Page<Station> stationPage = stationService.findAll(pageRequest);
////
////        model.addAttribute("stations", stationPage.getContent());
////        model.addAttribute("total", stationPage.getTotalPages());
////        model.addAttribute("page",0);
////        model.addAttribute("size",20);
//
//        System.err.println("stations PUT");
//        System.err.println("stations===>" + station.getStationId());
//        System.err.println("stations===>" + station.getAddress());
//        System.err.println("stations===>" + station.getBusineHours());
//        System.err.println("stations===>" + station.getConstruction());
//        System.err.println("stations===>" + station.getStationStatus());
//
//        return new BaseResponse(0, "hello word").toJson();
//    }
//
//    @RequestMapping(value = "stations/{stationId}", method = RequestMethod.GET)
//    public String getStation(@PathVariable String stationId, ModelMap model) {
//        model.addAttribute("station", stationService.findStationByStationId(stationId));
//        return "station-edit";
//    }
//
//    //待完善
//    @RequestMapping(value = "stations/{stationId}", method = RequestMethod.DELETE)
//    public String deleteStation(@PathVariable String stationId, ModelMap model) {
//        Station station = stationService.findStationByStationId(stationId);
//        station.setDelFlag(true);
//        stationService.save(station);
//        model.addAttribute("station", stationService.findStationByStationId(stationId));
//        return "station-edit";
//    }
//
//    @RequestMapping(value = "stations/new", method = RequestMethod.GET)
//    public String newStation() {
//        return "station-new";
//    }

    @RequestMapping(value = "pole/details/{id}", method = RequestMethod.GET)
    public String detailsStation(@PathVariable Long id, ModelMap model) {
        Pole pole = poleService.findOne(id);
        model.addAttribute("pole", pole);
        return "pole-details";
    }

}
