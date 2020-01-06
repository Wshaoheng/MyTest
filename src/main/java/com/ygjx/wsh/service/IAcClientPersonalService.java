package com.ygjx.wsh.service;

import com.ygjx.wsh.entity.AcClientPersonal;

import java.util.List;

/**
 * Created by strive on 2019/11/15
 */
public interface IAcClientPersonalService {
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
