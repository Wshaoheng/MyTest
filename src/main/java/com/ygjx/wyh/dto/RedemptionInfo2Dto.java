package com.ygjx.wyh.dto;

import lombok.Data;

/**
 * @author ：wyh
 * @date ：Created in 2019/10/30 11:03
 * @description：赎回表中可以进行修改部分
 * @modified By：
 * @version: 1.0
 */
@Data
public class RedemptionInfo2Dto {

    /**基金账号  从前台传过来的 */
    private String fundInfoAccount;
    private String clientAccount;
    /**基金名称*/
    private String fundName;
    /**份额类别*/
    private String shareType;
    /**巨额赎回*/
    private String hugeRedemption;
    /**资金方式*/
    private String fundsMethod;
    /**赎回份额*/
    private Integer availableShare;
    /**交易费折扣*/
    private Double discountRate;
    /**后交费折扣*/
    private Double afterDiscountRate;
    /**回款账号*/
    private String transactionAccount;
    /**经办人*/
    private String adminAccount;
    /**份额大写*/
    private String bigShare;
}
