package com.ygjx.wsh.web;

import cn.hutool.db.Session;
import com.ygjx.fxm.dao.AcAdminMapper;
import com.ygjx.fxm.dao.AcBankNameMapper;
import com.ygjx.fxm.dao.AcProvinceMapper;
import com.ygjx.fxm.entity.AcBankName;
import com.ygjx.fxm.entity.AcCity;
import com.ygjx.fxm.entity.AcProvince;
import com.ygjx.fxm.service.AcProvinceCityService;
import com.ygjx.utils.GetDateType;
import com.ygjx.wsh.entity.*;
import com.ygjx.wsh.service.IAcCounterService;
import com.ygjx.wsh.service.IAccClientService;
import com.ygjx.wsh.service.IScoreService;
import com.ygjx.wyh.entity.FundAccount;
import com.ygjx.wyq.entity.AcFundAccount;
import com.ygjx.wyq.service.FundService;
import org.apache.zookeeper.KeeperException;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.nio.channels.SeekableByteChannel;
import java.rmi.ServerError;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 机构的控制器层
 */
@Controller
@RequestMapping("/accClient")
public class AccClientController {
    @Autowired
    private IAccClientService accClientService;
    @Autowired
    private IAcCounterService acCounterService;
    @Autowired
    private FundService fundService;
    @Autowired
    private IScoreService scoreService;
    @Autowired
    private AcBankNameMapper abnm;
    @Autowired
    private AcAdminMapper aam;

    /**
     * 机构开户
     * @param accClient
     * @param accOtherInfo
     * @param acBank
     * @param adminAccount
     * @param certificateValidity1
     * @param legalPeriodOfLegalPerson1
     * @param principalValidityPeriod1
     * @return
     */
    @RequestMapping("/addAccClient")
    public String add(AccClient accClient, AccOtherInfo accOtherInfo, AcBank acBank, String adminAccount, String certificateValidity1,
                      String legalPeriodOfLegalPerson1, String principalValidityPeriod1) {
        if (certificateValidity1 != null) {
            accClient.setCertificateValidity(certificateValidity1);
        }
        if (legalPeriodOfLegalPerson1 != null) {
            accOtherInfo.setLegalPeriodOfLegalPerson(legalPeriodOfLegalPerson1);
        }
        if (principalValidityPeriod1 != null) {
            accOtherInfo.setPrincipalValidityPeriod(principalValidityPeriod1);
        }
        AcAdmin admin = aam.findByAdminAccount(adminAccount);
        Integer adminId = admin.getAdminId();
        accClient.setAdminId(adminId);
        accClientService.create(accClient, accOtherInfo,admin);

        return "redirect:/toIndex2";
    }

    /**
     * 验证交易账号和密码来查询信息并展示
     * @param accAccount
     * @param tradePassword
     * @return
     */
    @RequestMapping("/toEditInfo")
    @ResponseBody
    public Map<String,Object> editInfo(@RequestParam("accAccount") String accAccount
                       /* @RequestParam("tradePassword") String tradePassword*/){
        Map<String,Object> map  = accClientService.getAccClientInfo(accAccount/*,tradePassword*/);

        return map;
    }

    /**
     * 获取所有证件名称
     * @return
     */
    @RequestMapping("/toAddDocuments")
    @ResponseBody
    public List<AcClientDocuments> getAllDocuments(){
        List<AcClientDocuments> documents = accClientService.findAll();
        return documents;
    }

    /**
     * 修改机构的基本信息和其他信息
     * @param accClient
     * @return
     */
    @PostMapping("/updateInfo")
    @ResponseBody
    public int   changeAccClient(AccClient accClient,AccOtherInfo otherInfo,AcAdmin acAdmin){
        int i = accClientService.updateAccClientInfo(accClient, otherInfo,acAdmin);
        if(i>0){
            return i;
        }else {
            return 0;
        }

    }

    /**
     * 机构销户
     * @param accClient
     * @return
     */
    @RequestMapping("/accClientClose")
    @ResponseBody
    public int updateAccClient(AccClient accClient){
        int i = accClientService.updateAccClient(accClient);
        return i;
    }

    @RequestMapping("/getAccClient")
    @ResponseBody
    public AccClient getAccClient(AccClient accClient){
        AccClient client = accClientService.getAccClient(accClient);
        return client;
    }

    @RequestMapping("/toAddScore")
    @ResponseBody
    public int  addScore(@RequestParam("total") Integer total,HttpSession session){
        FundAccount  afa =(FundAccount) session.getAttribute("fundAccount");
        AcFundAccount acFundAccount = fundService.getClientAccount(afa.getClientAccount());
        System.err.println(afa.getClientAccount());
        System.err.println(acFundAccount.getClientName());
        afa.setClientName(acFundAccount.getClientName());
        Score score =new Score();
        score.setClientAccount(acFundAccount.getClientAccount());
        score.setClientScore(total);
        int  i = scoreService.addScore(score);
        return i;
    }



}
