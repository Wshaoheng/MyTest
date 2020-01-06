package com.ygjx.wyq.dao;

import com.ygjx.wyq.entity.AcFund;
import com.ygjx.wyq.entity.AcFundMoney;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcFundMapper {
    int deleteByPrimaryKey(Integer fundId);

    int insert(AcFund record);

    int insertSelective(AcFund record);

    AcFund selectByPrimaryKey(Integer fundId);

    int updateByPrimaryKeySelective(AcFund record);

    int updateByPrimaryKey(AcFund record);

    List<AcFund> getList();

    AcFund getByFundName(String fundName);
}