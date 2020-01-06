package com.ygjx.fxm.web;

import com.ygjx.fxm.entity.AcAgent;
import com.ygjx.fxm.entity.AcClient;
import com.ygjx.fxm.entity.AcLaundering;
import com.ygjx.fxm.service.AcClientService;
import com.ygjx.utils.GetDateType;
import com.ygjx.wsh.entity.AcAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AcClientController {
    @Autowired(required = true)
    private AcClientService acClientService;

    /**
     * 添加客户（客户开户）
     * @param acClient 客户信息
     * @param acAgent 代办人信息
     * @param agentPower1 选中永久有效时它的值为永久有效
     * @param agentValidity1 选中永久有效时它的值为永久有效
     * @param clientValidity1 选中永久有效时它的值为永久有效
     * @return 返回成功页面或者失败页面
     */
    @RequestMapping("/addAcClient")
    public String addAcClient(HttpSession httpSession, AcClient acClient, AcLaundering acLaundering, AcAgent acAgent, String agentPower1, String agentValidity1, String clientValidity1) {
        int i = 0;
        AcAdmin acAdmin = (AcAdmin)httpSession.getAttribute("acAdmin");
        if(!(("").equals(clientValidity1))&&clientValidity1!=null){
            acClient.setClientValidity(clientValidity1);
        }
        if(acAgent.getAgentName()==null){
           i=acClientService.addAcClient(acClient,acAdmin,acLaundering);
        }else{
            if(!(("").equals(agentPower1))&&agentPower1!=null){
                acAgent.setAgentPower(agentPower1);
            }
            if(!(("").equals(agentValidity1))&&agentValidity1!=null){
                acAgent.setAgentValidity(agentValidity1);
            }
           i=acClientService.addAcClientAcAgent(acClient,acAgent,acAdmin,acLaundering);
        }
        if(i>0){
            return "addPeopleSuccess";
        }
        return "addPeopleFail";
    }

    @RequestMapping("updateAcClientSelect")
    public String updateAcClientSelect(AcClient acClient) {
        acClient.toString();

        return "updateAcClient";
    }

    @ResponseBody
    @RequestMapping("findAcClient")
    public AcClient findAcClient(AcClient acClient) {
        AcClient acClient1 = acClientService.findAcClient(acClient);
        return acClient1;
    }
    @RequestMapping("updateAcClient")
    public String updateAcClient(AcClient acClient, AcLaundering acLaundering){
        if(acClientService.updateAcClient(acClient,acLaundering)>0){
            return "updatePeopleSuccess";
        }else{
            return "updatePeopleFail";
        }
    }
    @ResponseBody
    @RequestMapping("exitAcClient")
    public int updateAcClient(AcClient acClient){
       int i =acClientService.updateAcClient(acClient);
        return i;
    }

}
