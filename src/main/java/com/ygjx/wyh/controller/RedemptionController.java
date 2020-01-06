package com.ygjx.wyh.controller;

import com.ygjx.wyh.dto.AccountDto;
import com.ygjx.wyh.dto.RedemptionInfo2Dto;
import com.ygjx.wyh.entity.FundAccount;
import com.ygjx.wyh.sevice.FundAccountService;
import com.ygjx.wyh.sevice.RedemptionService;
import com.ygjx.wyh.util.Result;
import com.ygjx.wyh.util.ResultCode;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author ：wyh
 * @date ：Created in 2019/10/29 18:33
 * @description：基金赎回的controller
 * @modified By：
 * @version: 1.0
 */
@Controller
@RequestMapping("/redemptionController")
public class RedemptionController {

    @Resource
    private RedemptionService redemptionService;

    @Resource
    private FundAccountService fundAccountService;

    Result result = null;
    /**赎回份额*/
    @RequestMapping("/shuhui")
    public ModelAndView shuhui(String id, String ransom){
        FundAccount res = fundAccountService.selectFundAccountInfos(id);
        ModelAndView mv = new ModelAndView();
        RedemptionInfo2Dto a  = new RedemptionInfo2Dto();
        a.setFundInfoAccount(res.getFundAccount());
        a.setClientAccount(id);
        Result result = redemptionService.queryShareRedemption(a, ransom);
        mv.addObject("result",result);
        mv.addObject("res",res);
        mv.setViewName("redemption");
        return mv;
    }


    /**赎回的界面展示的表格*/
    @RequestMapping("/redemptionForm")
    @ResponseBody
    public Result redemptionForm(String ransom, AccountDto accountDto){
        result = redemptionService.queryRedemptionForm(ransom,accountDto);
        return result;
    }

    /**交易撤单*/
    @RequestMapping("/transactionWithdrawal")
    @ResponseBody
    public Result transactionWithdrawal(Integer counterId,AccountDto accountDto){
        Result withdrawal = redemptionService.withdrawal(counterId,accountDto);
        return withdrawal;
    }


}
