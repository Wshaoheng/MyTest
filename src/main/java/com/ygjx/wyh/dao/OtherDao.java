package com.ygjx.wyh.dao;

import com.ygjx.wyh.entity.FundAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OtherDao {

    /**登录*/
    public List<FundAccount> login();
}
