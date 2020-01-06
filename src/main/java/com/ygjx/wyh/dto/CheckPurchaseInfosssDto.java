package com.ygjx.wyh.dto;

import lombok.Data;

/**
 * @author ：wyh
 * @date ：Created in 2019/10/29 10:07
 * @description：核对申购表中的信息------暂时不用
 * @modified By：
 * @version: 1.0
 */
@Data
public class CheckPurchaseInfosssDto {

    /**客户名称*/
    private String clientName;

    /**证件类型*/
    private String clientType;

    /**证件号码*/
    private String clientNum;

    /**经办人 管理员*/
    private String adminAccount;

    /**可用资金*/
    private Double amountAvailable;

    /**经办人证件 指身份证；学生证等*/
    private String documentsName;

    /**经办人号码*/
    private String adminNum;
}
