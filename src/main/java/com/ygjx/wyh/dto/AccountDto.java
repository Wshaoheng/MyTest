package com.ygjx.wyh.dto;

import lombok.Data;

/**
 * @author ：wyh
 * @date ：Created in 2019/11/1 16:32
 * @description：账户dto
 * @modified By：
 * @version: 1.0
 */
@Data
public class AccountDto {

    /**交易账号*/
    private String clientAccount;


    /**基金账号*/
    private String fundAccount;
}
