package com.ygjx.wsh.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2019-10-26 
 */

 @Data
@Table ( name ="acc_other_info" )
public class AccOtherInfo  implements Serializable {

	private static final long serialVersionUID =  3109204570735937125L;

	/**
	 * 法人信息主键id
	 */
   	@Column(name = "legal_person_id" )
	private Integer legalPersonId;

	/**
	 * 法人姓名
	 */
   	@Column(name = "legal_person_name" )
	private String legalPersonName;

	/**
	 * 法人证件类型
	 */
   	@Column(name = "corporate_document_type" )
	private String corporateDocumentType;

	/**
	 * 法人证件号码
	 */
   	@Column(name = "corporate_number" )
	private String corporateNumber;

	/**
	 * 法人证件有效期
	 */
   	@Column(name = "legal_period_of_legal_person" )
	private String legalPeriodOfLegalPerson;

	/**
	 * 组织机构代码
	 */
   	@Column(name = "organization_code" )
	private String organizationCode;

	/**
	 * 组织机构代码有效期
	 */
   	@Column(name = "organization_code_expiration_date" )
	private String organizationCodeExpirationDate;

	/**
	 * 税务登记证号码
	 */
   	@Column(name = "tax_registration_number" )
	private String taxRegistrationNumber;

	/**
	 * 负责人姓名
	 */
   	@Column(name = "name_of_person_in_charge" )
	private String nameOfPersonInCharge;

	/**
	 * 负责人证件类型
	 */
   	@Column(name = "responsible_person_type" )
	private String responsiblePersonType;

	/**
	 * 负责人证件号码
	 */
   	@Column(name = "responsible_person_number" )
	private String responsiblePersonNumber;

	/**
	 * 负责人证件有效期
	 */
   	@Column(name = "principal_validity_period" )
	private String principalValidityPeriod;

	/**
	 * 控股股东名称
	 */
   	@Column(name = "controlling_shareholder_name" )
	private String controllingShareholderName;

	/**
	 * 控股股东类别
	 */
   	@Column(name = "controlling_shareholder_type" )
	private String controllingShareholderType;

	/**
	 * 控股股东证件类型
	 */
   	@Column(name = "controlling_shareholder_type_of_certificate" )
	private String controllingShareholderTypeOfCertificate;

	/**
	 * 控股股东证件号
	 */
   	@Column(name = "controlling_shareholder_license_number" )
	private String controllingShareholderLicenseNumber;

	/**
	 * 控股股东证件有效期
	 */
   	@Column(name = "controlling_shareholder_license_number_time" )
	private String controllingShareholderLicenseNumberTime;

	/**
	 * 经营范围
	 */
   	@Column(name = "business_scope" )
	private String businessScope;

	/**
	 * 账户实际控制人
	 */
   	@Column(name = "actual_account_controller" )
	private String actualAccountController;

	/**
	 * 账户实际受益人
	 */
   	@Column(name = "actual_beneficiary_of_the_account" )
	private String actualBeneficiaryOfTheAccount;

	/**
	 * 注册资本
	 */
   	@Column(name = "registered_capital" )
	private String registeredCapital;

	/**
	 * 控股股东税务登记证号
	 */
   	@Column(name = "a_tax_registration_code" )
	private String aTaxRegistrationCode;

	/**
	 * 控股股东组织代码证号
	 */
   	@Column(name = "a_organization_code_number" )
	private String aOrganizationCodeNumber;

	/**
	 * 行业类型
	 */
   	@Column(name = "industry_type" )
	private String industryType;

	/**
	 * 企业性质
	 */
   	@Column(name = "nature_of_business" )
	private String natureOfBusiness;

	/**
	 * 注册地址
	 */
   	@Column(name = "registered_address" )
	private String registeredAddress;

	/**
	 * 反洗钱风险等级
	 */
   	@Column(name = "money_laundering_risk_level" )
	private String moneyLaunderingRiskLevel;

	/**
	 * 资格证书类型
	 */
   	@Column(name = "qualification_type" )
	private String qualificationType;

	/**
	 * 资格证书号码
	 */
   	@Column(name = "qualification_certificate_number" )
	private String qualificationCertificateNumber;

	/**
	 * 资格证书有效期
	 */
   	@Column(name = "validity_period" )
	private String validityPeriod;
	/**
	 * 机构交易账号
	 */
   	@Column(name = "acc_account" )
   	private String accAccount;

}
