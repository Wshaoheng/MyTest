package com.ygjx.wyh.dto;

import lombok.Data;

import javax.persistence.Column;

/**
 * @author ：wyh
 * @date ：Created in 2019/10/30 9:24
 * @description：基金赎回机构
 * @modified By：
 * @version:1.0
 */
@Data
public class RedemptionByAccDto {


    /**
     * 交易账号
     */
    private String bankAccount;

    /**基金账号*/
    private String fundAccount;

    /**客户名称*/
    private String clientName;

    /**客户类型 个人还是机构*/
    private String clientPeople;

    /**证件类型*/
    private Integer clientType;

    /**证件号码*/
    private String clientNum;

    /**经办人*/
    /**
     * 管理员账号(包括姓名)  经办人
     */
    private String adminAccount;

    /**
     * 管理员证件类型  经办人证件
     */
    private Integer adminType;

    /**
     * 管理员证件号     经办人号码
     */
    private String adminNum;


    /**=================*/

    /**
     * 主键   银行编号
     */
    private Integer bankId;

    /**
     * 开户银行名称
     */
    private String bankOpenName;

    /**
     * 银行户名 同客户名称
     */

    /**
     * 银行账号
     */
    private String bankCode;



}
