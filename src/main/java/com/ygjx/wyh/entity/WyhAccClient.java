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
@Table ( name ="acc_client" )
public class WyhAccClient implements Serializable {

	private static final long serialVersionUID =  8830593839308870881L;

	/**
	 * 交易账号
	 */
   	@Column(name = "acc_account" )
	private String accAccount;

	/**
	 * 客户名称(机构名称)
	 */
   	@Column(name = "customer_name" )
	private String customerName;

	/**
	 * 证件类型
	 */
   	@Column(name = "certificate_type" )
	private String certificateType;

	/**
	 * 证件号码
	 */
   	@Column(name = "certificate_num" )
	private String certificateNum;

	/**
	 * 证件有效期
	 */
   	@Column(name = "certificate_validity" )
	private String certificateValidity;

	/**
	 * 省
	 */
   	@Column(name = "province" )
	private String province;

	/**
	 * 市
	 */
   	@Column(name = "city" )
	private String city;

	/**
	 * 通讯地址
	 */
   	@Column(name = "correspondence_address" )
	private String correspondenceAddress;

	/**
	 * 邮政编码
	 */
   	@Column(name = "post_code" )
	private String postCode;

	/**
	 * 联系电话1
	 */
   	@Column(name = "telphone_1" )
	private String telphone1;

	/**
	 * 联系电话2
	 */
   	@Column(name = "telphone_2" )
	private String telphone2;

	/**
	 * 服务定制
	 */
   	@Column(name = "custom_service" )
	private String customService;

	/**
	 * 邮箱地址
	 */
   	@Column(name = "email_address" )
	private String emailAddress;

	/**
	 * 手机号码
	 */
   	@Column(name = "phone" )
	private String phone;

	/**
	 * 客户简称
	 */
   	@Column(name = "customer_referred" )
	private String customerReferred;

	/**
	 * 传真号码
	 */
   	@Column(name = "fax_num_1" )
	private String faxNum1;

	/**
	 * 传真号码2
	 */
   	@Column(name = "fax_num_2" )
	private String faxNum2;

	/**
	 * 交易密码
	 */
   	@Column(name = "trade_password" )
	private String tradePassword;

	/**
	 * 是否寄送确认书 0 代表‘是’ 1 代表‘否’
	 */
   	@Column(name = "send_confirmation" )
	private Integer sendConfirmation;

	/**
	 * 上交所账号
	 */
   	@Column(name = "shanghai_stock_exchange_account" )
	private String shanghaiStockExchangeAccount;

	/**
	 * 深交所账号
	 */
   	@Column(name = "shenzhen_stock_exchange_account" )
	private String shenzhenStockExchangeAccount;

	/**
	 * TA代码
	 */
   	@Column(name = "ta_code" )
	private String taCode;

	/**
	 * 基金账号
	 */
   	@Column(name = "fund_account" )
	private String fundAccount;

	/**
	 * 渠道id
	 */
   	@Column(name = "channel_id" )
	private Integer channelId;

	/**
	 * 传真委托 0代表‘允许’ 1 代表‘不允许’
	 */
   	@Column(name = "commissioned_by_facsimile" )
	private Integer commissionedByFacsimile;

	/**
	 * 管理员ID
	 */
   	@Column(name = "admin_id" )
	private Integer adminId;

	/**
	 * 默认值
	 */
   	@Column(name = "client_acc" )
	private String clientAcc;

}
