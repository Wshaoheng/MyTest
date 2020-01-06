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
 * @Date 2019-10-31 
 */

@Data
@Table ( name ="ac_counter" )
public class AcCounter  implements Serializable {

	private static final long serialVersionUID =  64322927573219353L;

	/**
	 * 柜台编号
	 */
   	@Column(name = "counter_id" )
	private Integer counterId;

	/**
	 * 操作时间
	 */
   	@Column(name = "operating_time" )
	private String operatingTime;

	/**
	 * 操作类型(就是进行了什么操作)
	 */
   	@Column(name = "operation_type" )
	private String operationType;

	/**
	 * 管理员编号
	 */
   	@Column(name = "admin_id" )
	private Integer adminId;

	/**
	 * 交易帐号
	 */
   	@Column(name = "client_account" )
	private String clientAccount;

	/**
	 * 基金账号
	 */
   	@Column(name = "fund_account" )
	private String fundAccount;
	/**
	 * 流水单的状态（0就是确认了  1是不确认的）
	 */
	@Column(name = "status" )
	private Integer status;

}
