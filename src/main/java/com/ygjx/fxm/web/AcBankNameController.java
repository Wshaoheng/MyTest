package com.ygjx.fxm.web;

import com.ygjx.fxm.entity.AcBankName;
import com.ygjx.fxm.service.AcBankNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AcBankNameController {
    @Autowired
    AcBankNameService acBankNameService;
    @ResponseBody
    @RequestMapping("findAllAcBankName")
    public List<AcBankName> findAllAcBankName() {
        List<AcBankName> allAcBankName = acBankNameService.getAllAcBankName();
        return allAcBankName;
    }
}
