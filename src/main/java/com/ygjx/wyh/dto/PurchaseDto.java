package com.ygjx.wyh.dto;

import lombok.Data;

/**
 * @author ：wyh
 * @date ：Created in 2019/10/28 17:12
 * @description：申购信息
 * @modified By：
 * @version: 1.0
 */
@Data
public class PurchaseDto {

    /**基金名称*/
    private String fundName;

    /**份额类别 0.前收费 1.水平收费 2.后收费*/
    private String shareCategory;

    /**币种*/
    private String currency;

    /**折扣率*/
    private String discountRate;

    /**资金方式*/
    private String fundMethod;

    /**经办人*/
    private String broker;

    /**申购金额*/
    private Double purchaseAmount;

    /**可用资金*/
    private Double amountAvailable;

    /**基金帐号*/
    private String fundAccount;

    /**可用份额*/
    private Integer availableShare;

    /*=======================*/

    /**客户名称*/
    private String clientName;

    /**客户类型*/
    private String clientType;

    /**证件类型*/
    private String codeType;

    /**证件号码*/
    private String clientNum;

    /**经办人*/
    private String adminName;

    /**经办人证件 指身份证；学生证等*/
    private String documentsName;

    /**经办人号码*/
    private String adminNum;

}
