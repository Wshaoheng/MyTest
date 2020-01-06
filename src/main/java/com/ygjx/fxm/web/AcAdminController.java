package com.ygjx.fxm.web;

import com.ygjx.fxm.service.AcAdminService;
import com.ygjx.wsh.entity.AcAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AcAdminController {
    @Autowired(required = true)
    private AcAdminService acAdminService;
    @RequestMapping("/duplicateUsername")
    public int duplicateUsername(String username) {

        return 0;
    }
    @RequestMapping("/findLoginAdmin")
    public String findLoginAdmin() {

        return null;
    }

    @RequestMapping("/adminLogin")
    public String adminLogin(HttpSession httpSession,AcAdmin acAdmin) {
        List<AcAdmin> allAcAdmin = acAdminService.findAllAcAdmin();
        AcAdmin aa = null;
        for (AcAdmin admin: allAcAdmin) {
            if(admin.getAdminDot()==acAdmin.getAdminDot()&&admin.getAdminAccount().equals(acAdmin.getAdminAccount())
                    &&admin.getAdminPassword().equals(acAdmin.getAdminPassword())){
                aa=admin;
                httpSession.setAttribute("acAdmin",admin);
            }
        }
        if(aa!=null){
            return "index2";
        }else{
            return "adminLoginFail";
        }
    }
}
