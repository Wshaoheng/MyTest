package com.ygjx.wyq.web;

import com.ygjx.fxm.dao.AcAdminMapper;
import com.ygjx.fxm.dao.AcBankNameMapper;
import com.ygjx.fxm.entity.AcBankName;
import com.ygjx.fxm.entity.AcClient;
import com.ygjx.wsh.dao.AcClientDocumentsMapper;
import com.ygjx.wsh.entity.*;
import com.ygjx.wsh.service.IAccClientService;
import com.ygjx.wyh.entity.FundAccount;
import com.ygjx.wyh.sevice.FundAccountService;
import com.ygjx.wyq.entity.*;
import com.ygjx.wyq.service.ClientService;
import com.ygjx.wyq.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fund")
public class FundController {
    @Autowired
    private FundService fundService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private AcBankNameMapper abnm;
    @Autowired
    private AcClientDocumentsMapper acdm;
    @Autowired
    private IAccClientService accClientService;
    @Autowired
    private AcAdminMapper aam;
    @Autowired
    private FundAccountService fundAccountService;
    @RequestMapping("/toList")
    public String toList(Model m,HttpSession session){
        List<AcFundMoney> mlist = fundService.list();
        List<AcFund> flist = fundService.getList();
        FundAccount fund =(FundAccount) session.getAttribute("fundAccount");
        AcFundAccount acFundAccount = fundService.getClientAccount(fund.getClientAccount());
        m.addAttribute("acFundAccount",acFundAccount);
        m.addAttribute("flist",flist);
        m.addAttribute("mlist",mlist);
        return "fund_fen";
    }

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/mo")
    @ResponseBody
    public Map<String,Object> mo(Model m,String fundAccount,String clientAccount,String password,String accAccount,HttpSession session){
        Map<String, Object> map = new HashMap<String,Object>();
        AcFundAccount acFundAccount = new AcFundAccount();
        AcClient acClient2 = new AcClient();
        AcClient acClient = clientService.getAcClientByAccount(clientAccount);
        AccClient accClient = new AccClient();
        accClient.setAccAccount(clientAccount);
        AccClient accClient1 = clientService.getAccClientByAccount(accClient.getAccAccount());
        acFundAccount.setFundAccount(fundAccount);
        acFundAccount.setFundPassword(password);
        if(clientAccount != null && clientAccount != ""){
            acFundAccount.setClientAccount(clientAccount);
            acFundAccount.setClientPassword(password);
        }
        session.setAttribute("acFundAccount",acFundAccount);
        if (acClient != null) {
            List<AcFundMoney> list = fundService.mo(acFundAccount);
            for(int i = 0; i < list.size();i++){
                AcFundAccount pe = fundService.getPersonById(list.get(i).getAcFundAccount().getFundAccount());
                map.put("pe",pe);
            }
        }
        if(accClient1 != null){
            List<AcFundMoney> list = fundService.mo(acFundAccount);
            for(int i = 0; i < list.size();i++){
                AcFundAccount cl = fundService.getAccClientById(list.get(i).getAcFundAccount().getFundAccount());
                map.put("cl",cl);
            }
        }
        List<AcFundMoney> list = fundService.mo(acFundAccount);
        session.setAttribute("list",list);
        if(list != null){
            map.put("message","查询成功");
        }else{
            map.put("message","查询失败,你的账号或密码输入有误");
        }
        map.put("list",list);
        for (int i = 0; i < list.size(); i++) {
            fundAccount = list.get(i).getAcFundAccount().getFundAccount();
            AcFundAccount ac = fundService.getById(fundAccount);
            clientAccount = list.get(i).getAccClient().getCustomerName();
            map.put("ac",ac);
        }
        FundAccount fund = (FundAccount) session.getAttribute("fundAccount");
        AcFundAccount acFundAccount1 = fundService.getByClientAccount(fund.getClientAccount());
        List<AcFund> flist = fundService.getList();
        AcBank ab = accClientService.selectByPrimaryKey(acFundAccount1.getBankId());
        Integer bankNameId = ab.getBankNameId();
        AcBankName abn = abnm.findByBankid(bankNameId);
        map.put("acFundAccount1",acFundAccount1);
        map.put("ab",ab);
        map.put("abn",abn);
        return map;
    }

