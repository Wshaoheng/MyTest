package com.ygjx.wsh.dao;

import com.ygjx.wsh.entity.AccOtherInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccOtherInfoMapper {
    int deleteByPrimaryKey(Integer legalPersonId);

    int insert(AccOtherInfo record);

    /**
     * 通过accAccount查找AccOtherInfo
     * @param accAccount
     * @return
     */
    AccOtherInfo getAccOtherInfoByaccAccount(String accAccount);

    AccOtherInfo selectByPrimaryKey(Integer legalPersonId);

    int updateByPrimaryKeySelective(AccOtherInfo record);

    int updateByPrimaryKey(AccOtherInfo record);
}