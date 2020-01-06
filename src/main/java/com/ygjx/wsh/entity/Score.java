package com.ygjx.wsh.entity;

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
 * @Author  Hunter
 * @Date 2019-11-18 
 */

@Data
@Table ( name ="score" )
public class Score  implements Serializable {

	private static final long serialVersionUID =  186929842988870598L;

	/**
	 * 交易账号
	 */
   	@Column(name = "client_account" )
	private String clientAccount;

	/**
	 * 风险分数
	 */
   	@Column(name = "client_score" )
	private Integer clientScore;

}
