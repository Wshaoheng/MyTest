package com.ygjx.wsh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



 @Data
@Table ( name ="ac_bank" )
public class AcBank  implements Serializable {

	private static final long serialVersionUID =  6442091564817026595L;

	/**
	 * 主键
	 */
   	@Column(name = "bank_id" )
	private Integer bankId;

	/**
	 * 银行全称
	 */
   	@Column(name = "bank_full_name" )
	private String bankFullName;

	/**
	 * 省
	 */
   	@Column(name = "bank_province" )
	private String bankProvince;

	/**
	 * 市
	 */
   	@Column(name = "bank_city" )
	private String bankCity;

	/**
	 * 联行号
	 */
   	@Column(name = "jones_lang_lasalle" )
	private String jonesLangLasalle;

	/**
	 * 银行id
	 */
   	@Column(name = "bank_name_id" )
	private Integer bankNameId;

}
