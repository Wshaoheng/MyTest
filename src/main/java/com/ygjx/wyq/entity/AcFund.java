package com.ygjx.wyq.entity;

public class AcFund {
    //基金id
    private Integer fundId;
    //基金名称
    private String fundName;
    //基金类别
    private Integer fundType;
    //基金风险
    private Integer fundRisk;
    //基金代码
    private String fundCode;
    //本基金剩余份额
    private Integer fundShare;
    //份额单价
    private Double sharePrice;

    public Integer getFundShare() {
        return fundShare;
    }

    public void setFundShare(Integer fundShare) {
        this.fundShare = fundShare;
    }

    public Double getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(Double sharePrice) {
        this.sharePrice = sharePrice;
    }

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName == null ? null : fundName.trim();
    }

    public Integer getFundType() {
        return fundType;
    }

    public void setFundType(Integer fundType) {
        this.fundType = fundType;
    }

    public Integer getFundRisk() {
        return fundRisk;
    }

    public void setFundRisk(Integer fundRisk) {
        this.fundRisk = fundRisk;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode == null ? null : fundCode.trim();
    }
}