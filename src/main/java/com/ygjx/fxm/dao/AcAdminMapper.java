package com.ygjx.fxm.dao;

import com.ygjx.wsh.entity.AcAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcAdminMapper {
    List<AcAdmin> getAllAcAdmin();
    int insertSelective();

    /**
     * 通过管理员姓名查找信息
     * @param adminAccount
     * @return
     */
    AcAdmin findByAdminAccount(String adminAccount);
}
