package com.ygjx.wsh.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Data;



@Data
@Table ( name ="ac_bank_info" )
public class AcBankInfo  implements Serializable {

	private static final long serialVersionUID =  8008930404016933935L;

	/**
	 * 关系表id
	 */
   	@Column(name = "id" )
	private Integer id;

	/**
	 * 客户交易账号
	 */
   	@Column(name = "client_account" )
	private String clientAccount;

	/**
	 * 银行账号
	 */
   	@Column(name = "bank_account" )
	private String bankAccount;

	/**
	 * 银行卡余额
	 */
   	@Column(name = "bank_blance" )
	private Double bankBlance;
	/**
	 * 关系表id
	 */
   	@Column(name = "bank_id" )
   	private Integer bankId;

}
