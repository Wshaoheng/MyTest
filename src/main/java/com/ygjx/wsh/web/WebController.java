package com.ygjx.wsh.web;

import com.ygjx.fxm.dao.AcBankNameMapper;
import com.ygjx.fxm.entity.AcBankName;
import com.ygjx.fxm.entity.AcCity;
import com.ygjx.fxm.entity.AcProvince;
import com.ygjx.fxm.service.AcProvinceCityService;
import com.ygjx.wsh.dao.AcClientDocumentsMapper;
import com.ygjx.wsh.entity.AcAdmin;
import com.ygjx.wsh.entity.AcBank;
import com.ygjx.wsh.entity.AccClient;
import com.ygjx.wsh.service.IAccClientService;
import com.ygjx.wsh
        .entity.AcClientDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WebController {
    @Autowired
    private IAccClientService accClientService;
    @Autowired
    private AcProvinceCityService acProvinceCityService;
    @Autowired
    private AcBankNameMapper abnm;
    @Autowired
    private AcClientDocumentsMapper acdm;

    /**
     * 去机构开户页面
     * @param session
     * @return
     */
    @RequestMapping("/toAddAccClient")
    public String Reg(HttpSession session){
        AcAdmin acAdmin =(AcAdmin) session.getAttribute("acAdmin");
        Integer bankId = acAdmin.getAdminDotName();
        AcBank ab =accClientService.selectByPrimaryKey(bankId);
        AcBankName abn = abnm.findByBankid(ab.getBankNameId());
        session.setAttribute("acBank",ab);
        session.setAttribute("acBankName",abn);
        List<AcProvince> pList = acProvinceCityService.findAllProvince();
        for(int j=0;j<pList.size();j++){
            AcProvince  province =pList.get(j);
            String code =  province.getProvinceCode();
            List<AcCity> cList = acProvinceCityService.getCityByCode(code);
            for(int i=0;i<cList.size();i++){
                AcCity  city =cList.get(i);
            }
            session.setAttribute("cList",cList);
        }
        session.setAttribute("pList",pList);

        List<AcClientDocuments> acdList = acdm.getAll();
        session.setAttribute("acdList",acdList);
        return "organization_open_account";
    }

    /**
     * 去机构修改资料页面
     * @return
     */
    @RequestMapping("/toUpdateAccClient")
    public String update(){
        return "accUpdateInfo";
    }

    /**
     * 去机构销户页面
     * @return
     */
    @RequestMapping("/toAccClientClose")
    public String close(){
        return "closing_account";
    }


}
