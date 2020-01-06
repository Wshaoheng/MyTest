package com.ygjx.wyq.service.impl;

import com.ygjx.fxm.dao.AcClientMapper;
import com.ygjx.fxm.entity.AcClient;
import com.ygjx.wsh.dao.AcCounterMapper;
import com.ygjx.wsh.dao.AccClientMapper;
import com.ygjx.wsh.entity.AcCounter;
import com.ygjx.wsh.entity.AccClient;
import com.ygjx.wyq.dao.AcFundAccountMapper;
import com.ygjx.wyq.entity.AcFundAccount;
import com.ygjx.wyq.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private AccClientMapper accClientMapper;
    @Autowired
    private AcClientMapper acClientMapper;
    @Autowired
    private AcFundAccountMapper acFundAccountMapper;
    @Autowired
    private AcCounterMapper acCounterMapper;

    @Override
    public AcClient getAcClientByAccount(String clientAccount) {
        return acClientMapper.getAcClientByAccount(clientAccount);
    }

    @Override
    public AccClient getAccClientByAccount(String accAccount) {
        return accClientMapper.getAccClientByAccount(accAccount);
    }

    @Override
    public int addAccClient(AccClient accClient) {
        return accClientMapper.addAccClient(accClient);
    }

    @Override
    public int addAcFundAccount(AcFundAccount acFundAccount) {
        return acFundAccountMapper.insertSelective(acFundAccount);
    }

    @Override
    public AcCounter getById(Integer counterId) {
        return acCounterMapper.selectByPrimaryKey(counterId);
    }

    @Override
    public int addAcClient(AcClient acClient) {
        return acClientMapper.addAcClient(acClient);
    }

}
