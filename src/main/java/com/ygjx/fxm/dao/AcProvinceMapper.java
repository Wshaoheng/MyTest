package com.ygjx.fxm.dao;

import com.ygjx.fxm.entity.AcProvince;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcProvinceMapper {
    public List<AcProvince> getAllProvince();
}
