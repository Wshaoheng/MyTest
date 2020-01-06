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
 * @Date 2019-11-04 
 */

@Data
@Table ( name ="ac_client" )
public class WyhClient implements Serializable {

	private static final long serialVersionUID =  5360038775421483531L;

	/**
	 * 交易账号
	 */
   	@Column(name = "client_account" )
	private String clientAccount;

	/**
	 * 渠道编号
	 */
   	@Column(name = "channel_id" )
	private Integer channelId;

	/**
	 * 客户姓名
	 */
   	@Column(name = "client_name" )
	private String clientName;

	/**
	 * 性别
	 */
   	@Column(name = "client_sex" )
	private String clientSex;

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
	 * 证件有效期
	 */
   	@Column(name = "client_validity" )
	private String clientValidity;

	/**
	 * 客户生日
	 */
   	@Column(name = "client_birthday" )
	private Date clientBirthday;

	/**
	 * 省
	 */
   	@Column(name = "client_province" )
	private String clientProvince;

	/**
	 * 市id
	 */
   	@Column(name = "client_city" )
	private Integer clientCity;

	/**
	 * 详细地址
	 */
   	@Column(name = "client_address" )
	private String clientAddress;

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
	 * 手机号
	 */
   	@Column(name = "client_phone" )
	private String clientPhone;

	/**
	 * 交易密码
	 */
   	@Column(name = "client_password" )
	private String clientPassword;

	/**
	 * 客户职业
	 */
   	@Column(name = "client_occupation" )
	private String clientOccupation;

	/**
	 * 受益人
	 */
   	@Column(name = "client_beneficiary" )
	private String clientBeneficiary;

	/**
	 * 控制人
	 */
   	@Column(name = "client_controller" )
	private String clientController;

	/**
	 * 投资经历
	 */
   	@Column(name = "client_experience" )
	private Integer clientExperience;

	/**
	 * 代办人id
	 */
   	@Column(name = "agent_id" )
	private Integer agentId;

	/**
	 * 个人还是机构
	 */
   	@Column(name = "client_people" )
	private String clientPeople;

}
