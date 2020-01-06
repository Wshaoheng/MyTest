package com.ygjx.wyq.entity;

import com.ygjx.fxm.entity.AcClient;
import com.ygjx.wsh.entity.AcAdmin;
import com.ygjx.wsh.entity.AcClientDocuments;
import com.ygjx.wsh.entity.AcCounter;
import com.ygjx.wsh.entity.AccClient;

import java.util.List;

public class AcFundMoney {
    //主键id
    private Integer id;
    //基金名称
    private String fundName;
    //份额类别
    private String shareCategory;
    //币种
    private String currency;
    //折扣率
    private String discountRate;
    //资金方式
    private String fundMethod;
    //经办人
    private String broker;
    //申购金额
    private Double purchaseAmount;
    //可用金额
    private Double amountAvailable;
    //可用份额
    private Integer availableShare;
    private String fen;
    //基金信息
    private AcFund acFund;
    //基金关系表
    private AcFundInfo acFundInfo;
    //交易表
    private AcClient acClient;

    private AcAdmin acAdmin;

    private AcClientDocuments acClientDocuments;

    private AccClient accClient;

    private AcFundAccount acFundAccount;

    private AcCounter acCounter;

    public AcCounter getAcCounter() {
        return acCounter;
    }

    public void setAcCounter(AcCounter acCounter) {
        this.acCounter = acCounter;
    }

    public String getFen() {
        return fen;
    }

    public void setFen(String fen) {
        this.fen = fen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getShareCategory() {
        return shareCategory;
    }

    public void setShareCategory(String shareCategory) {
        this.shareCategory = shareCategory;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    public String getFundMethod() {
        return fundMethod;
    }

    public void setFundMethod(String fundMethod) {
        this.fundMethod = fundMethod;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public Double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(Double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Double getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(Double amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public Integer getAvailableShare() {
        return availableShare;
    }

    public void setAvailableShare(Integer availableShare) {
        this.availableShare = availableShare;
    }

    public AcFund getAcFund() {
        return acFund;
    }

    public void setAcFund(AcFund acFund) {
        this.acFund = acFund;
    }

    public AcFundInfo getAcFundInfo() {
        return acFundInfo;
    }

    public void setAcFundInfo(AcFundInfo acFundInfo) {
        this.acFundInfo = acFundInfo;
    }

    public AcClient getAcClient() {
        return acClient;
    }

    public void setAcClient(AcClient acClient) {
        this.acClient = acClient;
    }

    public AcAdmin getAcAdmin() {
        return acAdmin;
    }

    public void setAcAdmin(AcAdmin acAdmin) {
        this.acAdmin = acAdmin;
    }

    public AcClientDocuments getAcClientDocuments() {
        return acClientDocuments;
    }

    public void setAcClientDocuments(AcClientDocuments acClientDocuments) {
        this.acClientDocuments = acClientDocuments;
    }

    public AccClient getAccClient() {
        return accClient;
    }

    public void setAccClient(AccClient accClient) {
        this.accClient = accClient;
    }

    public AcFundAccount getAcFundAccount() {
        return acFundAccount;
    }

    public void setAcFundAccount(AcFundAccount acFundAccount) {
        this.acFundAccount = acFundAccount;
    }

    @Override
    public String toString() {
        return "AcFundMoney{" +
                "id=" + id +
                ", fundName='" + fundName + '\'' +
                ", shareCategory='" + shareCategory + '\'' +
                ", currency='" + currency + '\'' +
                ", discountRate='" + discountRate + '\'' +
                ", fundMethod='" + fundMethod + '\'' +
                ", broker='" + broker + '\'' +
                ", purchaseAmount=" + purchaseAmount +
                ", amountAvailable=" + amountAvailable +
                ", availableShare=" + availableShare +
                ", fen='" + fen + '\'' +
                ", acFund=" + acFund +
                ", acFundInfo=" + acFundInfo +
                ", acClient=" + acClient +
                ", acAdmin=" + acAdmin +
                ", acClientDocuments=" + acClientDocuments +
                ", accClient=" + accClient +
                ", acFundAccount=" + acFundAccount +
                '}';
    }
}