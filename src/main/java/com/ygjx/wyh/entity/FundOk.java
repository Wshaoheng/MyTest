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
 * @Date 2019-11-01 
 */

@Data
@Table ( name ="ac_fund_ok" )
public class FundOk implements Serializable {

	private static final long serialVersionUID =  6161940201310829282L;

	/**
	 * 主键id
	 */
   	@Column(name = "id" )
	private Integer id;

	/**
	 * 基金金额的id
	 */
   	@Column(name = "fund_money_id" )
	private Integer fundMoneyId;

	/**
	 * 确认编号
	 */
   	@Column(name = "ok_num" )
	private String okNum;

	/**
	 * 确认时间
	 */
   	@Column(name = "ok_time" )
	private String okTime;

}
