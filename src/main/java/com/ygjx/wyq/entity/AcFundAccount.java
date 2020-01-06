package com.ygjx.wyq.entity;

import com.ygjx.fxm.entity.AcClient;
import com.ygjx.wsh.entity.AcAdmin;
import com.ygjx.wsh.entity.AcClientDocuments;
import com.ygjx.wsh.entity.AccClient;

import java.util.Date;
import java.util.List;

public class AcFundAccount {
    //基金账号
    private String fundAccount;
    //基金账号密码
    private String fundPassword;
    //委托方式
    private String fundWei;
    //客户姓名
    private String clientName;
    //客户性别
    private String clientSex;
    //账户类型
    private String accountType;
    //证件类型
    private Integer clientType;
    //证件号码
    private String clientNum;
    //国籍
    private String fundNationality;
    //证件有效期
    private String clientValidity;
    //交易密码
    private String clientPassword;
    //TA代码
    private String clientTacode;
    //汇兑标志
    private String fundSign;
    //邮政编码
    private String clientPostcode;
    //联系电话
    private String clientTel;
    //传真号码
    private String fundFax;
    //手机号码
    private String clientPhone;
    //通讯地址
    private String mailAddress;
    //电子邮件
    private String email;
    //折扣率
    private Float discountRate;
    //分红方式
    private String fen;
    //资金方式
    private String capital;
    //对账单寄送方式
    private String billing;
    //对账单寄送途径
    private String billingApproach;
    //客户生日
    private Date clientBirthday;
    //客户职业
    private String clientOccupation;
    //交易账号
    private String clientAccount;
    //经办人id
    private Integer managerId;
    //银行id
    private Integer bankId;
    //风险分数
    private Double riskScore;
    //类别表
    private FundType fundType;
    //申购信息
    private AcFundMoney acFundMoney;
    //基金信息
    private AcFund acFund;
    //基金关系表
    private AcFundInfo acFundInfo;
    //交易表
    private AcClient acClient;

    private AcAdmin acAdmin;

    private AcClientDocuments acClientDocuments;

    private AccClient accClient;

    public AccClient getAccClient() {
        return accClient;
    }

    public void setAccClient(AccClient accClient) {
        this.accClient = accClient;
    }

    public AcClientDocuments getAcClientDocuments() {
        return acClientDocuments;
    }

    public void setAcClientDocuments(AcClientDocuments acClientDocuments) {
        this.acClientDocuments = acClientDocuments;
    }

    public Double getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(Double riskScore) {
        this.riskScore = riskScore;
    }

    public AcAdmin getAcAdmin() {
        return acAdmin;
    }

    public void setAcAdmin(AcAdmin acAdmin) {
        this.acAdmin = acAdmin;
    }

    public AcClient getAcClient() {
        return acClient;
    }

    public void setAcClient(AcClient acClient) {
        this.acClient = acClient;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public AcFundMoney getAcFundMoney() {
        return acFundMoney;
    }

    public void setAcFundMoney(AcFundMoney acFundMoney) {
        this.acFundMoney = acFundMoney;
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

    public FundType getFundType() {
        return fundType;
    }

    public void setFundType(FundType fundType) {
        this.fundType = fundType;
    }

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount == null ? null : fundAccount.trim();
    }

    public String getFundPassword() {
        return fundPassword;
    }

    public void setFundPassword(String fundPassword) {
        this.fundPassword = fundPassword == null ? null : fundPassword.trim();
    }

    public String getFundWei() {
        return fundWei;
    }

    public void setFundWei(String fundWei) {
        this.fundWei = fundWei == null ? null : fundWei.trim();
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName == null ? null : clientName.trim();
    }

    public String getClientSex() {
        return clientSex;
    }

    public void setClientSex(String clientSex) {
        this.clientSex = clientSex == null ? null : clientSex.trim();
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    public String getClientNum() {
        return clientNum;
    }

    public void setClientNum(String clientNum) {
        this.clientNum = clientNum == null ? null : clientNum.trim();
    }

    public String getFundNationality() {
        return fundNationality;
    }

    public void setFundNationality(String fundNationality) {
        this.fundNationality = fundNationality == null ? null : fundNationality.trim();
    }

    public String getClientValidity() {
        return clientValidity;
    }

    public void setClientValidity(String clientValidity) {
        this.clientValidity = clientValidity == null ? null : clientValidity.trim();
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword == null ? null : clientPassword.trim();
    }

    public String getClientTacode() {
        return clientTacode;
    }

    public void setClientTacode(String clientTacode) {
        this.clientTacode = clientTacode == null ? null : clientTacode.trim();
    }

    public String getFundSign() {
        return fundSign;
    }

    public void setFundSign(String fundSign) {
        this.fundSign = fundSign == null ? null : fundSign.trim();
    }

    public String getClientPostcode() {
        return clientPostcode;
    }

    public void setClientPostcode(String clientPostcode) {
        this.clientPostcode = clientPostcode == null ? null : clientPostcode.trim();
    }

    public String getClientTel() {
        return clientTel;
    }

    public void setClientTel(String clientTel) {
        this.clientTel = clientTel == null ? null : clientTel.trim();
    }

    public String getFundFax() {
        return fundFax;
    }

    public void setFundFax(String fundFax) {
        this.fundFax = fundFax == null ? null : fundFax.trim();
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone == null ? null : clientPhone.trim();
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress == null ? null : mailAddress.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Float getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Float discountRate) {
        this.discountRate = discountRate;
    }

    public String getFen() {
        return fen;
    }

    public void setFen(String fen) {
        this.fen = fen == null ? null : fen.trim();
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital == null ? null : capital.trim();
    }

    public String getBilling() {
        return billing;
    }

    public void setBilling(String billing) {
        this.billing = billing == null ? null : billing.trim();
    }

    public String getBillingApproach() {
        return billingApproach;
    }

    public void setBillingApproach(String billingApproach) {
        this.billingApproach = billingApproach == null ? null : billingApproach.trim();
    }

    public Date getClientBirthday() {
        return clientBirthday;
    }

    public void setClientBirthday(Date clientBirthday) {
        this.clientBirthday = clientBirthday;
    }

    public String getClientOccupation() {
        return clientOccupation;
    }

    public void setClientOccupation(String clientOccupation) {
        this.clientOccupation = clientOccupation == null ? null : clientOccupation.trim();
    }

    public String getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(String clientAccount) {
        this.clientAccount = clientAccount == null ? null : clientAccount.trim();
    }


}