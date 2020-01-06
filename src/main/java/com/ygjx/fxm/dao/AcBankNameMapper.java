package com.ygjx.fxm.dao;

import com.ygjx.fxm.entity.AcBankName;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcBankNameMapper {
    public List<AcBankName> getAllAcBankName();
    AcBankName findByBankid(Integer bankId);
}
