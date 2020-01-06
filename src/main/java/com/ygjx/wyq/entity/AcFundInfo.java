package com.ygjx.wyq.entity;

public class AcFundInfo {
    //基金关系id
    private Integer fundInfoId;
    //基金账户
    private String fundInfoAccount;
    //购买的基金id
    private Integer fundInfoFund;

    public Integer getFundInfoId() {
        return fundInfoId;
    }

    public void setFundInfoId(Integer fundInfoId) {
        this.fundInfoId = fundInfoId;
    }

    public String getFundInfoAccount() {
        return fundInfoAccount;
    }

    public void setFundInfoAccount(String fundInfoAccount) {
        this.fundInfoAccount = fundInfoAccount == null ? null : fundInfoAccount.trim();
    }

    public Integer getFundInfoFund() {
        return fundInfoFund;
    }

    public void setFundInfoFund(Integer fundInfoFund) {
        this.fundInfoFund = fundInfoFund;
    }
}