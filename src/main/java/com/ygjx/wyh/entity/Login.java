package com.ygjx.wyh.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author ：wyh
 * @date ：Created in 2019/10/24 15:23
 * @description：用户表
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Login {
    /**管理员id*/
    @NotNull(message = "管理员id不能为空")
    private int adminId;

    /**管理员账号*/
    @NotNull(message = "管理员账号不能为空")
    private String adminAccount;

    /**管理员密码*/
    @NotNull(message = "管理员密码不能为空")
    private String adminPassword;

    /**是否超级管理员？0:1*/
    @NotNull(message = "是否超级管理员不能为空")
    private int adminState;

    /**管理员证件类型*/
    private int adminType;

    /**管理员证件号*/
    private String adminNum;

    /**网点名称*/
    private String adminDot;

}
