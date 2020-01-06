package com.ygjx.fxm.service.imple;

import com.ygjx.fxm.dao.AcAgentMapper;
import com.ygjx.fxm.dao.AcClientMapper;
import com.ygjx.fxm.dao.AcLaunderingMapper;
import com.ygjx.fxm.entity.AcAgent;
import com.ygjx.fxm.entity.AcClient;
import com.ygjx.fxm.entity.AcLaundering;
import com.ygjx.fxm.service.AcClientService;
import com.ygjx.wsh.entity.AcAdmin;
import com.ygjx.wyh.entity.Counter;
import com.ygjx.wyh.dao.FundRedemptionDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AcClientServiceImple implements AcClientService {
    @Resource
    AcClientMapper acClientMapper;
    @Resource
    AcAgentMapper acAgentMapper;
    @Resource
    FundRedemptionDao fundRedemptionDao;
    @Resource
    AcLaunderingMapper acLaunderingMapper;
    @Transactional
    @Override
    public int addAcClient(AcClient acClient, AcAdmin acAdmin, AcLaundering acLaundering) {
        acClient.setClientAccount(System.currentTimeMillis() + "");
        acLaundering.setLaundAccount(acClient.getClientAccount());
        int i = acClientMapper.insertSelective(acClient);
        acLaunderingMapper.insertSelective(acLaundering);
        Counter acCount = new Counter();
        acCount.setClientAccount(acClient.getClientAccount());
        acCount.setAdminId(acAdmin.getAdminId());
        acCount.setStatus(0);
        //得到long类型当前时间
        long l = System.currentTimeMillis();
        //new日期对
        Date date = new Date(l);
        //转换提日期输出格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        String ss = format+",客户在柜台办理了交易账户开户";
        acCount.setOperationType(ss);
        acCount.setOperatingTime(format);
        if (i > 0) {
            fundRedemptionDao.inserBillInfo(acCount);
            return 1;
        }
        return 0;
    }

    @Transactional
    @Override
    public int addAcClientAcAgent(AcClient acClient, AcAgent acAgent,AcAdmin acAdmin , AcLaundering acLaundering ) {
        acClient.setClientAccount(System.currentTimeMillis() + "");
        acLaundering.setLaundAccount(acClient.getClientAccount());
        acAgent.setAgentClient(acClient.getClientAccount());
        int i = acAgentMapper.insertSelective(acAgent);
        System.err.println(acAgent.getAgentId());
        acClient.setAgentId(acAgent.getAgentId());
        acLaunderingMapper.insertSelective(acLaundering);
        //设置流水表需要的数据
        Counter acCount = new Counter();
        acCount.setClientAccount(acClient.getClientAccount());
        acCount.setAdminId(acAdmin.getAdminId());
        acCount.setStatus(0);
        //得到long类型当前时间
        long l = System.currentTimeMillis();
        //new日期对
        Date date = new Date(l);
        //转换提日期输出格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        String ss = format+",客户通过代办人在柜台办理了交易账户开户";
        acCount.setOperationType(ss);
        acCount.setOperatingTime(format);
        fundRedemptionDao.inserBillInfo(acCount);
        int i1 = acClientMapper.insertSelective(acClient);
        if (i > 0 && i1 > 0) {
            return i;
        }
        return 0;
    }

    @Override
    public AcClient findAcClient(AcClient acClient) {
        AcClient client = acClientMapper.getAcClientByAccount(acClient.getClientAccount());
        return client;
    }
    @Transactional
    @Override
    public int updateAcClient(AcClient acClient, AcLaundering acLaundering) {
        int i = acClientMapper.updateByPrimaryKeySelective(acClient);
            acLaundering.setLaundAccount(acClient.getClientAccount());
            acLaunderingMapper.updateByPrimaryKeyAccount(acLaundering);
        return i;
    }

    @Override
    public int updateAcClient(AcClient acClient) {
        return acClientMapper.updateByPrimaryKeySelective(acClient);
    }
}
