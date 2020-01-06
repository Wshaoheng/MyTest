package com.ygjx.wyh.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * @Description  
 * @Author  WYH
 * @Date 2019-11-01 
 */

@Data
public class Counter implements Serializable {

	//private static final long serialVersionUID =  8589396843899392925L;

	/**
	 * 柜台编号
	 */

	private Integer counterId;

	/**
	 * 操作时间
	 */

	private String operatingTime;

	/**
	 * 操作类型(就是进行了什么操作)
	 */

	private String operationType;

	/**
	 * 管理员编号
	 */

	private Integer adminId;

	/**
	 * 交易帐号
	 */

	private String clientAccount;

	/**
	 * 基金账号
	 */

	private String fundAccount;

	/**
	 * 流水单的状态（0就是确认了  1是不确认的）
	 */

	private Integer status;

}
