package com.ygjx.wyh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：wyh
 * @date ：Created in 2019/11/7 9:53
 * @description：
 * @modified By：跳转页面的controller
 * @version:
 */
@Controller
public class FundHtmlWyhController {

    /**去登录*/
    @RequestMapping("/toFundLogin")
    public String toFundLogin(){
        return "fundLogin";
    }

    /**资金存入*/
    @RequestMapping("/depositOfFunds")
    public String depositOfFunds(){

        return "depositOfFunds";
    }

    /**去申购*/
    @RequestMapping("/toSubscription")
    public String toSubscription(){
        return "subscription";
    }
    /**去赎回*/
    @RequestMapping("/toRedemption")
    public String toRedemption(){

        return "redemption";
    }
    /**去指定赎回*/
    @RequestMapping("/toDesignation")
    public String toDesignation(){

        return "designation";
    }
    /**去交易撤单*/
    @RequestMapping("/toWithdrawal")
    public String toWithdrawal(){

        return "transactionWithdrawal";
    }
}
