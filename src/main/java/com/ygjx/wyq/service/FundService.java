package com.ygjx.wyq.service;

import com.ygjx.wsh.entity.Score;
import com.ygjx.wyh.entity.Counter;
import com.ygjx.wyq.entity.*;

import java.util.List;

public interface FundService {


    AcFundAccount getById(String fundAccount);

    int update(AcFundMoney acFundMoney);

    int updateAcFundMoney(AcFundMoney acFundMoney);

    int updateAcFund(AcFund acFund);

    List<AcFundAccount> jiao(AcFundAccount acFundAccount);

    List<AcFundMoney> getAcFundMoneyById(Integer id);

    AcFundAccount getByClientAccount(String clientAccount);

    List<AcFundMoney> list();

    List<AcFundMoney> mo(AcFundAccount acFundAccount);

    List<AcFundAccount> hu(AcFundAccount acFundAccount);

    AcFundAccount getPersonById(String fundAccount);

    AcFundAccount getAccClientById(String fundAccount);

    List<AcFund> getList();

    int inserBillInfo(Counter counter);

    AcFundMoney getByFundCode(String fundCode);

    AcFundAccount getClientAccount(String clientAccount);

    List<FundType> getFundTypeList();

    List<AcFundMoney> getByFundCodeList(String fundCode, Integer counterId);

    AcFund getByFundName(String fundName);

    int addAcFundMoney(AcFundMoney acFundMoney);

    int addAcFundInfo(AcFundInfo acFundInfo);

    Score getScoreById(String clientAccount);
}
