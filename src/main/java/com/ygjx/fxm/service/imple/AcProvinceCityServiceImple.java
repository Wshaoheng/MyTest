package com.ygjx.fxm.service.imple;

import com.ygjx.fxm.dao.AcCityMapper;
import com.ygjx.fxm.dao.AcProvinceMapper;
import com.ygjx.fxm.entity.AcCity;
import com.ygjx.fxm.entity.AcProvince;
import com.ygjx.fxm.service.AcProvinceCityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AcProvinceCityServiceImple implements AcProvinceCityService{
    @Resource
    AcProvinceMapper acProvinceMapper;
    @Resource
    AcCityMapper acCityMapper;
    public List<AcProvince> findAllProvince(){
        List<AcProvince> acProvinceList = acProvinceMapper.getAllProvince();
        return acProvinceList;
    }

    @Override
    public List<AcCity> getCityByCode(String code) {
        List<AcCity> acCities = acCityMapper.getCityByCode(code);
        return acCities;
    }
}
