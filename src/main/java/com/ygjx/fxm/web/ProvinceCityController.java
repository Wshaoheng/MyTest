package com.ygjx.fxm.web;

import com.ygjx.fxm.entity.AcCity;
import com.ygjx.fxm.entity.AcProvince;
import com.ygjx.fxm.service.AcProvinceCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProvinceCityController {
    @Autowired
    AcProvinceCityService acProvinceCityService;
    @RequestMapping("/getAllProvince")
    public List<AcProvince> getAllProvince(){
        List<AcProvince> acProvinceList =  acProvinceCityService.findAllProvince();
        return acProvinceList;
    }
    @RequestMapping("getCityByCode")
    public List<AcCity> getCityByCode(String code){
        List<AcCity> acCities =  acProvinceCityService.getCityByCode(code);
        return acCities;
    }
}