    @RequestMapping("/jiao")
    @ResponseBody
    public Map<String, Object> jiao(Model m,String fundAccount,String clientAccount,String password){
        Map<String, Object> map = new HashMap<String,Object>();
        AcFundAccount acFundAccount = new AcFundAccount();
        acFundAccount.setFundAccount(fundAccount);
        acFundAccount.setClientAccount(clientAccount);
        List<AcFundAccount> list = fundService.jiao(acFundAccount);
        for (int i = 0; i < list.size(); i++) {
            if((list.get(i).getFundAccount().equals(fundAccount) && list.get(i).getFundPassword().equals(password))
                    || (list.get(i).getClientAccount().equals(clientAccount) && list.get(i).getFundPassword().equals(password))){
                map.put("message","密码正确");
            }else{
                map.put("message","对不起,你的密码输入错误");
            }
        }
        return map;
    }

    @RequestMapping("/updateFen")
    @ResponseBody
    public Map<String,Object> updateFen(String fen,String fundAccount,String clientAccount,String password,String fundCode){
        Map<String, Object> map = new HashMap<String,Object>();
        AcFundMoney acFundMoney = new AcFundMoney();
        AcFundMoney acFundMoney1 = fundService.getByFundCode(fundCode);
        acFundMoney.setId(acFundMoney1.getId());
        acFundMoney.setFen(fen);
        int i = fundService.update(acFundMoney);
        map.put("i",i);
        AcFundAccount acFundAccount = new AcFundAccount();
        if(clientAccount != null && clientAccount != ""){
            acFundAccount.setClientAccount(clientAccount);
            acFundAccount.setClientPassword(password);
        }
        if(fundAccount != null && fundAccount != ""){
            acFundAccount.setFundAccount(fundAccount);
            acFundAccount.setFundPassword(password);
        }
        List<AcFundMoney> list = fundService.mo(acFundAccount);
        map.put("list",list);
        /*Counter counter = new Counter();
        String currenTime = GetTime.getCurrenTime();
        counter.setOperatingTime(currenTime);
        counter.setOperationType(currenTime+"客户进行了设置分红方式");
        counter.setFundAccount(fundAccount);
        counter.setClientAccount(clientAccount);
        counter.setStatus(0);
        counter.setAdminId(1);
        int i1 = fundService.inserBillInfo(counter);
        map.put("i1",i1);*/
        return map;
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

    @RequestMapping("/zhuan")
    public String zhuan(Model m,HttpSession session){
        List<AcFundMoney> mlist = fundService.list();
        List<AcFund> flist = fundService.getList();
        FundAccount fund = (FundAccount) session.getAttribute("fundAccount");
        AcFundAccount acFundAccount = fundService.getClientAccount(fund.getClientAccount());
        m.addAttribute("acFundAccount",acFundAccount);
        m.addAttribute("flist",flist);
        m.addAttribute("mlist",mlist);
        return "fund_tuo";
    }

    @RequestMapping("/updateZhuan")
    @ResponseBody
    public Map<String,Object> updateZhuan(HttpSession session,AcFundAccount acFundAccount,String clientAccount,Integer price,String password,
      String fundAccount,Integer availableShare,Integer fundShare,Double amountAvailable,String fundCode,Integer fundId){
        Map<String,Object>  map = new HashMap<String, Object>();
        /*acFundAccount.setFundAccount(fundAccount);
        acFundAccount.setFundPassword(password);
        List<AcFundMoney> list = fundService.mo(acFundAccount);*/
        session.setAttribute("fundCode",fundCode);
        AcFundMoney acFundMoney = new AcFundMoney();
        AcFundMoney acFundMoney1 = fundService.getByFundCode(fundCode);
        acFundMoney.setId(acFundMoney1.getId());
        availableShare = acFundMoney1.getAvailableShare() - price;
        amountAvailable = acFundMoney1.getAmountAvailable() - price * acFundMoney1.getAcFund().getSharePrice();
        BigDecimal b = new BigDecimal(amountAvailable);
        double v = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        fundId = acFundMoney1.getAcFund().getFundId();
        fundShare = acFundMoney1.getAcFund().getFundShare() + price;
        acFundMoney.setAmountAvailable(v);
        acFundMoney.setAvailableShare(availableShare);
        AcFund acFund = new AcFund();
        acFund.setFundId(fundId);
        acFund.setFundShare(fundShare);
        int i = fundService.updateAcFundMoney(acFundMoney);
        int a = fundService.updateAcFund(acFund);
        map.put("i",i);
        map.put("a",a);
        AcFundAccount acFundAccount1 = new AcFundAccount();
        if(clientAccount != null && clientAccount != ""){
            acFundAccount1.setClientAccount(clientAccount);
            acFundAccount1.setClientPassword(password);
        }
        if(fundAccount != null && fundAccount != ""){
            acFundAccount1.setFundAccount(fundAccount);
            acFundAccount1.setFundPassword(password);
        }
        List<AcFundMoney> list = fundService.mo(acFundAccount1);
        map.put("list",list);
        /*Counter counter = new Counter();
        String currenTime = GetTime.getCurrenTime();
        counter.setOperatingTime(currenTime);
        counter.setOperationType(currenTime+"客户进行了转托管出");
        counter.setFundAccount(fundAccount);
        counter.setClientAccount(clientAccount);
        counter.setStatus(0);
        counter.setAdminId(1);
        int i1 = fundService.inserBillInfo(counter);
        map.put("i1",i1);*/
        return map;
    }

    @RequestMapping("/in")
    public String in(Model m,HttpSession session){
        List<AcFundMoney> list = fundService.list();
        List<AcFund> flist = fundService.getList();
        List<FundType> ftlist = fundService.getFundTypeList();
        FundAccount fund = (FundAccount) session.getAttribute("fundAccount");
        AcFundAccount acFundAccount = fundService.getClientAccount(fund.getClientAccount());
        m.addAttribute("acFundAccount",acFundAccount);
        m.addAttribute("flist",flist);
        m.addAttribute("list",list);
        m.addAttribute("ftlist",ftlist);
        return "fund_tuo_in";
    }

    @RequestMapping("/updateTuoIn")
    @ResponseBody
    public Map<String,Object> updateTuoIn(AcFundAccount acFundAccount,String clientAccount,Integer price,String password,
        String fundAccount,Integer availableShare,Integer fundShare,Double amountAvailable,String fundCode,Integer fundId){
        Map<String,Object>  map = new HashMap<String, Object>();
        AcFundMoney acFundMoney = new AcFundMoney();
        AcFundMoney acFundMoney1 = fundService.getByFundCode(fundCode);
        availableShare = acFundMoney1.getAvailableShare() + price;
        fundShare = acFundMoney1.getAcFund().getFundShare() - price;
        amountAvailable = acFundMoney1.getAmountAvailable() + price * acFundMoney1.getAcFund().getSharePrice();
        BigDecimal b = new BigDecimal(amountAvailable);
        double v = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        fundId = acFundMoney1.getAcFund().getFundId();
        acFundMoney.setId(acFundMoney1.getId());
        acFundMoney.setAmountAvailable(v);
        acFundMoney.setAvailableShare(availableShare);
        AcFund acFund = new AcFund();
        acFund.setFundId(fundId);
        acFund.setFundShare(fundShare);
        int i = fundService.updateAcFundMoney(acFundMoney);
        int a = fundService.updateAcFund(acFund);
        map.put("i",i);
        map.put("a",a);
        if(clientAccount != null && clientAccount != ""){
            acFundAccount.setClientAccount(clientAccount);
            acFundAccount.setClientPassword(password);
        }
        if(fundAccount != null && fundAccount != ""){
            acFundAccount.setFundAccount(fundAccount);
            acFundAccount.setFundPassword(password);
        }
        List<AcFundMoney> list = fundService.mo(acFundAccount);
        map.put("list",list);
        /*Counter counter = new Counter();
        String currenTime = GetTime.getCurrenTime();
        counter.setOperatingTime(currenTime);
        counter.setOperationType(currenTime+"客户进行了转托管入");
        counter.setFundAccount(fundAccount);
        counter.setClientAccount(clientAccount);
        counter.setStatus(0);
        counter.setAdminId(1);
        int i1 = fundService.inserBillInfo(counter);
        map.put("i1",i1);*/
        return map;
    }

    @RequestMapping("/liu")
    @ResponseBody
    public Object liu(HttpSession session,Integer counterId,String password,String fundCode1){
        Map<String,Object> map = new HashMap<String,Object>();
        AcCounter acCounter = clientService.getById(counterId);
        AcFundAccount acFundAccount = new AcFundAccount();
        if(acCounter.getClientAccount() != null && acCounter.getClientAccount() != ""){
            acFundAccount.setClientAccount(acCounter.getClientAccount());
            acFundAccount.setClientPassword(password);
        }
        if(acCounter.getFundAccount() != null && acCounter.getFundAccount() != ""){
            acFundAccount.setFundAccount(acCounter.getFundAccount());
            acFundAccount.setFundPassword(password);
        }
        String fundCode = (String) session.getAttribute("fundCode");
        List<AcFundMoney> list = fundService.getByFundCodeList(fundCode,counterId);
        map.put("list",list);
        return map;
    }

    @RequestMapping("/out")
    public String out(Model m,HttpSession session){
        List<AcFundMoney> list = fundService.list();
        List<AcFund> flist = fundService.getList();
        FundAccount fund = (FundAccount) session.getAttribute("fundAccount");
        AcFundAccount acFundAccount = fundService.getClientAccount(fund.getClientAccount());
        List<FundType> ftlist = fundService.getFundTypeList();
        m.addAttribute("ftlist",ftlist);
        m.addAttribute("acFundAccount",acFundAccount);
        m.addAttribute("flist",flist);
        m.addAttribute("list",list);
        return "fund_tuo_out";
    }

    @RequestMapping("/test")
    public String test(){
        return "text";
    }

    @RequestMapping("/updateTuoOut")
    @ResponseBody
    public Map<String,Object> updateTuoOut(AcFundAccount acFundAccount,String clientAccount,Integer price,String password,
       String fundAccount,Integer availableShare,Integer fundShare,Double amountAvailable,String fundCode,Integer fundId){
        Map<String,Object>  map = new HashMap<String, Object>();
        AcFundMoney acFundMoney = new AcFundMoney();
        AcFundMoney acFundMoney1 = fundService.getByFundCode(fundCode);
        availableShare = acFundMoney1.getAvailableShare() - price;
        fundShare = acFundMoney1.getAcFund().getFundShare() + price;
        amountAvailable = acFundMoney1.getAmountAvailable() - price * acFundMoney1.getAcFund().getSharePrice();
        BigDecimal b = new BigDecimal(amountAvailable);
        double v = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        fundId = acFundMoney1.getAcFund().getFundId();
        acFundMoney.setId(acFundMoney1.getId());
        acFundMoney.setAmountAvailable(v);
        acFundMoney.setAvailableShare(availableShare);
        AcFund acFund = new AcFund();
        acFund.setFundId(fundId);
        acFund.setFundShare(fundShare);
        int i = fundService.updateAcFundMoney(acFundMoney);
        int a = fundService.updateAcFund(acFund);
        map.put("i",i);
        map.put("a",a);
        //AcFundAccount acFundAccount1 = new AcFundAccount();
        if(clientAccount != null && clientAccount != ""){
            acFundAccount.setClientAccount(clientAccount);
            acFundAccount.setClientPassword(password);
        }
        if(fundAccount != null && fundAccount != ""){
            acFundAccount.setFundAccount(fundAccount);
            acFundAccount.setFundPassword(password);
        }
        List<AcFundMoney> list = fundService.mo(acFundAccount);
        map.put("list",list);
        /* Counter counter = new Counter();
        String currenTime = GetTime.getCurrenTime();
        counter.setOperatingTime(currenTime);
        counter.setOperationType(currenTime+"客户进行了外部转托管转出");
        counter.setFundAccount(fundAccount);
        counter.setClientAccount(clientAccount);
        counter.setAdminId(1);
        counter.setStatus(0);
        int i1 = fundService.inserBillInfo(counter);
        map.put("i1",i1);*/
        return map;
    }

    @RequestMapping("/gou")
    public String gou(Model m,HttpSession session){
        FundAccount fund = (FundAccount) session.getAttribute("fundAccount");
        AcFundAccount acFundAccount = fundService.getClientAccount(fund.getClientAccount());
        List<AcFund> flist = fundService.getList();
        AcBank ab = accClientService.selectByPrimaryKey(acFundAccount.getBankId());
        Integer bankNameId = ab.getBankNameId();
        AcBankName abn = abnm.findByBankid(bankNameId);
        Score score = fundService.getScoreById(fund.getClientAccount());
        if(score == null){
            return "riskQuestionnaire";
        }
        session.setAttribute("acFundAccount",acFundAccount);
        m.addAttribute("acFundAccount",acFundAccount);
        m.addAttribute("flist",flist);
        return "subscription";
    }

    @RequestMapping("/gouAdd")
    @ResponseBody
    public Object gouAdd(HttpSession session,String fundWei,String accountType,String clientAccount,String fundAccount,String broker,
     String fundPassword,String fundName,String shareCategory,String currency,String discountRate,String fundMethod,Integer purchaseAmount){
        Map<String, Object> map = new HashMap<String, Object>();
        AcFundMoney acFundMoney = new AcFundMoney();
        acFundMoney.setFundName(fundName);
        acFundMoney.setShareCategory(shareCategory);
        acFundMoney.setCurrency(currency);
        acFundMoney.setDiscountRate(discountRate);
        acFundMoney.setFundMethod(fundMethod);
        acFundMoney.setBroker(broker);
        AcFund acFund = fundService.getByFundName(fundName);
        acFundMoney.setAvailableShare(purchaseAmount);
        Double price = acFund.getSharePrice();
        Double p = price * purchaseAmount;
        acFundMoney.setPurchaseAmount(p);
        acFundMoney.setAmountAvailable(p);
        acFundMoney.setFen("现金分红");
        int i = fundService.addAcFundMoney(acFundMoney);
        AcFundInfo acFundInfo = new AcFundInfo();
        acFundInfo.setFundInfoAccount(fundAccount);
        acFundInfo.setFundInfoFund(acFundMoney.getId());
        int b = fundService.addAcFundInfo(acFundInfo);
        /* Counter counter = new Counter();
        String currenTime = GetTime.getCurrenTime();
        counter.setOperatingTime(currenTime);
        counter.setOperationType(currenTime+"客户进行了申购操作");
        counter.setFundAccount(fundAccount);
        counter.setClientAccount(clientAccount);
        counter.setAdminId(1);
        counter.setStatus(0);
        int i1 = fundService.inserBillInfo(counter);
        map.put("i1",i1);*/
        return map;
    }

    @RequestMapping("/che")
    public String che(Model m,HttpSession session){
        FundAccount fund = (FundAccount) session.getAttribute("fundAccount");
        AcFundAccount acFundAccount = fundService.getByClientAccount(fund.getClientAccount());
        List<AcFund> flist = fundService.getList();
        AcBank ab = accClientService.selectByPrimaryKey(acFundAccount.getBankId());
        Integer bankNameId = ab.getBankNameId();
        AcBankName abn = abnm.findByBankid(bankNameId);
        List<AcClientDocuments> adlist = acdm.getAll();
        session.setAttribute("acFundAccount",acFundAccount);
        session.setAttribute("ab",ab);
        session.setAttribute("abn",abn);
        m.addAttribute("acFundAccount",acFundAccount);
        m.addAttribute("flist",flist);
        m.addAttribute("adlist",adlist);
        return "transactionWithdrawal";
    }

    @RequestMapping("/cheUpdate")
    @ResponseBody
    public Map<String,Object> cheUpdate(String fundWei,String accountType,String clientAccount,String fundAccount,String broker,
         String fundPassword,String fundName,String shareCategory,String currency,String discountRate,String fundMethod,Integer purchaseAmount){
        Map<String, Object> map = new HashMap<String, Object>();
        AcFundMoney acFundMoney = new AcFundMoney();
        acFundMoney.setFundName(fundName);
        acFundMoney.setShareCategory(shareCategory);
        acFundMoney.setCurrency(currency);
        acFundMoney.setDiscountRate(discountRate);
        acFundMoney.setFundMethod(fundMethod);
        acFundMoney.setBroker(broker);
        AcFund acFund = fundService.getByFundName(fundName);
        acFundMoney.setAvailableShare(purchaseAmount);
        Double price = acFund.getSharePrice();
        Double p = price * purchaseAmount;
        acFundMoney.setPurchaseAmount(p);
        acFundMoney.setAmountAvailable(p);
        acFundMoney.setFen("现金分红");
        int i = fundService.addAcFundMoney(acFundMoney);
        AcFundInfo acFundInfo = new AcFundInfo();
        acFundInfo.setFundInfoAccount(clientAccount);
        acFundInfo.setFundInfoFund(acFundMoney.getId());
        int b = fundService.addAcFundInfo(acFundInfo);
        /* Counter counter = new Counter();
        String currenTime = GetTime.getCurrenTime();
        counter.setOperatingTime(currenTime);
        counter.setOperationType(currenTime+"客户进行了交易撤单");
        counter.setFundAccount(fundAccount);
        counter.setClientAccount(clientAccount);
        counter.setAdminId(1);
        counter.setStatus(0);
        int i1 = fundService.inserBillInfo(counter);
        map.put("i1",i1);*/
        return map;
    }

    @RequestMapping("/shu")
    public String shu(Model m,HttpSession session){
        FundAccount fund = (FundAccount) session.getAttribute("fundAccount");
        AcFundAccount acFundAccount = fundService.getByClientAccount(fund.getClientAccount());
        List<AcFund> flist = fundService.getList();
        AcBank ab = accClientService.selectByPrimaryKey(acFundAccount.getBankId());
        Integer bankNameId = ab.getBankNameId();
        AcBankName abn = abnm.findByBankid(bankNameId);
        List<AcClientDocuments> adlist = acdm.getAll();
        session.setAttribute("acFundAccount",acFundAccount);
        session.setAttribute("ab",ab);
        session.setAttribute("abn",abn);
        m.addAttribute("acFundAccount",acFundAccount);
        m.addAttribute("flist",flist);
        m.addAttribute("adlist",adlist);
        return "redemption";
    }

    @RequestMapping("/shuUpdate")
    @ResponseBody
    public Map<String,Object> shuUpdate(AcFundAccount acFundAccount,String clientAccount,Integer price,String password,
        String fundAccount,Integer availableShare,Integer fundShare,Double amountAvailable,String fundCode,Integer fundId){
        Map<String,Object>  map = new HashMap<String, Object>();
        AcFundMoney acFundMoney = new AcFundMoney();
        AcFundMoney acFundMoney1 = fundService.getByFundCode(fundCode);
        availableShare = acFundMoney1.getAvailableShare() - price;
        fundShare = acFundMoney1.getAcFund().getFundShare() + price;
        amountAvailable = acFundMoney1.getAmountAvailable() - price * acFundMoney1.getAcFund().getSharePrice();
        BigDecimal b = new BigDecimal(amountAvailable);
        double v = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        fundId = acFundMoney1.getAcFund().getFundId();
        acFundMoney.setId(acFundMoney1.getId());
        acFundMoney.setAmountAvailable(v);
        acFundMoney.setAvailableShare(availableShare);
        AcFund acFund = new AcFund();
        acFund.setFundId(fundId);
        acFund.setFundShare(fundShare);
        int i = fundService.updateAcFundMoney(acFundMoney);
        int a = fundService.updateAcFund(acFund);
        map.put("i",i);
        map.put("a",a);
        //AcFundAccount acFundAccount1 = new AcFundAccount();
        if(clientAccount != null && clientAccount != ""){
            acFundAccount.setClientAccount(clientAccount);
            acFundAccount.setClientPassword(password);
        }
        if(fundAccount != null && fundAccount != ""){
            acFundAccount.setFundAccount(fundAccount);
            acFundAccount.setFundPassword(password);
        }
        List<AcFundMoney> list = fundService.mo(acFundAccount);
        map.put("list",list);
        /* Counter counter = new Counter();
        String currenTime = GetTime.getCurrenTime();
        counter.setOperatingTime(currenTime);
        counter.setOperationType(currenTime+"客户进行了基金赎回操作");
        counter.setFundAccount(fundAccount);
        counter.setClientAccount(clientAccount);
        counter.setAdminId(1);
        counter.setStatus(0);
        int i1 = fundService.inserBillInfo(counter);
        map.put("i1",i1);*/
        return map;
    }

    @RequestMapping("/huan")
    public String huan(String id,HttpSession session,Model m){
        FundAccount fund = (FundAccount) session.getAttribute("fundAccount");
        AcFundAccount acFundAccount = fundService.getClientAccount(fund.getClientAccount());
        FundAccount fundAccount = fundAccountService.selectFundAccountInfos(id);
        List<AcFund> flist = fundService.getList();
        AcBank ab = accClientService.selectByPrimaryKey(acFundAccount.getBankId());
        Integer bankNameId = ab.getBankNameId();
        AcBankName abn = abnm.findByBankid(bankNameId);
        m.addAttribute("acFundAccount",acFundAccount);
        m.addAttribute("flist",flist);
        return "fen";
    }

    @RequestMapping("/openAccClient")
    public String openAccClient(Model m, HttpSession session){
        FundAccount fund =(FundAccount) session.getAttribute("fundAccount");
        AcFundAccount acFundAccount = fundService.getClientAccount(fund.getClientAccount());
        Integer bankId = acFundAccount.getBankId();
        AcBank ab =accClientService.selectByPrimaryKey(bankId);
        Integer bankNameId = ab.getBankNameId();
        AcBankName abn = abnm.findByBankid(bankNameId);
        List<AcClientDocuments> acdList = acdm.getAll();
        session.setAttribute("acdList",acdList);
        session.setAttribute("acBank",ab);
        session.setAttribute("acBankName",abn);
        session.setAttribute("acFundAccount",acFundAccount);
        return "fundAccClient";
    }

    @RequestMapping("/organization")
    @ResponseBody
    public Map<String,Object> organization(String fundWei, String customerName, String customerReferred, String accountType, String clientType, String clientNum, String clientNum1,
       String clientValidity, String clientPassword, String clientPassword1, String clientTaCode, String adminAccount, String telphone1, Integer adminType,
       String adminNum, String certificateValidity, String adminNum1, String bankName, String clientName, Integer bankId, String bankAccount,
       String jonesLangLasalle, String fundSign, String clientPostCode, String clientTel, String fundFax, String clientPhone, String mailAddress,
       String email, Float discountRate, String fen, String capital) throws ParseException {
        Map<String, Object> map = new HashMap<String, Object>();
        AcClient acClient = new AcClient();
        acClient.setClientName(customerName);
        acClient.setClientValidity(certificateValidity);
        if(clientNum.equals(clientNum1)){
            acClient.setClientNum(clientNum);
        }
        acClient.setClientType(1);
        acClient.setClientPostcode(clientPostCode);
        if(clientPassword.equals(clientPassword1)){
            acClient.setClientPassword(clientPassword);
        }
        acClient.setAgentId(1);
        acClient.setClientPhone(clientTel);
        acClient.setClientTel(telphone1);
        acClient.setClientAddress(mailAddress);
        acClient.setClientProvince("北京");
        acClient.setClientCity(1);
        acClient.setClientPeople("机构");
        acClient.setClientIsdel(0);
        acClient.setClientSex("男");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String string = "1993-04-14";
        Date parse = sdf.parse(string);
        acClient.setClientBirthday(parse);
        //通过获取当前时间的毫秒值来生成一个基金帐号
        Date date = new Date();
        long time = date.getTime();
        Long longObj = new Long(time);
        String str = longObj.toString();
        acClient.setClientAccount(str);
        AcAdmin acAdmin = new AcAdmin();
        AcAdmin admin = aam.findByAdminAccount(adminAccount);
        Integer adminId = admin.getAdminId();
        int i = clientService.addAcClient(acClient);
        map.put("i",i);
        acAdmin.setAdminAccount(adminAccount);
        acAdmin.setAdminNum(adminNum);
        acAdmin.setAdminType(adminType);
        AcFundAccount acFundAccount = new AcFundAccount();
        String a = time + "";
        String right = "";
        right = a.substring(a.length() - 8, a.length());
        String left = "";
        if (right.length() >= 4) {
            left = right.substring(right.length() - 4, right.length());
            String userName = left + right;
            acFundAccount.setFundAccount(userName);
        } else {
            right = a.substring(a.length() - 12, a.length());
            acFundAccount.setFundAccount(right);
        }
        acFundAccount.setClientAccount(str);
        acFundAccount.setFundWei(fundWei);
        acFundAccount.setAccountType(accountType);
        if(clientPassword.equals(clientPassword1)){
            acFundAccount.setClientPassword(clientPassword);
        }
        acFundAccount.setAccountType(accountType);
        acFundAccount.setBankId(bankId);
        acFundAccount.setFundPassword(clientPassword);
        acFundAccount.setClientName(clientName);
        if(clientNum.equals(clientNum1)){
            acFundAccount.setClientNum(clientNum);
        }
        acFundAccount.setEmail(email);
        acFundAccount.setFundSign(fundSign);
        acFundAccount.setFen(fen);
        acFundAccount.setBankId(bankId);
        acFundAccount.setDiscountRate(discountRate);
        acFundAccount.setMailAddress(mailAddress);
        acFundAccount.setClientTel(clientTel);
        acFundAccount.setCapital(capital);
        acFundAccount.setClientPhone(clientPhone);
        acFundAccount.setClientValidity(clientValidity);
        if(clientPassword.equals(clientPassword1)){
            acFundAccount.setClientPassword(clientPassword);
        }
        acFundAccount.setClientPostcode(clientPostCode);
        acFundAccount.setClientTacode(clientTaCode);
        acFundAccount.setBankId(bankId);
        acFundAccount.setManagerId(adminId);
        int aa = clientService.addAcFundAccount(acFundAccount);
        map.put("aa",aa);
        return map;
    }


    @RequestMapping("/checkAccClient")
    public String checkAccClient(Model m, HttpSession session,String accAccount,String tradePassword){
        FundAccount fund =(FundAccount) session.getAttribute("fundAccount");
        AcFundAccount acFundAccount = fundService.getClientAccount(fund.getClientAccount());
        Integer bankId = acFundAccount.getBankId();
        AcBank ab =accClientService.selectByPrimaryKey(bankId);
        AcBankName abn = abnm.findByBankid(ab.getBankNameId());
        List<AcClientDocuments> acdList = acdm.getAll();
        //session.getAttribute("accAccount");
        session.setAttribute("acdList",acdList);
        session.setAttribute("acBank",ab);
        session.setAttribute("acBankName",abn);
       /* AccClient acc = clientService.getAccClientByAccount(accAccount);
        session.setAttribute("acc",acc);*/
        return "fundAccAcountCheckIn";
    }

    @RequestMapping("/check")
    public  String check(Model m,String accAccount){
        AccClient acc = clientService.getAccClientByAccount(accAccount);
        m.addAttribute("acc",acc);
        return "redirect:fundAccAcountCheckIn";
    }

    @RequestMapping("/registration")
    @ResponseBody
    public Map<String,Object> registration(String fundWei, String customerName, String customerReferred, String accountType, String clientType, String clientNum, String clientNum1,
       String clientValidity, String clientPassword, String clientPassword1, String clientTaCode, String adminAccount, String telphone1, Integer adminType,
       String adminNum, String certificateValidity, String adminNum1, String bankName, String clientName, Integer bankId, String bankAccount,
       String jonesLangLasalle, String fundSign, String clientPostCode, String clientTel, String fundFax, String clientPhone, String mailAddress,
       String email, Float discountRate, String fen, String capital,String sex,String fundNationality){
        Map<String, Object> map = new HashMap<String, Object>();
        //通过获取当前时间的毫秒值来生成一个基金帐号
        Date date = new Date();
        long time = date.getTime();
        Long longObj = new Long(time);
        String str = longObj.toString();
        AcFundAccount acFundAccount = new AcFundAccount();
        String a = time + "";
        String right = "";
        right = a.substring(a.length() - 8, a.length());
        String left = "";
        if (right.length() >= 4) {
            left = right.substring(right.length() - 4, right.length());
            String userName = left + right;
            acFundAccount.setFundAccount(userName);
        } else {
            right = a.substring(a.length() - 12, a.length());
            acFundAccount.setFundAccount(right);
        }
        acFundAccount.setClientAccount(str);
        acFundAccount.setFundWei(fundWei);
        acFundAccount.setAccountType(accountType);
        if(clientPassword.equals(clientPassword1)){
            acFundAccount.setClientPassword(clientPassword);
        }
        acFundAccount.setAccountType(accountType);
        acFundAccount.setBankId(bankId);
        acFundAccount.setClientName(clientName);
        if(clientNum.equals(clientNum1)){
            acFundAccount.setClientNum(clientNum);
        }
        acFundAccount.setEmail(email);
        acFundAccount.setFundSign(fundSign);
        acFundAccount.setFen(fen);
        acFundAccount.setBankId(bankId);
        acFundAccount.setDiscountRate(discountRate);
        acFundAccount.setMailAddress(mailAddress);
        acFundAccount.setClientTel(clientTel);
        acFundAccount.setCapital(capital);
        acFundAccount.setClientPhone(clientPhone);
        acFundAccount.setClientValidity(clientValidity);
        if(clientPassword.equals(clientPassword1)){
            acFundAccount.setClientPassword(clientPassword);
        }
        acFundAccount.setClientPostcode(clientPostCode);
        acFundAccount.setClientTacode(clientTaCode);
        acFundAccount.setBankId(bankId);
        acFundAccount.setClientSex(sex);
        acFundAccount.setFundNationality(fundNationality);
        AcAdmin acAdmin = new AcAdmin();
        AcAdmin admin = aam.findByAdminAccount(adminAccount);
        Integer adminId = admin.getAdminId();
        acAdmin.setAdminAccount(adminAccount);
        acAdmin.setAdminNum(adminNum);
        acAdmin.setAdminType(adminType);
        acFundAccount.setManagerId(adminId);
        int aa = clientService.addAcFundAccount(acFundAccount);
        map.put("aa",aa);
        return map;
    }

}
