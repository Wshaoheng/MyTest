package com.ygjx.wyq.entity;

import java.io.Serializable;

public class FundType implements Serializable{
    //类别id
    private Integer typeId;
    //列表名称
    private String typeName;

    public FundType() {

    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public FundType(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }
}