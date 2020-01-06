package com.ygjx.wsh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2019-11-15 
 */

@Data
@Table ( name ="ac_client_personal" )
public class AcClientPersonal  implements Serializable {

	private static final long serialVersionUID =  3101677981415952216L;


	@Id
   	@Column(name = "client_id" )
	private Integer clientId;

	/**
	 * 客户的选择
	 */
   	@Column(name = "client_personal_checked" )
	private Integer clientPersonalChecked;

	/**
	 * 交易账号
	 */
   	@Column(name = "client_account" )
	private String clientAccount;

	/**
	 * 题号
	 */
   	@Column(name = "client_personal_id" )
	private Integer clientPersonalId;

}
