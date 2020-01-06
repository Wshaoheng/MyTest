package com.ygjx.fxm.entity;

import lombok.Data;

@Data
public class AcAgent {
    /**
     * 代办人id
     */
    private Integer agentId;
    /**
     * 代办人姓名
     */
    private String agentName;
    /**
     * 代办人手机号
     */
    private String agentPhone;
    /**
     * 代办人证件类型
     */
    private Integer agentType;
    /**
     * 代办人证件号码
     */
    private String agentNum;
    /**
     * 代办人证件号码有效期
     */
    private String agentValidity;
    /**
     * 授权委托书有效期
     */
    private String agentPower;
    /**
     * 代办权限
     */
    private Integer agentAgency;
    /**
     * 与申请人关系
     */
    private String agentRelation;
    /**
     * 代办理由
     */
    private String agentReson;
    /**
     * 代办人地址
     */
    private String agentAddress;
    /**
     * 代办人邮编
     */
    private String agentZipcode;
    /**
     * 客户交易账号
     */
    private String agentClient;
}
