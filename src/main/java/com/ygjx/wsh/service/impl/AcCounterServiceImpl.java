package com.ygjx.wsh.service.impl;

import com.ygjx.wsh.dao.AcCounterMapper;
import com.ygjx.wsh.entity.AcCounter;
import com.ygjx.wsh.service.IAcCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

/**
 * 柜台表的业务层
 */
@Service
public class AcCounterServiceImpl implements IAcCounterService {
    @Autowired
    private AcCounterMapper acCounterMapper;


    @Override
    public AcCounter create(AcCounter counter) {
        AcCounter acCounter =acCounterMapper.selectByPrimaryKey(counter.getCounterId());
        if(acCounter==null){
            Date date =new Date();
            long time = date.getTime();
            String optime =time +"";
            counter.setOperatingTime(optime);
            counter.setAdminId(counter.getAdminId());
            counter.setClientAccount(counter.getClientAccount());
            counter.setOperationType(counter.getOperationType());
            acCounterMapper.insert(counter);

        }
        return counter;

    }

    @Override
    public AcCounter selectByPrimaryKey(Integer counterId) {

        return acCounterMapper.selectByPrimaryKey(counterId);
    }
}
