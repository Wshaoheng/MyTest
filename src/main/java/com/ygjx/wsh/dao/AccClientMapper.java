package com.ygjx.wsh.dao;

import com.ygjx.wsh.entity.AccClient;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccClientMapper {
    int deleteByPrimaryKey(String accAccount);

    int insert(AccClient record);

    int insertSelective(AccClient record);

    AccClient selectByPrimaryKey(String accAccount);

    int updateByPrimaryKeySelective(AccClient record);

    int updateByPrimaryKey(AccClient record);

    AccClient getAccClientByAccount(String accAccount);

    int addAccClient(AccClient accClient);
}