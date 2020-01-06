package com.ygjx.wsh.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;



 @Data
@Table ( name ="ac_admin" )
public class AcAdmin  implements Serializable {

	private static final long serialVersionUID =  651463817167355285L;

	/**
	 * 管理员ID  sdfsdfdsf
	 */
   	@Column(name = "admin_id" )
	private Integer adminId;
	/**
	 * 银行id
	 */
	@Column(name = "admin_dot_name")
   	private Integer adminDotName;

	/**
	 * 管理员账号(包括姓名)
	 */
   	@Column(name = "admin_account" )
	private String adminAccount;

	/**
	 * 管理员密码
	 */
   	@Column(name = "admin_password" )
	private String adminPassword;

	/**
	 * 是否超级管理员？0:1
	 */
   	@Column(name = "admin_state" )
	private Integer adminState;

	/**
	 * 管理员证件类型
	 */
   	@Column(name = "admin_type" )
	private Integer adminType;

	/**
	 * 管理员证件号
	 */
   	@Column(name = "admin_num" )
	private String adminNum;

	/**
	 * 网点名称id
	 */
   	@Column(name = "admin_dot" )
	private Integer adminDot;

}
