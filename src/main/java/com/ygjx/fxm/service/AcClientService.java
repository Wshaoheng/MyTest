package com.ygjx.fxm.service;

import com.ygjx.fxm.entity.AcAgent;
import com.ygjx.fxm.entity.AcClient;
import com.ygjx.fxm.entity.AcLaundering;
import com.ygjx.wsh.entity.AcAdmin;


public interface AcClientService {
    int addAcClient(AcClient acClient, AcAdmin acAdmin, AcLaundering acLaundering);
    int addAcClientAcAgent(AcClient acClient, AcAgent acAgent,AcAdmin acAdmin,AcLaundering acLaundering);
    AcClient findAcClient(AcClient acClient);
    int updateAcClient(AcClient acClient, AcLaundering acLaundering);
    int updateAcClient(AcClient acClient);
}
