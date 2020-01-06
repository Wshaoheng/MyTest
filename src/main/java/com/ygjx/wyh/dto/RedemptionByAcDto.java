package com.ygjx.wyh.dto;

import lombok.Data;

/**
 * @author ：wyh
 * @date ：Created in 2019/10/30 14:46
 * @description：基金赎回个人
 * @modified By：
 * @version: 1.0
 */
@Data
public class RedemptionByAcDto {

    /**
     * 交易账号
     */
    private String bankAccount;

    /**基金账号*/
    private String fundAccount;

    /**客户名称  同银行户名*/
    private  String clientName;
    /**客户类型 固定是个人*/
    private String clientPeople;
    /**证件类型 数据库中是int类型*/
    private Integer clientType;
    /**证件号码*/
    private String clientNum;

    /**=================*/

    /**
     * 主键   银行编号
     */
    private Integer bankId;

    /**
     * 开户银行名称
     */
    private String bankFullName;



    /**
     * 银行账号
     */
    private String bankCode;


}
