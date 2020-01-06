package com.ygjx.fxm.service.imple;

import com.ygjx.fxm.dao.AcBankNameMapper;
import com.ygjx.fxm.entity.AcBankName;
import com.ygjx.fxm.service.AcBankNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AcBankNameServiceImple implements AcBankNameService{
    @Autowired
    private AcBankNameMapper acBankNameMapper;

    @Override
    public List<AcBankName> getAllAcBankName() {
        List<AcBankName> allAcBankName = acBankNameMapper.getAllAcBankName();
        return allAcBankName;
    }
}
