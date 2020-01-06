package com.ygjx.wyh.sevice.impl;

import com.ygjx.wyh.dao.FundAccountDao;
import com.ygjx.wyh.dao.FundRedemptionDao;
import com.ygjx.wyh.dto.IsSaveInfoDto;
import com.ygjx.wyh.dto.PurchaseDto;
import com.ygjx.wyh.dto.RegisteredInfoDto;
import com.ygjx.wyh.dto.TransactionWithdrawalDto;
import com.ygjx.wyh.entity.Fund;
import com.ygjx.wyh.entity.FundAccount;
import com.ygjx.wyh.sevice.FundAccountService;
import com.ygjx.wyh.util.Result;
import com.ygjx.wyh.util.ResultCode;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2019/10/25 16:27
 * @description：基金账户实现类
 * @modified By：
 * @version: 1.0$
 */
@Service
@Transactional
public class FundAccountServiceImpl implements FundAccountService {

    @Resource
    private FundAccountDao fundAccountDao;

    /**
     * 注册
     */
    @Override
    public int enrollInfo(RegisteredInfoDto registeredInfo) {
        /**
         * 根据 客户姓名，证件类型，证件号码,基金密码   注册号码
         * */
        //通过获取当前时间的毫秒值来生成一个基金帐号
        Date date = new Date();
        long time = date.getTime();
        String a = time + "";
        String right = "";
        right = a.substring(a.length() - 8, a.length());
        String left = registeredInfo.getCardNum();
        if (left.length() >= 4) {
            left = left.substring(left.length() - 4, left.length());
            String userName = left + right;
            registeredInfo.setUserName(userName);
        } else {
            right = a.substring(a.length() - 12, a.length());
            registeredInfo.setUserName(right);
        }
        int i = fundAccountDao.registeredFundCode(registeredInfo);
        return i;
    }

    /**
     * 登记
     */
    @Override
    public int saveInfo(FundAccount fundAccount) {
        int i = fundAccountDao.insertInfos(fundAccount);
        return i;
    }

    /**
     * 修改
     */
    @Override
    public int updateInfo(FundAccount fundAccount) {
        int i = fundAccountDao.updateInfos(fundAccount);
        return i;
    }

    @Resource
    private FundRedemptionDao fundRedemptionDao;
    /**
     * 根据条件看是否可以进行查询
     */
    @Override
    public Result toCheck(IsSaveInfoDto isSaveInfo) throws Exception {
        Result result = new Result();
        List<IsSaveInfoDto> num = fundAccountDao.ifSave(isSaveInfo);
        int i = num.size();
        if ( i == 0) {
            result.setResultCode(ResultCode.ERROR);
            result.setMessage("查询错误，请联系 http://www.baidu.com");
        } else {
            result.setResultCode(ResultCode.SUCCESS);
            result.setMessage("查询成功");

            TransactionWithdrawalDto cdOne = fundRedemptionDao.cd1(isSaveInfo);
            TransactionWithdrawalDto cdTwo = fundRedemptionDao.cd2(isSaveInfo.getFundAccount());
            if (cdTwo == null){
                cdOne.setType("个人");
            }else {
                cdOne.setType("机构");
                cdOne.setManager(cdTwo.getManager());
                cdOne.setManagerCodeType(cdTwo.getManagerCodeType());
                cdOne.setManagerCodeNum(cdTwo.getManagerCodeNum());
            }
            result.setData(cdOne);
        }
        return result;
    }

    /**
     * 获取基金名称
     */
    @Override
    public Result getFundName(Fund fundNameAndCode) {
        Result result = new Result();
        Fund fund = fundAccountDao.selectFundName(fundNameAndCode);
        if (fund != null) {
            result.setMessage("成功失败");
            result.setResultCode(ResultCode.ERROR);
        } else {
            result.setData(fund);
            result.setMessage("成功查询");
            result.setResultCode(ResultCode.SUCCESS);
        }
        return result;
    }

    /**
     * 核对基金申购的信息
     */
    @Override
    public Result checkPurchaseInfo(FundAccount fundAccount) {
        Result result = new Result();
        //获取从登录那里得到的信息
        //用purchaseDto和得到的信息做比较,如果成功，返回1，失败返回0
        PurchaseDto purchaseDto = fundAccountDao.checkPurchaseInfos(fundAccount);
        return result;
    }

    /**
     * 新增申购信息  同时查出风险等级
     */
    @Override
    public Result insertPurchaseInfo(PurchaseDto purchaseDto) {
        Result result = new Result();
        //获取基金名称
        String fundName = purchaseDto.getFundName();
        String fundAccount = purchaseDto.getFundAccount();
        List<String> strings = fundAccountDao.selectFundNameByFundAccount(fundAccount);
        for (int i = 0; i < strings.size(); i++) {
            String s = strings.get(i);
            if (fundName.equals(s)) {
                result.setMessage("添加失败,原因是您的“" + fundName + "”这款基金是已经购买的");
                result.setResultCode(ResultCode.ERROR);
            }else {
                result.setResultCode(ResultCode.SUCCESS);
            }
        }
        if (result.getResultCode().equals(ResultCode.ERROR)){
            result.setMessage("添加失败,原因是您的“" + fundName + "”这款基金是已经购买的");
            result.setResultCode(ResultCode.ERROR);
        }else if(result.getResultCode().equals(ResultCode.SUCCESS)){
            //添加基金信息
            int res = fundAccountDao.addPurchaseInfo(purchaseDto);
            if (res == 0) {
                result.setMessage("添加失败");
                result.setResultCode(ResultCode.ERROR);
            } else {

                //对象中根据基金名称获取风险等级
                Fund fundNameAndCode = new Fund();
                fundNameAndCode.setFundName(fundName);
                //得到基金风险
                Fund fundRisk = fundAccountDao.selectFundName(fundNameAndCode);
                String risk = fundRisk.getFundRisk();
                result.setMessage("添加成功,请您注意当前您的基金“" + fundName + "”风险为" + risk);
                result.setData(res);
                result.setResultCode(ResultCode.SUCCESS);

            }
        }
        return result;
    }

    /**资金存入*/
    @Override
    public Result depositOfFund() {

        return null;
    }

    @Override
    public FundAccount selectFundAccountInfos(String fundAccount) {
        return fundAccountDao.selectFundAccountInfoss(fundAccount);

    }


}
