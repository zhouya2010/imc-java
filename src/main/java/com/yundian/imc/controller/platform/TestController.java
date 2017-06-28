package com.yundian.imc.controller.platform;


import com.yundian.imc.common.base.BaseResponse;
import com.yundian.imc.dao.PoleDao;
import com.yundian.imc.dao.StationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private StationDao stationDao;

    @Autowired
    private PoleDao poleDao;

    @RequestMapping(value = "aaa",method = RequestMethod.GET)
    public String stations(@RequestParam(value = "name",defaultValue = "谷峰") String name){
        System.err.println("======>stations");
        PageRequest pageRequest = new PageRequest(0, 20);
        return new BaseResponse(0,stationDao.findAllByDelFlagFalseAndStationNameContains(name,pageRequest).getContent(),"").toJson();
    }

    @RequestMapping(value = "zzz",method = RequestMethod.GET)
    public String zzz(@RequestParam(value = "name",defaultValue = "1234") String name){
        return new BaseResponse(0,poleDao.findPoleByPoleId(name),"").toJson();

    }
}
