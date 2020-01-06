package com.ygjx.fxm.dao;

import com.ygjx.fxm.entity.AcClient;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AcClientMapper {
    int insertSelective(AcClient record);

    AcClient getAcClientByAccount(String clientAccount);

    int updateByPrimaryKeySelective(AcClient acClient);

    int addAcClient(AcClient acClient);
}
