package com.ygjx.fxm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HtmlController {
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "addpeopleAcount";
    }
    @RequestMapping("/toIndex2")
    public String toIndex2(){
        return "index2";
    }
    @RequestMapping("/toIntroduce")
    public String toIntroduce(){
        return "introduce";
    }
    @RequestMapping("/toAdminLogin")
    public String toAdminLogin(){
        return "adminLogin";
    }
    @RequestMapping("/toAddPeopleSuccess")
    public String toAddPeopleSuccess(){
        return "addPeopleSuccess";
    }
    @RequestMapping("/toUpdateAcClient")
    public String toUpdateAcClient(){
        return "toUpdateAcClient";
    }
    @RequestMapping("/toExitPeopleAcount")
    public String toExitPeopleAcount(){
        return "exitPeopleAcount";
    }

}
