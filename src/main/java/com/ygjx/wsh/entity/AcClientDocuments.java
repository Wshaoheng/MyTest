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
 * @Date 2019-11-04 
 */

@Data
@Table ( name ="ac_client_documents" )
public class AcClientDocuments  implements Serializable {

	private static final long serialVersionUID =  7293532703954900608L;

	/**
	 * 证件类型id
	 */
   	@Column(name = "documents_id" )
	private Integer documentsId;

	/**
	 * 证件名
	 */
   	@Column(name = "documents_name" )
	private String documentsName;

}
