package com.ygjx.wsh.service;



import com.ygjx.wsh.entity.*;

import java.util.List;
import java.util.Map;


public interface IAccClientService {

    /**
     * 机构开户
     *
     * @param accClient
     * @param
     * @param accOtherInfo
     *
     * @return
     */
    AccClient create(AccClient accClient, AccOtherInfo accOtherInfo, AcAdmin acAdmin);

    /**
     * 根据交易账号查询机构信息
     * @param accAccount
     * @return
     */
    AccClient selectByPrimaryKey(String accAccount);
    AccClient getAccClient(AccClient accClient);

    /**
     * 验证交易账号和密码
     * @param accAccount
     * @param
     * @return
     */
    Map<String,Object> getAccClientInfo(String accAccount/*, String tradePassword*/);
    /**
     * 通过accAccount查找AccOtherInfo
     * @param accAccount
     * @return
     */
    AccOtherInfo getAccOtherInfoByaccAccount(String accAccount);

    /**
     * 通过bankId来查找AcBank
     * @param bankId
     * @return
     */
    AcBank selectByPrimaryKey(Integer bankId);

    /**
     *查询所有身份的证件类型
     * @return
     */
    List<AcClientDocuments> findAll();

    /**
     * 修改机构的基本信息
     * @param accClient
     * @return
     */
    int   updateAccClientInfo(AccClient accClient,AccOtherInfo accOtherInfo,AcAdmin acAdmin);

    /**
     * 机构销户
     * @param accClient
     * @return
     */
    int updateAccClient(AccClient accClient);

}
