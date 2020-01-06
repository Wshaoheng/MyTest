package com.ygjx.fxm.service;

import com.ygjx.fxm.entity.AcCity;
import com.ygjx.fxm.entity.AcProvince;

import java.util.List;

public interface AcProvinceCityService {
    public List<AcProvince> findAllProvince();
    public List<AcCity> getCityByCode(String code);
}
