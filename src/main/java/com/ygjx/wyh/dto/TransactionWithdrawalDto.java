package com.ygjx.wyh.dto;

import lombok.Data;


/**
 * @author ：wyh
 * @date ：Created in 2019/11/18 10:11
 * @description：
 * @modified By：
 * @version:
 */
@Data
public class TransactionWithdrawalDto {

    /**客户名称*/
    private String clientName;
    /**证件类型*/
    private String codeType;
    /**证件号码*/
    private String codeNum;
    /**客户类型*/
    private String type;
    /**经办人*/
    private String manager;
    /**经办人证件*/
    private String managerCodeType;
    /**经办人号码*/
    private String managerCodeNum;
}
