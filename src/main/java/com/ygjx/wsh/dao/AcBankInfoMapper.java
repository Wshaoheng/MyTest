package com.ygjx.wsh.dao;

import com.ygjx.wsh.entity.AcBankInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AcBankInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AcBankInfo record);

    AcBankInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(AcBankInfo record);
}
