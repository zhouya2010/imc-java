package com.yundian.imc.controller.platform;


import com.yundian.imc.common.base.BaseResponse;
import com.yundian.imc.common.enums.ConstructionEnum;
import com.yundian.imc.common.enums.PoleTypeEnum;
import com.yundian.imc.common.enums.StationStatusEnum;
import com.yundian.imc.common.enums.StationTypeEnum;
import com.yundian.imc.dao.PoleDao;
import com.yundian.imc.dao.StationDao;
import com.yundian.imc.entity.Pole;
import com.yundian.imc.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private StationDao stationDao;

    @Autowired
    private PoleDao poleDao;

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String stations(@RequestParam(value = "name",defaultValue = "谷峰") String name){
        System.err.println("======>stations");

        Station station = new Station();
        station.setStationId("2017062904");
        station.setStationName("zy1111");
        station.setAddress("办公室");
        station.setAreaCode("320113");
        station.setOperatorId("783840483");
        station.setEquipmentOwnerId("MA1MDPK80");
        station.setCountryCode("cn");
        station.setAddress("江苏省南京市江宁区博爱路1号");
        station.setServiceTel("400-83338910");
        station.setStationTel("400-83338910");
        station.setStationStatus(StationStatusEnum.PENDING_REVIEW);
        station.setConstruction(ConstructionEnum.BUILDING_PARKING);
        station.setParkNums((short) 50);
        station.setStationLat(118.881308);
        station.setStationLng(118.881308);
        station.setSiteGuide("地下一层");
        station.setMatchCarsDesc("car");
        station.setParkInfo("34 park");
        station.setBusineHours("8:00 ~24:00");
        station.setElectricityFeeDesc("8:00 ~24:00");
        station.setServiceFeeDesc("8:00 ~24:00");
        station.setParkFeeDesc("8:00 ~24:00");
        station.setPaymentType("card and app");
        station.setSupportOrder(false);
        station.setRemark("test");
        station.setStationType(StationTypeEnum.LOGISTICS);

        Station station1 = new Station();
        station1.setStationId("2017062901");

//        Station station2 = stationDao.findStationByStationId("2017062903");

        Pole pole = new Pole();
        pole.setStation(station);
        pole.setPoleId("pole0003");
        pole.setManufacturerId("783840483");
        pole.setManufacturerName("云电");
        pole.setPoleType(PoleTypeEnum.DC);
        pole.setProductionDate(new Date());
        pole.setPoleLat(station.getStationLat());
        pole.setPoleLng(station.getStationLng());
        pole.setPower(30.0);
        pole.setPoleName("1号");
        pole.setPoleModel("model");

        Pole pole2 = new Pole();
        pole2.setStation(station);
        pole2.setPoleId("pole0004");
        pole2.setManufacturerId("783840483");
        pole2.setManufacturerName("云电");
        pole2.setPoleType(PoleTypeEnum.DC);
        pole2.setProductionDate(new Date());
        pole2.setPoleLat(station.getStationLat());
        pole2.setPoleLng(station.getStationLng());
        pole2.setPower(30.0);
        pole2.setPoleName("1号");
        pole2.setPoleModel("model");

        List<Pole> poles = new ArrayList<>();
        poles.add(pole);
        poles.add(pole2);

        station.setPoles(poles);
        stationDao.save(station);
        return new BaseResponse(0,"").toJson();
    }

    @RequestMapping(value = "zzz",method = RequestMethod.GET)
    public String zzz(@RequestParam(value = "name",defaultValue = "1234") String name){
        poleDao.delete(323L);

        return new BaseResponse(0,"").toJson();

    }

    @RequestMapping(value = "bbb",method = RequestMethod.GET)
    public String bbb(){
//        stationDao.delete(304L);

        return new BaseResponse(0,stationDao.findOne(2L),"").toJson();

    }
}
