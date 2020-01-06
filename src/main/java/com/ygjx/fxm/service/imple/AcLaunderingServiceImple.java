package com.ygjx.fxm.service.imple;

import com.ygjx.fxm.dao.AcLaunderingMapper;
import com.ygjx.fxm.entity.AcLaundering;
import com.ygjx.fxm.service.AcLaunderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AcLaunderingServiceImple implements AcLaunderingService {
    @Resource
    AcLaunderingMapper acLaunderingMapper;
    @Override
    public AcLaundering findAcLaunderingByClientAccount(String clientAccount) {
        return acLaunderingMapper.selectByClientAcCount(clientAccount);
    }
}
