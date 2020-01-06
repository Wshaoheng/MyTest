package com.ygjx.wyh.dto;

import lombok.Data;

/**
 * @author ：wyh
 * @date ：Created in 2019/10/31 17:17
 * @description：基金赎回的表格
 * @modified By：
 * @version: 1.0
 */
@Data
public class RedemptionForm1 {

    /**基金赎回的表格*/
    /**=========================*/

    /**基金代码*/
    private String fundCode;
    /**收费方式*/
    private String shareCategory;
    /**当前份额余额*/
    private Integer shareBalance1;
    /**可用份额余额*/
    private Integer shareBalance2;
    /**冻结份额余额*/
    private Double  freezingShare1;
    /**交易冻结份额*/
    private Double freezingShare2;
    /**基金赎回*/
    private String redemption;
}
