package com.ygjx.wyh.dto;

import lombok.Data;

/**
 * @author ：wyh
 * @date ：Created in 2019/10/26 16:01
 * @description：判断是否存在以上信息，或者信息对不对
 * @modified By：
 * @version: 1.0$
 */
@Data
public class IsSaveInfoDto {

    /**委托方式*/
    private String delegationMethod;

    /**账户类型*/
    private String  accountType;

    /**交易账户*/
    private String  transactionAccount;

    /**交易密码*/
    private String transactionPassword;

    /**基金账户*/
    private String fundAccount;

    /**基金密码*/
    private String fundPassword;
}
