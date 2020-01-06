package com.ygjx.fxm.entity;

import lombok.Data;

@Data
public class AcLaundering {
    /**
     * 反洗钱id
     */
    private Integer laundId;
    /**
     * 交易账号
     */
    private String laundAccount;
    /**
     * 国籍
     */
    private String laundNationality;
    /**
     * 年收入
     */
    private String laundAnnualincome;
    /**
     * 学历
     */
    private String laundEducation;
    /**
     * 社会关系
     */
    private Integer laundSocial;
    /**
     * 职业风险
     */
    private Integer laundRisk;
    /**
     * 婚姻
     */
    private String laundMarriage;
    /**
     * 证件登记地址
     */
    private String laundAddress;
    /**
     * 反洗钱风险等级
     */
    private Integer laundGrade;
    /**
     * 反洗钱备注
     */
    private String laundAntiremarks;
    /**
     * 备注
     */
    private String laundRemarks;
}