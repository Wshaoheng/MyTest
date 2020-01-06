package com.ygjx.wyh.sevice.impl;

import com.ygjx.wyh.dao.OtherDao;
import com.ygjx.wyh.entity.FundAccount;
import com.ygjx.wyh.sevice.OtherService;
import com.ygjx.wyh.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：wyh
 * @date ：Created in 2019/11/4 10:04
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class OtherServiceImpl implements OtherService {


    @Resource
    private OtherDao otherDao;


    /**
     * 前后端分离
     * Result  结果集   jdbc   ResultSet  mybatis ResuleType/ResultMap
     * Result  中模仿前端数据请求中返回的状态码
     * Result  操作结果对象
     * message  信息
     * code   状态码
     */
    Result result = new Result();
    /**登录*/
    @Override
    public List<FundAccount> login() {
        List<FundAccount> login = otherDao.login();
        return login;
    }


}
