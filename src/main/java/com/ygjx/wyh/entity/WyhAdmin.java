package com.ygjx.wyh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  
 * @Author  WYH
 * @Date 2019-10-31 
 */

@Data
@Table ( name ="ac_admin" )
public class WyhAdmin implements Serializable {

	private static final long serialVersionUID =  2683423801843815438L;

	/**
	 * 管理员ID
	 */
   	@Column(name = "admin_id" )
	private Integer adminId;

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
	 * 网点名称
	 */
   	@Column(name = "admin_dot" )
	private String adminDot;

}
