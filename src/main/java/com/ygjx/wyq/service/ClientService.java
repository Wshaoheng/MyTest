package com.ygjx.wyq.service;

import com.ygjx.fxm.entity.AcClient;
import com.ygjx.wsh.entity.AcCounter;
import com.ygjx.wsh.entity.AccClient;
import com.ygjx.wyq.entity.AcFundAccount;

public interface ClientService {
    AcClient getAcClientByAccount(String clientAccount);

    AccClient getAccClientByAccount(String accAccount);

    int addAccClient(AccClient accClient);

    int addAcFundAccount(AcFundAccount acFundAccount);

    AcCounter getById(Integer counterId);

    int addAcClient(AcClient acClient);
}
