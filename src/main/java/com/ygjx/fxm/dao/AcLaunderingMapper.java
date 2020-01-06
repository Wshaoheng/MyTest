package com.ygjx.fxm.dao;

import com.ygjx.fxm.entity.AcLaundering;

public interface AcLaunderingMapper {
    int deleteByPrimaryKey(Integer laundId);

    int insert(AcLaundering record);

    int insertSelective(AcLaundering record);

    AcLaundering selectByPrimaryKey(Integer laundId);

    AcLaundering selectByClientAcCount(String laundAccount);

    int updateByPrimaryKeyAccount(AcLaundering record);

    int updateByPrimaryKey(AcLaundering record);
}