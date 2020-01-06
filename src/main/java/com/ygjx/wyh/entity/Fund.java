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
 * @Date 2019-10-30 
 */

@Data
@Table ( name ="ac_fund" )
public class Fund implements Serializable {

	private static final long serialVersionUID =  7514048510704210871L;

	/**
	 * 基金id
	 */
   	@Column(name = "fund_id" )
	private Integer fundId;

	/**
	 * 基金名称
	 */
   	@Column(name = "fund_name" )
	private String fundName;

	/**
	 * 基金类别 （登记机构） 1(华夏 031..) 2(深证中登..) 3(上海中登...)
	 */
   	@Column(name = "fund_type" )
	private String fundType;

	/**
	 * 基金风险 1.低风险 2.中风险 3.高风险
	 */
   	@Column(name = "fund_risk" )
	private String fundRisk;

	/**
	 * 基金code
	 */
   	@Column(name = "fund_code" )
	private String fundCode;

	/**
	 * 本基金剩余份额
	 */
   	@Column(name = "fund_share" )
	private Integer fundShare;

	/**
	 * 份额单价
	 */
   	@Column(name = "share_price" )
	private Double sharePrice;

}
