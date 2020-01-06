package com.ygjx.wyq.dao;

import com.ygjx.wyq.entity.AcFundAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcFundAccountMapper {
    int deleteByPrimaryKey(String fundAccount);

    int insert(AcFundAccount record);

    int insertSelective(AcFundAccount record);

    AcFundAccount selectByPrimaryKey(String fundAccount);

    int updateByPrimaryKeySelective(AcFundAccount record);

    int updateByPrimaryKey(AcFundAccount record);


    AcFundAccount getById(String fundAccount);

    int update(AcFundAccount acFundAccount);

    List<AcFundAccount> jiao(AcFundAccount acFundAccount);

    AcFundAccount getByClientAccount(String clientAccount);

    List<AcFundAccount> hu(AcFundAccount acFundAccount);

    AcFundAccount getPersonById(String fundAccount);

    AcFundAccount getAccClientById(String fundAccount);

    AcFundAccount getClientAccount(String clientAccount);
}