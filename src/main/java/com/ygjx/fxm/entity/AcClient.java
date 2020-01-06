package com.ygjx.fxm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Scope("prototype") //是否是单例注解,prototype:不是单例,singleton:单例，默认值
@Component
public class AcClient {
    /**
     * 交易账号
     */
    private String clientAccount;
    /**
     * 客户姓名
     */
    private String clientName;
    /**
     * 客户性别
     */
    private String  clientSex;
    /**
     * 证件类型
     */
    private Integer clientType;
    /**
     * 证件号
     */
    private String clientNum;
    /**
     * 证件有效期
     */
    private String clientValidity;
    /**
     * 客户生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date clientBirthday;
    /**
     * 省
     */
    private String clientProvince;
    /**
     * 市
     */
    private Integer clientCity;
    /**
     * 详细地址
     */
    private String clientAddress;
    /**
     * 邮政编码
     */
    private String clientPostcode;
    /**
     * 联系电话
     */
    private String clientTel;
    /**
     * 手机号
     */
    private String clientPhone;
    /**
     * 交易密码
     */
    private String clientPassword;
    /**
     * 客户职业
     */
    private String clientOccupation;
    /**
     * 受益人
     */
    private String clientBeneficiary;
    /**
     * 控制人
     */
    private String clientController;
    /**
     * 投资经历
     */
    private Integer clientExperience;
    /**
     * 代办人id
     */
    private Integer agentId;
    /**
     * 个人还是机构
     */
    private String clientPeople;
    /**
     * 是否销户
     */
    private Integer clientIsdel;

}