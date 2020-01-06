package com.ygjx.wsh.dao;

import com.ygjx.wsh.entity.AcBank;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AcBankMapper {
    int deleteByPrimaryKey(Integer bankId);

    int insert(AcBank record);

    int insertSelective(AcBank record);

    AcBank selectByPrimaryKey(Integer bankId);

    int updateByPrimaryKeySelective(AcBank record);

    int updateByPrimaryKey(AcBank record);
}