package com.ygjx.wyq.dao;


import com.ygjx.wyq.entity.FundType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FundTypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(FundType record);

    int insertSelective(FundType record);

    FundType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(FundType record);

    int updateByPrimaryKey(FundType record);

    List<FundType> getFundType();

    List<FundType> getFundTypeList();
}