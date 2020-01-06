package com.ygjx.fxm.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class AcCity  implements Serializable {
    /**
     * 市id
     */
    private Integer cityId;
    /**
     * 市名
     */
    private String cityName;
    /**
     * 省编码
     */
    private String cityProvincecode;

}