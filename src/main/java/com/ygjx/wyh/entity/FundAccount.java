package com.ygjx.wyh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

/**
 * @Description  
 * @Author  WYH
 * @Date 2019-11-12 
 */

@Data
@Table ( name ="ac_fund_account" )
public class FundAccount implements Serializable {

	private static final long serialVersionUID =  5558355253315601968L;

	/**
	 * 基金账号
	 */
   	@Column(name = "fund_account" )
	private String fundAccount;

	/**
	 * 基金账号密码
	 */
   	@Column(name = "fund_password" )
	private String fundPassword;

	/**
	 * 委托方式
	 */
   	@Column(name = "fund_wei" )
	private String fundWei;

	/**
	 * 客户姓名
	 */
   	@Column(name = "client_name" )
	private String clientName;

	/**
	 * 客户性别
	 */
   	@Column(name = "client_sex" )
	private String clientSex;

	/**
	 * 账户类型
	 */
   	@Column(name = "account_type" )
	private String accountType;

	/**
	 * 证件类型
	 */
   	@Column(name = "client_type" )
	private Integer clientType;

	/**
	 * 证件号码
	 */
   	@Column(name = "client_num" )
	private String clientNum;

	/**
	 * 国籍
	 */
   	@Column(name = "fund_nationality" )
	private String fundNationality;

	/**
	 * 证件有效期
	 */
   	@Column(name = "client_validity" )
	private String clientValidity;

	/**
	 * 交易密码
	 */
   	@Column(name = "client_password" )
	private String clientPassword;

	/**
	 * TA代码
	 */
   	@Column(name = "client_taCode" )
	private String clientTaCode;

	/**
	 * 汇兑标志
	 */
   	@Column(name = "fund_sign" )
	private String fundSign;

	/**
	 * 邮政编码
	 */
   	@Column(name = "client_postCode" )
	private String clientPostCode;

	/**
	 * 联系电话
	 */
   	@Column(name = "client_tel" )
	private String clientTel;

	/**
	 * 传真号码
	 */
   	@Column(name = "fund_fax" )
	private String fundFax;

	/**
	 * 手机号码
	 */
   	@Column(name = "client_phone" )
	private String clientPhone;

	/**
	 * 通讯地址
	 */
   	@Column(name = "mail_address" )
	private String mailAddress;

	/**
	 * 电子邮件
	 */
   	@Column(name = "email" )
	private String email;

	/**
	 * 折扣率
	 */
   	@Column(name = "discount_rate" )
	private Double discountRate;

	/**
	 * 分红方式
	 */
   	@Column(name = "fen" )
	private String fen;

	/**
	 * 资金方式
	 */
   	@Column(name = "capital" )
	private String capital;

	/**
	 * 对账单寄送方式
	 */
   	@Column(name = "billing" )
	private String billing;

	/**
	 * 对账单寄送途径
	 */
   	@Column(name = "billing_approach" )
	private String billingApproach;

	/**
	 * 客户生日
	 */
   	@Column(name = "client_birthday" )
	private Date clientBirthday;

	/**
	 * 客户职业
	 */
   	@Column(name = "client_occupation" )
	private String clientOccupation;

	/**
	 * 交易账号
	 */
   	@Column(name = "client_account" )
	private String clientAccount;

	/**
	 * 经办人id
	 */
   	@Column(name = "manager_id" )
	private Integer managerId;

	/**
	 * 银行id
	 */
   	@Column(name = "bank_id" )
	private Integer bankId;

}
