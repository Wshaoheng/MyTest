package com.ygjx.wyq.dao;


import com.ygjx.wyq.entity.FundRisk;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FundRiskMapper {
    int deleteByPrimaryKey(Integer riskId);

    int insert(FundRisk record);

    int insertSelective(FundRisk record);

    FundRisk selectByPrimaryKey(Integer riskId);

    int updateByPrimaryKeySelective(FundRisk record);

    int updateByPrimaryKey(FundRisk record);

    List<FundRisk> getFundRisk();
}