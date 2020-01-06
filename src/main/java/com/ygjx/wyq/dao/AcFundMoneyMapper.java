package com.ygjx.wyq.dao;

import com.ygjx.wyq.entity.AcFundAccount;
import com.ygjx.wyq.entity.AcFundMoney;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AcFundMoneyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AcFundMoney record);

    int insertSelective(AcFundMoney record);

    AcFundMoney selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AcFundMoney record);

    int updateByPrimaryKey(AcFundMoney record);

    List<AcFundMoney> getAcFundMoneyById(Integer id);

    List<AcFundMoney> mo(AcFundAccount acFundAccount);

    List<AcFundMoney> list();

    int update(Integer id);

    AcFundMoney getByFundCode(String fundCode);

    List<AcFundMoney> getByFundCodeList(@Param("fundCode") String fundCode,@Param("counterId") Integer counterId);
}