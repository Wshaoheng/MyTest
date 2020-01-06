package com.ygjx.wyh.controller;

import com.ygjx.wsh.entity.AcBank;
import com.ygjx.wyh.dao.FundAccountDao;
import com.ygjx.wyh.dto.IsSaveInfoDto;
import com.ygjx.wyh.dto.PurchaseDto;
import com.ygjx.wyh.dto.RegisteredInfoDto;
import com.ygjx.wyh.entity.Fund;
import com.ygjx.wyh.entity.FundAccount;
import com.ygjx.wyh.sevice.FundAccountService;
import com.ygjx.wyh.util.Result;
import com.ygjx.wyh.util.ResultCode;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：wyh
 * @date ：Created in 2019/10/25 16:35
 * @description：个人基金申请的接口
 * @modified By：
 * @version: 1.0$
 */


@RestController
@RequestMapping("/fundAccountController")
public class FundAccountController {

    @Resource
    private FundAccountService fundAccountService;

    @Resource
    private FundAccountDao fundAccountDao;

    Result result = new Result();

    /**新增---后面需要阉割*/
    @RequestMapping("/addFundAccountInfo")
    public String addFundAccountInfo(FundAccount fundAccount, ModelMap map){
        int i = fundAccountService.saveInfo(fundAccount);
        if (i == 1){
            result.setData(i);
            result.setMessage("新增成功");
            result.setResultCode(ResultCode.SUCCESS);
        }else {
            result.setMessage("您的信息可能有问题，还请联系管理员");
            result.setResultCode(ResultCode.ERROR);
        }
        map.put("result",result);
        //return "forward:页面名称";
        return "redirect:页面名称";
    }

    /**
     * 个人基金账户登记
     */
    @RequestMapping("/toFundAccountOpening")
    public ModelAndView toFundAccountOpening(String id){
        FundAccount res = fundAccountService.selectFundAccountInfos(id);
        AcBank acBank = fundAccountDao.selectBnakInfo(res.getBankId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("res",res);
        modelAndView.addObject("bank",acBank);
        modelAndView.setViewName("fundAccountOpening");
        return modelAndView;
    }

    /**注册*/
    @RequestMapping("/enrollInfo")
    @ResponseBody
    public Result enrollInfo(RegisteredInfoDto registeredInfo){
        int i = fundAccountService.enrollInfo(registeredInfo);
        if (i == 1){
            result.setData(i);
            result.setMessage("注册成功");
            result.setResultCode(ResultCode.SUCCESS);
        }else {
            result.setMessage("注册失败，详情请查询http://www.baidu.com");
            result.setResultCode(ResultCode.ERROR);
        }
        return  result;
    }

    /**按条件查询  的条件 判断*/
    @RequestMapping("/getConditional")
    public Result getConditional(IsSaveInfoDto isSaveInfo) throws Exception {
        Result res = fundAccountService.toCheck(isSaveInfo);
        return  res;
    }

    /**根据基金code返回基金的名称和基金代码*/
    @RequestMapping("/getFundName")
    public Result getFundName(Fund fundNameAndCode){
        Result fundName = fundAccountService.getFundName(fundNameAndCode);
        result.setData(fundName);
        return  result;
    };

    /**申购的提交*/
    @RequestMapping("/submitPurchase")
    public Result submitPurchase(){
        result = new Result();
        return result;
    }

    /**核对客户资料    待完善*/
    @RequestMapping("/checkCustomerInformation")
    public Result checkCustomerInformation(FundAccount fundAccount){
        result = fundAccountService.checkPurchaseInfo(fundAccount);
        return result;
    }

   /**新增申购信息*/
   @RequestMapping("/addPurchaseInfo")
   public Result addPurchaseInfo(PurchaseDto purchaseDto){
       result = fundAccountService.insertPurchaseInfo(purchaseDto);
       return result;
   }

    @Resource
    private FundAccountDao fundAccount;
    /**查询全部数据*/
    @RequestMapping("/query")
    public List<FundAccount> query(){
        List<FundAccount> fundAccounts = fundAccount.queryInfos();
        return  fundAccounts;
    }

}
