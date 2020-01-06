package com.ygjx.fxm.dao;

import com.ygjx.fxm.entity.AcAgent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AcAgentMapper {
    int insertSelective(AcAgent record);
}
