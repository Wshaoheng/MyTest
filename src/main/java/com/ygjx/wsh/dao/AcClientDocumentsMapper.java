package com.ygjx.wsh.dao;

import com.ygjx.wsh.entity.AcClientDocuments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AcClientDocumentsMapper {
    /**
     * 获得所有身份证件类型
     * @return
     */
    List<AcClientDocuments> getAll();
}