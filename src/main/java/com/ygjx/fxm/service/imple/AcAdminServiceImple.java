package com.ygjx.fxm.service.imple;

import com.ygjx.fxm.dao.AcAdminMapper;
import com.ygjx.fxm.service.AcAdminService;
import com.ygjx.wsh.entity.AcAdmin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AcAdminServiceImple implements AcAdminService{
    @Resource
    AcAdminMapper acAdminMapper;

    @Override
    public List<AcAdmin> findAllAcAdmin() {
        List<AcAdmin> allAcAdmin = acAdminMapper.getAllAcAdmin();
        return allAcAdmin;
    }
}
