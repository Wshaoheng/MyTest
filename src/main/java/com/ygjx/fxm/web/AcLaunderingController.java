package com.ygjx.fxm.web;

import com.ygjx.fxm.entity.AcLaundering;
import com.ygjx.fxm.service.AcLaunderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AcLaunderingController {
    @Autowired
    AcLaunderingService acLaunderingService;
    @ResponseBody
    @RequestMapping("findAcLaundering")
    public AcLaundering findAcLaunderingByClientAccount(String clientAccount) {
        return acLaunderingService.findAcLaunderingByClientAccount(clientAccount);
    }
}
