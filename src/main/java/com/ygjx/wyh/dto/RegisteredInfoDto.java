package com.ygjx.wyh.dto;

import lombok.Data;

/**
 * @author ：wyh
 * @date ：Created in 2019/10/26 14:21
 * @description：注册基金帐号信息
 * @modified By：
 * @version: 1.0$
 */
@Data
public class RegisteredInfoDto {

    /**客户i姓名*/
    private String name;

    /**证件类型  默认 身份证*/
    private String cardType;

    /**证件号码*/
    private String cardNum;

    /**密码*/
    private String passWord;

    /**账号*/
    private String userName;
}
