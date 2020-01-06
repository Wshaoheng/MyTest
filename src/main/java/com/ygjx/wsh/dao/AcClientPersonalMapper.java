package com.ygjx.wsh.dao;

import com.ygjx.wsh.entity.AcClientPersonal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AcClientPersonalMapper {
    int deleteByPrimaryKey(Integer clientId);

    int insert(AcClientPersonal record);

    int insertSelective(AcClientPersonal record);

    AcClientPersonal selectByPrimaryKey(Integer clientId);

    int updateByPrimaryKeySelective(AcClientPersonal record);

    int updateByPrimaryKey(AcClientPersonal record);

    /**
     * 根据交易账号查询所有的选项
     * @param acount
     * @return
     */
    List<AcClientPersonal> getByclientAccount(String acount);

    /**
     * 根据题号查询所选项
     * @param clientPersonalId
     * @return
     */
    AcClientPersonal getByclientPersonalId(Integer clientPersonalId);
}