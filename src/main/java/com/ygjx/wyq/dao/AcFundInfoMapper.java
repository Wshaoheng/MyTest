package com.ygjx.wyq.dao;

import com.ygjx.wyq.entity.AcFundInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AcFundInfoMapper {
    int deleteByPrimaryKey(Integer fundInfoId);

    int insert(AcFundInfo record);

    int insertSelective(AcFundInfo record);

    AcFundInfo selectByPrimaryKey(Integer fundInfoId);

    int updateByPrimaryKeySelective(AcFundInfo record);

    int updateByPrimaryKey(AcFundInfo record);
}