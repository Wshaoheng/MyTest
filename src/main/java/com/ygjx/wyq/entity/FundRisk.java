package com.ygjx.wyq.entity;

public class FundRisk {
    //风险id
    private Integer riskId;
    //风险名称
    private String riskName;
    //风险范围
    private String riskScope;

    public Integer getRiskId() {
        return riskId;
    }

    public void setRiskId(Integer riskId) {
        this.riskId = riskId;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName == null ? null : riskName.trim();
    }

    public String getRiskScope() {
        return riskScope;
    }

    public void setRiskScope(String riskScope) {
        this.riskScope = riskScope == null ? null : riskScope.trim();
    }
}