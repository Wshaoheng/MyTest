package com.ygjx.wyq.service.impl;

import com.ygjx.wsh.dao.AccClientMapper;
import com.ygjx.wsh.dao.ScoreMapper;
import com.ygjx.wsh.entity.Score;
import com.ygjx.wyh.dao.FundRedemptionDao;
import com.ygjx.wyh.entity.Counter;
import com.ygjx.wyq.dao.*;
import com.ygjx.wyq.entity.*;
import com.ygjx.wyq.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FundServiceImpl implements FundService{
    @Autowired
    private FundTypeMapper fundTypeMapper;
    @Autowired
    private FundRiskMapper fundRiskMapper;
    @Autowired
    private AcFundAccountMapper acFundAccountMapper;
    @Autowired
    private AcFundMoneyMapper acFundMoneyMapper;
    @Autowired
    private AcFundMapper acFundMapper;
    @Autowired
    private AccClientMapper accClientMapper;
    @Autowired
    private FundRedemptionDao fundRedemptionDao;
    @Autowired
    private AcFundInfoMapper acFundInfoMapper;
    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public List<AcFundMoney> list() {
        List<AcFundMoney> list = acFundMoneyMapper.list();
        return list;
    }

    @Override
    public List<AcFundMoney> mo(AcFundAccount acFundAccount) {
        return acFundMoneyMapper.mo(acFundAccount);
    }

    @Override
    public List<AcFundAccount> hu(AcFundAccount acFundAccount) {
        return acFundAccountMapper.hu(acFundAccount);
    }

    @Override
    public AcFundAccount getPersonById(String fundAccount) {
        return acFundAccountMapper.getPersonById(fundAccount);
    }

    @Override
    public AcFundAccount getAccClientById(String fundAccount) {
        return acFundAccountMapper.getAccClientById(fundAccount);
    }

    @Override
    public List<AcFund> getList() {
        return acFundMapper.getList();
    }

    @Override
    public int inserBillInfo(Counter counter) {
        return fundRedemptionDao.inserBillInfo(counter);
    }

    @Override
    public AcFundMoney getByFundCode(String fundCode) {
        return acFundMoneyMapper.getByFundCode(fundCode);
    }

    @Override
    public AcFundAccount getClientAccount(String clientAccount) {
        return acFundAccountMapper.getClientAccount(clientAccount);
    }

    @Override
    public List<FundType> getFundTypeList() {
        return fundTypeMapper.getFundTypeList();
    }

    @Override
    public List<AcFundMoney> getByFundCodeList(String fundCode, Integer counterId) {
        return acFundMoneyMapper.getByFundCodeList(fundCode,counterId);
    }

    @Override
    public AcFund getByFundName(String fundName) {
        return acFundMapper.getByFundName(fundName);
    }

    @Override
    public int addAcFundMoney(AcFundMoney acFundMoney) {
        return acFundMoneyMapper.insertSelective(acFundMoney);
    }

    @Override
    public int addAcFundInfo(AcFundInfo acFundInfo) {
        return acFundInfoMapper.insertSelective(acFundInfo);
    }

    @Override
    public Score getScoreById(String clientAccount) {
        return scoreMapper.selectByPrimaryKey(clientAccount);
    }

    @Override
    public  AcFundAccount getById(String fundAccount) {
        AcFundAccount ac = acFundAccountMapper.getById(fundAccount);
        return ac;
    }

    @Override
    public int update(AcFundMoney acFundMoney) {
        return acFundMoneyMapper.updateByPrimaryKeySelective(acFundMoney);
    }

    @Override
    public int updateAcFundMoney(AcFundMoney acFundMoney) {
        return acFundMoneyMapper.updateByPrimaryKeySelective(acFundMoney);
    }

    @Override
    public int updateAcFund(AcFund acFund) {
        return acFundMapper.updateByPrimaryKeySelective(acFund);
    }

    @Override
    public List<AcFundAccount> jiao(AcFundAccount acFundAccount) {
        return acFundAccountMapper.jiao(acFundAccount);
    }

    @Override
    public List<AcFundMoney> getAcFundMoneyById(Integer id) {
        return acFundMoneyMapper.getAcFundMoneyById(id);
    }

    @Override
    public AcFundAccount getByClientAccount(String clientAccount) {
        return acFundAccountMapper.getByClientAccount(clientAccount);
    }
}
