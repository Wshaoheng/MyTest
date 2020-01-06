package com.ygjx.wyh.dto;

import lombok.Data;

/**
 * @author ：wyh
 * @date ：Created in 2019/10/31 17:17
 * @description：基金指定赎回的表格
 * @modified By：
 * @version: 1.0
 */
@Data
public class RedemptionForm2 {

    /**基金赎回的表格*/
    /**=========================*/

    /**基金代码*/
    private String fundCode;

    /**收费方式*/
    private String shareCategory;

    /**确认日期*/
    private String sureDate;

    /**TA确认编号*/
    private String sureNumWithTa;

    /**份额来源*/
    private String shareSource;

    /**可用份额余额*/
    private Integer shareBalance;

    /**交易冻结份额*/
    private Double freezingShare;

    /**基金赎回 默认是指定赎回 是个按钮*/
    private String redemption;
}
