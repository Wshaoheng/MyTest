package com.ygjx.fxm.service;

import com.ygjx.wsh.entity.AcAdmin;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AcAdminService {
    public List<AcAdmin> findAllAcAdmin();
}
