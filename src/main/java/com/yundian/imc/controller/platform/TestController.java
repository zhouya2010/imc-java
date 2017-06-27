package com.yundian.imc.controller.platform;


import com.yundian.imc.common.base.BaseResponse;
import com.yundian.imc.dao.StationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private StationDao stationDao;

    @RequestMapping(value = "aaa",method = RequestMethod.GET)
    public String stations(){
        System.err.println("======>stations");
        return new BaseResponse(0,stationDao.findAllByCustomQuery(),"").toJson();
    }

    @RequestMapping(value = "zzz",method = RequestMethod.GET)
    public String zzz(){
        return new BaseResponse(0,stationDao.findTop10ByDelFlagFalse(),"").toJson();

    }
}
