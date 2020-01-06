package com.ygjx.wyh.dao;

import com.ygjx.wsh.entity.AcCounter;
import com.ygjx.wyh.dto.*;
import com.ygjx.wyh.entity.Counter;
import com.ygjx.wyh.entity.Fund;
import com.ygjx.wyh.entity.FundMoney;
import com.ygjx.wyh.entity.FundOk;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：wyh
 * @date ：Created in 2019/10/30 9:10
 * @description：基金赎回
 * @modified By：
 * @version: 1.0
 */
@Mapper
public interface FundRedemptionDao {

    /**基金赎回中查询出 个人信息*/
    public RedemptionByAcDto selectFormByAc(String clientAccount);

    /**基金赎回中查询出 机构信息 包括经办人*/
    public RedemptionByAccDto selectFormByAcc(String accAccount);

    /**修改基金赎回的第二个菜单栏信息
     * 其实就是根据基金名称来修改基金的可用份额，但是可用份额换算出来的可用金额必须是小于申购金额的
     * 修改基金赎回的第二个菜单栏信息  就是修改赎回份额
     * */
    public int updateRedemptionInfo(FundMoney dto);

    /**修改基金表中的基金份额信息*/
    public int updateBankShare(Fund fund);

    /**查询未修改之前的基金的*/
    public FundMoney selectShare(RedemptionInfo2Dto dto);

    /**根据基金的名称查询基金的份额*/
    public Fund selectShareByName(String fundName);


    /**跟据fund——money来获取id，进而查询确认时间和确认编码*/
    public FundOk selectOkInfo(Integer fundOkId);

    /**赎回中的表格*/
    public List<RedemptionForm1> selectForm1(String fundAccount);

    /**指定赎回中的表格*/
    public List<RedemptionForm2> selectForm2(String fundAccount);

    /**添加流水单信息*/
    public int inserBillInfo(Counter counter);

    /**查询流水单信息*/
    public List<Counter> selectBillInfo();

    /**根据交易账号或者基金账号获得 客户所有的基金id*/
    public List<Integer> selectRedemptionAllId(AccountDto accountDto);

    /**机构根据基金账号得到管理员id*/
    public Integer selectAdminIdFromAcc(String fundAccount);

    /**交易撤单1---根据流水编号 查询流水信息*/
    public Counter queryCounterByCode(Integer counterId);

    /**交易撤单2 基金帐号基金密码 查询基金撤回的回显信息*/
    public TransactionWithdrawalDto cd1(IsSaveInfoDto isSaveInfoDto);
    public TransactionWithdrawalDto cd2(String fundAccount);

    /**存入资金*/
    public int fundSave();
}
