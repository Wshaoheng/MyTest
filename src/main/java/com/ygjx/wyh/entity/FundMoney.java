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
@Table ( name ="ac_fund_money" )
public class FundMoney implements Serializable {



	/**
	 * 主键id
	 */
   	@Column(name = "id" )
	private Integer id;

	/**
	 * 基金名称
	 */
   	@Column(name = "fund_name" )
	private String fundName;

	/**
	 * 份额类别 0.前收费 1.水平收费 2.后收费
	 */
   	@Column(name = "share_category" )
	private String shareCategory;

	/**
	 * 币种
	 */
   	@Column(name = "currency" )
	private String currency;

	/**
	 * 折扣率
	 */
   	@Column(name = "discount_rate" )
	private String discountRate;

	/**
	 * 资金方式
	 */
   	@Column(name = "fund_method" )
	private String fundMethod;

	/**
	 * 经办人
	 */
   	@Column(name = "broker" )
	private String broker;

	/**
	 * 申购金额
	 */
   	@Column(name = "purchase_amount" )
	private Double purchaseAmount;

	/**
	 * 可用金额
	 */
   	@Column(name = "amount_available" )
	private Double amountAvailable;

	/**
	 * 可用份额
	 */
   	@Column(name = "available_share" )
	private Integer availableShare;

}
