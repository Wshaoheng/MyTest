package com.ygjx.fxm.dao;

import com.ygjx.fxm.entity.AcCity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AcCityMapper {
    public List<AcCity> getCityByCode(String code);
}
