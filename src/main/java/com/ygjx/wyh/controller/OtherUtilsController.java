package com.ygjx.wyh.controller;

import com.ygjx.fxm.entity.AcClient;
import com.ygjx.fxm.service.AcAdminService;
import com.ygjx.wsh.entity.AccClient;
import com.ygjx.wyh.entity.FundAccount;
import com.ygjx.wyh.sevice.OtherService;
import com.ygjx.wyq.service.ClientService;
import com.ygjx.wyq.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ：wyh
 * @date ：Created in 2019/11/2 11:48
 * @description：其他的和前端交互的controller
 * @modified By：
 * @version: 1.0
 */
@Controller
@RequestMapping("/otherUtilsController")
public class OtherUtilsController {
    @Autowired(required = true)
    private AcAdminService acAdminService;

    @Autowired
    private OtherService otherService;
    @Autowired
    private ClientService clientService;

    /**管理员登录*/
    @RequestMapping("/fundLogin")
    public String fundLogin(HttpSession httpSession, FundAccount fundAccount) {
        List<FundAccount> login = otherService.login();
        FundAccount res = null;
        for (FundAccount fun : login) {
            if (fun.getClientAccount().equals(fundAccount.getClientAccount()) && fun.getClientPassword().equals(fundAccount.getClientPassword())) {
                res = fun;
                httpSession.setAttribute("fundAccount", fun);
            }
        }
        AcClient acClient = null;
        AccClient accClient = null;
        if(res != null){
            return "index";
        }else{
            return "fundLoginFail";
        }
        /*if(res != null){
            acClient = clientService.getAcClientByAccount(res.getClientAccount());
            accClient = clientService.getAccClientByAccount(res.getClientAccount());
        }
        if(acClient != null && acClient.getClientIsdel() != 0){
            return "index";
        }else{
            return "fundLoginFail";
        }*/

        /*if(accClient != null && accClient.getIsClose() != 0){
            return "index";
        }else{
            return "fundLoginFail";
        }*/

    }

}
