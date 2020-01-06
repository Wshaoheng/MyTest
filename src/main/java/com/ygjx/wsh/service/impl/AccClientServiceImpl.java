package com.ygjx.wsh.service.impl;

import com.ygjx.utils.GetDateType;
import com.ygjx.wsh.dao.*;
import com.ygjx.wsh.entity.*;
import com.ygjx.wsh.service.IAccClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccClientServiceImpl  implements IAccClientService {
   @Autowired
   private AccClientMapper accClientMapper;
   @Autowired
   private AccOtherInfoMapper accOtherInfoMapper;
   @Autowired
   private AcCounterMapper acCounterMapper;

    /**
     * 机构开户
     * @param accClient
     * @param accOtherInfo
     *
     * @return
     */
   @Transactional
   @Override
    public AccClient create(AccClient accClient, AccOtherInfo accOtherInfo,AcAdmin acAdmin) {
       AcCounter acCounter = new AcCounter();
       Date date = new Date();
        long time =date.getTime();
        String accAccount=time+"";
        accClient.setAccAccount(accAccount);
        accClient.setIsClose(0);
        System.err.println(accAccount);
        accOtherInfo.setAccAccount(accAccount);

       AcCounter counter = new AcCounter();
       SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String operatingTime = sdf.format(date);
       counter.setOperatingTime(operatingTime);
       counter.setOperationType("机构开户");
       counter.setAdminId(acAdmin.getAdminId());
       counter.setClientAccount(accAccount);
       counter.setStatus(0);
        acCounterMapper.insert(counter);
        accOtherInfoMapper.insert(accOtherInfo);
        accClientMapper.insert(accClient);

        return accClient;
    }

    /**
     * 通过交易账号查询机构的基本信息
     * @param accAccount
     * @return
     */
    @Override
    public AccClient selectByPrimaryKey(String accAccount) {
        AccClient client =accClientMapper.selectByPrimaryKey(accAccount);
        return client;
    }

    @Override
    public AccClient getAccClient(AccClient accClient) {
        AccClient client = accClientMapper.selectByPrimaryKey(accClient.getAccAccount());
        return client;
    }

    /**
     * 修改页面查询显示的信息
     * @param accAccount
     * @param tradePassword
     * @return
     */
    @Override
    public Map<String,Object> getAccClientInfo(String accAccount/*, String tradePassword*/) {
        Map<String, Object> map = new HashMap<>();
        AccClient client = accClientMapper.selectByPrimaryKey(accAccount);
        AccOtherInfo accOtherInfo = accOtherInfoMapper.getAccOtherInfoByaccAccount(accAccount);
       /* if (!accAccount.equals(client.getAccAccount())&&!tradePassword.equals(client.getTradePassword())) {
            System.err.println("找不到客户信息");
        }
            if (tradePassword.equals(client.getTradePassword())) {
                map.put("accClient", client);
                map.put("accOtherInfo", accOtherInfo);
            } else {
                System.err.println("密码错误！！！");
            }*/

       if(client!=null&&accOtherInfo!=null){
           map.put("accClient", client);
           map.put("accOtherInfo", accOtherInfo);
       }else {
           System.err.println("交易账号错误！");
       }
        return map;
    }
    /**
     * 通过交易账号查询机构的其他信息
     * @param accAccount
     * @return
     */
    @Override
    public AccOtherInfo getAccOtherInfoByaccAccount(String accAccount) {
         AccOtherInfo otherInfo = accOtherInfoMapper.getAccOtherInfoByaccAccount(accAccount);
        return otherInfo;
    }

    @Autowired
    private AcBankMapper acBankMapper;

    /**
     * 机构开户显示的银行信息
     *
      * @param bankId
     * @return
     */
   @Override
    public AcBank selectByPrimaryKey(Integer bankId) {
        AcBank ab = acBankMapper.selectByPrimaryKey(bankId);
        return ab;
    }

    @Autowired
    private AcClientDocumentsMapper acdm;

    /**
     * 获取所有证件名称
      * @return
     */
   @Override
    public List<AcClientDocuments> findAll() {
        List<AcClientDocuments>  documents = acdm.getAll();
        return documents;
    }

    /**
     * 机构资料修改
     * @param accClient
     * @param accOtherInfo
     * @return
     */
    @Override
    public int  updateAccClientInfo(AccClient accClient,AccOtherInfo accOtherInfo,AcAdmin acAdmin) {
        AccClient client = accClientMapper.selectByPrimaryKey(accClient.getAccAccount());
        AccOtherInfo otherInfo = accOtherInfoMapper.getAccOtherInfoByaccAccount(accClient.getAccAccount());
        int j =0;
        AcCounter acCounter =new AcCounter();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String operatingTime = sdf.format(date);
        acCounter.setAdminId(acAdmin.getAdminId());
        acCounter.setClientAccount(client.getAccAccount());
        acCounter.setOperationType("机构修改资料");
        acCounter.setOperatingTime(operatingTime);
        acCounter.setStatus(0);
        acCounterMapper.insert(acCounter);
        if(client!=null&&otherInfo!=null){
            accClient.setProvince(client.getProvince());
            accClient.setCity(client.getCity());
            accOtherInfo.setLegalPersonId(otherInfo.getLegalPersonId());
            accClient.setIsClose(0);
            int i = accClientMapper.updateByPrimaryKeySelective(accClient);
            if(i>0){
                int i1 = accOtherInfoMapper.updateByPrimaryKeySelective(accOtherInfo);
                if(i1>0){
                    j=1;
                }
            }

        }
        if(j>0){
            return j;
        }else {
            return 0;
        }

    }

    /**
     * 机构销户
     * @param accClient
     * @return
     */
    @Override
    public int updateAccClient(AccClient accClient) {
        AccClient accClientByAccount = accClientMapper.getAccClientByAccount(accClient.getAccAccount());
        AcCounter acCounter =new AcCounter();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String operatingTime = sdf.format(date);
        acCounter.setAdminId(accClientByAccount.getAdminId());
        acCounter.setClientAccount(accClient.getAccAccount());
        acCounter.setOperationType("机构进行销户");
        acCounter.setOperatingTime(operatingTime);
        acCounter.setStatus(0);
        acCounterMapper.insert(acCounter);

        int i =accClientMapper.updateByPrimaryKeySelective(accClient);
        return i;
    }


}
