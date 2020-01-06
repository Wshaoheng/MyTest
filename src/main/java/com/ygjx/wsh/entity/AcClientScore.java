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
 * @Date 2019-11-15 
 */

@Data
@Table ( name ="ac_client_score" )
public class AcClientScore  implements Serializable {

	private static final long serialVersionUID =  6640298148173031675L;

	/**
	 * 分数id
	 */
   	@Column(name = "client_score_id" )
	private Integer clientScoreId;

	/**
	 * 题号
	 */
   	@Column(name = "client_quesiton_num" )
	private Integer clientQuesitonNum;

	/**
	 * 选择几
	 */
   	@Column(name = "client_selected" )
	private Integer clientSelected;

	/**
	 * 选择二的分数
	 */
   	@Column(name = "client_score" )
	private Integer clientScore;

}
