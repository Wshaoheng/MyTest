package com.ygjx.wyh.sevice.impl;


import com.ygjx.utils.GetTime;
import com.ygjx.wsh.entity.AcCounter;
import com.ygjx.wyh.dao.FundAccountDao;
import com.ygjx.wyh.dao.FundRedemptionDao;
import com.ygjx.wyh.dto.AccountDto;
import com.ygjx.wyh.dto.RedemptionForm1;
import com.ygjx.wyh.dto.RedemptionForm2;
import com.ygjx.wyh.dto.RedemptionInfo2Dto;
import com.ygjx.wyh.entity.Counter;
import com.ygjx.wyh.entity.Fund;
import com.ygjx.wyh.entity.FundMoney;
import com.ygjx.wyh.entity.FundOk;
import com.ygjx.wyh.sevice.RedemptionService;
import com.ygjx.wyh.util.Result;
import com.ygjx.wyh.util.ResultCode;
import org.aspectj.weaver.ast.Var;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：wyh
 * @date ：Created in 2019/10/29 18:32
 * @description：基金赎回实现类
 * @modified By：
 * @version: 1.0
 */


@Service
@Transactional
public class RedemptionServiceImpl implements RedemptionService {

    @Resource
    private FundRedemptionDao fundRedemptionDao;//

    @Resource
    private FundAccountDao fundAccountDao;//

    Result result = new Result();//返回的类

    Counter counter = new Counter();//流水单的类

  public Result zhiding(FundMoney selectShare){
      Integer id = selectShare.getId();
      FundOk fundOk = fundRedemptionDao.selectOkInfo(id);
      result.setData(fundOk);
      return  result;
  }

    /**
     *
     *1.基金份额赎回
     * @param redemptionInfo2
     * @param ransom  赎回还是指定赎回
     * @return 赎回成功则返回1，失败返回0
     */
    @Override
    @Transactional
    public Result queryShareRedemption(RedemptionInfo2Dto redemptionInfo2,String ransom) {
        //赎回份额是在原先的的份额的基础上加上新增的份额，查询原先的份额
        FundMoney selectShare = fundRedemptionDao.selectShare(redemptionInfo2);

        //流水单新增
        Counter res = addBillInfo(counter);
        res.setClientAccount(redemptionInfo2.getFundInfoAccount());
        res.setFundAccount(redemptionInfo2.getClientAccount());
        //====================
        if (ransom.equals("指定赎回")){
            result = zhiding(selectShare);
        }
        //====================

        //得到申购金额
        Double obj1 = selectShare.getPurchaseAmount();
        //得到可用金额
        Double obj2 = selectShare.getAmountAvailable();

        //进行比较
        boolean equalValue = equal(obj1, obj2);
        if (equalValue == true){
            result.setResultCode(ResultCode.ERROR);
            result.setMessage("您的基金“"+redemptionInfo2.getFundName()+"”没有售出过，您可以进行其他基金的赎回哦！！！");
            res.setOperationType(res.getOperatingTime()+"，客户进行-基金赎回-，但是由于没有售出，所以赎回操作为0");
            fundRedemptionDao.inserBillInfo(res);
            return result;
        }else {
            //其实还应该判断 目前已经有的基金大于赎回基金，就应该报错---存在于数据库有问题
            //获取前端传过来的赎回份额和基金名称
            //赎回份额
            int share = redemptionInfo2.getAvailableShare();
            //基金名称
            String fundName = redemptionInfo2.getFundName();
            //根据基金名称获得基金的份额单价
            Fund fund = new Fund();
            fund.setFundName(fundName);
            Fund fundInfo = fundAccountDao.selectFundName(fund);
            //得到银行拥有的基金的份额单价
            //得到银行拥有的基金的份额
            Double sharePrice = fundInfo.getSharePrice();
            Integer bankFundShare = fundInfo.getFundShare();
            //得到转换之后的价格，然后去和申购金额去做对比
            //从前端得到赎回份额，加上已有的份额
            int availableShare = selectShare.getAvailableShare();
            int share2 = availableShare + share;
            //当前份额的单价*客户赎回后拥有的份额=赎回后的可用金额
            Double money =  sharePrice * share2;
            //申购金额 obj1  赎回后的资金和申购金额对比
            int i = money.compareTo(obj1);

            //计算可以赎回的最大份额
            int maxShare =  (int)Math.floor((obj1 - obj2)/sharePrice);
            //判断算出来的金额和申购金额的大小
            if (i > 0 ){
                result.setMessage("您不可以进行-基金赎回-，原因是：您现在所赎回的基金-"+fundName+"-份额太大，最大赎回份额为-"+maxShare+"-");
                res.setOperationType(res.getOperatingTime()+"，客户进行了-基金赎回-，但是由于份额太大，所以没有赎回，注：(原因是：您现在所赎回的基金-"+fundName+"-份额太大，最大赎回份额为-"+maxShare+"-)");
                fundRedemptionDao.inserBillInfo(res);
            }else if (i<0){
                //修改客户的基金表中的 可用金额 和 可用份额
                selectShare.setAmountAvailable(money);
                selectShare.setAvailableShare(share2);
                int fundMoney = fundRedemptionDao.updateRedemptionInfo(selectShare);
                bankFundShare = bankFundShare - share;
                //本基金的剩余基金
                fund.setFundShare(bankFundShare);
                fund.setFundName(fundName);
                int bankShare = fundRedemptionDao.updateBankShare(fund);
                if (bankShare == 1 && fundMoney == 1){
                    result.setResultCode(ResultCode.SUCCESS);
                    result.setMessage("您进行了本次-基金赎回-，赎回基金-"+fundName+"-份额:-"+share+"-份");
                    res.setOperationType(res.getOperatingTime()+"，客户进行了-基金赎回-,赎回基金-"+fundName+"-份额:-"+share+"-份");
                    fundRedemptionDao.inserBillInfo(res);
                }else {
                    result.setResultCode(ResultCode.ERROR);
                    result.setMessage("您本次赎回失败，详情查询http://www.baidu.com");
                    res.setOperationType(res.getOperatingTime()+"，客户进行了-基金赎回-，但是失败了");
                    fundRedemptionDao.inserBillInfo(res);
                }
            }else {
                //修改客户的基金表中的 可用金额 和 可用份额
                selectShare.setAmountAvailable(money);
                selectShare.setAvailableShare(share2);
                int fundMoney = fundRedemptionDao.updateRedemptionInfo(selectShare);
                bankFundShare = bankFundShare - share;
                //本基金的剩余基金份额
                fund.setFundShare(bankFundShare);
                int bankShare = fundRedemptionDao.updateBankShare(fund);
                if (bankShare == 1 && fundMoney == 1){
                    result.setResultCode(ResultCode.SUCCESS);
                    result.setMessage("您进行了本次-基金赎回-，赎回基金-"+fundName+"-份额-"+share+"-份,您赎回了您所有的基金，此基金不能再赎回");
                    res.setOperationType(res.getOperatingTime()+"，客户进行了-基金赎回-，赎回基金-"+fundName+"-份额-"+share+"-份,您赎回了您所有的基金，此基金不能再赎回");
                    fundRedemptionDao.inserBillInfo(res);
                }else {
                    result.setResultCode(ResultCode.ERROR);
                    result.setMessage("您本次赎回失败，详情查询http://www.baidu.com");
                    res.setOperationType(res.getOperatingTime()+"，客户进行了-基金赎回-，但是失败了");
                    fundRedemptionDao.inserBillInfo(res);
                }
            }
            return result;
        }

    }

    /**2.指定赎回的确认信息*/
    @Override
    public Result queryOkInfo(Integer id) {
        FundOk fundOk = fundRedemptionDao.selectOkInfo(id);
        if (fundOk != null){
            result.setData(fundOk);
            result.setMessage("查询成功");
            result.setResultCode(ResultCode.SUCCESS);
        }else {
            result.setMessage("查询失败");
            result.setResultCode(ResultCode.ERROR);
        }
        return result;
    }


    /**赎回的表格            建议之后使用设计模式*/
    @Override
    public Result queryRedemptionForm(String ransom, AccountDto accountDto) {
        List<String> list=new ArrayList<>();
        Counter res = addBillInfo(counter);
        fundRedemptionDao.selectAdminIdFromAcc(accountDto.getFundAccount());
        res.setClientAccount(accountDto.getClientAccount());
        res.setFundAccount(accountDto.getFundAccount());
        if (ransom.equals("赎回")){
            //展示第一张表
            List<RedemptionForm1> redemptionForm1s = fundRedemptionDao.selectForm1(accountDto.getFundAccount());
            for (int i = 0; i < redemptionForm1s.size(); i++) {
                String fundCode = redemptionForm1s.get(i).getFundCode();
                Integer shareBalance1 = redemptionForm1s.get(i).getShareBalance1();
                if (shareBalance1 == null){
                    list.add(fundCode);
                    result.setMessage("赎回的表格查询成功,但是基金代码为"+list+"的基金您没有进行过***");
                }else {
                    result.setMessage("赎回的表格查询全部成功");
                }
            }
            result.setData(redemptionForm1s);
            result.setResultCode(ResultCode.SUCCESS);
            res.setOperationType(res.getOperatingTime()+"，客户进行了基金赎回的表格查询");
            fundRedemptionDao.inserBillInfo(res);
        }else if(ransom.equals("指定赎回")){
            //展示第二张表
            List<RedemptionForm2> redemptionForm2s = fundRedemptionDao.selectForm2(accountDto.getFundAccount());
            for (int i = 0; i < redemptionForm2s.size(); i++) {
                String fundCode = redemptionForm2s.get(i).getFundCode();
                Integer shareBalance2 = redemptionForm2s.get(i).getShareBalance();
                if (shareBalance2 == null){
                    list.add(fundCode);
                    result.setMessage("赎回的表格查询成功,但是基金代码为"+list+"的基金您没有进行过***");
                }else {
                    result.setMessage("赎回的表格查询全部成功");
                }
            }
            result.setData(redemptionForm2s);
            result.setResultCode(ResultCode.SUCCESS);
            res.setOperationType(res.getOperatingTime()+"，客户进行了基金指定赎回的表格查询");
            fundRedemptionDao.inserBillInfo(res);
        }

        return result;
    }

    /**4.交易撤单，申购，赎回，转换的撤单，转托管的撤单  根据流水编号  此处是赎回*/
    @Transactional
    @Override
    public Result withdrawal(Integer counterId,AccountDto accountDto) {
        Counter counter = new Counter();
        Counter res = addBillInfo(counter);
        //机构有
        fundRedemptionDao.selectAdminIdFromAcc(accountDto.getFundAccount());
        res.setClientAccount(accountDto.getClientAccount());
        res.setFundAccount(accountDto.getFundAccount());
        //========================
        RedemptionInfo2Dto dto = new RedemptionInfo2Dto();
        //获取流水信息
        Counter counter2 = fundRedemptionDao.queryCounterByCode(counterId);
        //判断是否是空，是空就不进行操作了
        if ( counter2==null){
            result.setMessage("这个流水单号查不到信息，我们认为您的流水单号有问题哦，如有疑问还请移步http://www.baidu.com");
            result.setResultCode(ResultCode.ERROR);
            res.setStatus(1);
            res.setOperationType(res.getOperatingTime()+"，客户进行了流水单查询，但是失败了");
            fundRedemptionDao.inserBillInfo(res);
            return result;
        }else {
            //不是空，判断status是否是0
            Integer status = counter2.getStatus();
            if (status == 0){
                //截取字符串获得中间的值（就是用于判断的条件，比如是赎回，申购等，这些条件要求添加的流水信息是规范的在两个“-”中间）
                String operationType = counter2.getOperationType();
                //获取基金账号，但是基金帐号可能为空
                String fundAccount = counter2.getFundAccount();
                //获取交易账号，但是交易帐号可能为空
                String clientAccount = counter2.getClientAccount();
                String type[] = operationType.split("-");
                boolean contains1 = operationType.contains("基金赎回");
                if (contains1){
                    //如果是基金赎回，那就要将基金的步骤返回
                    //基金的操作
                    String tp = type[3];
                    //基金名称
                    String name = type[5];
                    //基金份额
                    int num = Integer.parseInt(type[7]);
                    //将基金份额拿到基金表去比较，如果剩余的基金大于num，就可以撤回，要不就提醒基金份额不足，不能撤回
                    dto.setFundName(name);
                    //查询之前的money的信息
                    dto.setFundInfoAccount(fundAccount);
                    FundMoney fundMoney = fundRedemptionDao.selectShare(dto);
                    //查看可用份额是否可以 进行赎回撤回的操作，即可用的份额要>日志中的num
                    Integer availableShare = fundMoney.getAvailableShare();

                    if (availableShare < num){
                        result.setMessage("-基金赎回-操作失败，原因是您的可用基金份额不足以去撤回这笔交易");
                        result.setResultCode(ResultCode.ERROR);
                        res.setStatus(1);
                        res.setOperationType(res.getOperatingTime()+"，客户进行了-基金赎回-的交易撤单，但是失败了，原因是用户的撤单份额太少");
                        fundRedemptionDao.inserBillInfo(res);
                    }else {
                        //修改基金表中的份额
                        Fund fundInfo = fundRedemptionDao.selectShareByName(name);
                        fundInfo.setFundShare(fundInfo.getFundShare()+num);
                        int bankShare = fundRedemptionDao.updateBankShare(fundInfo);
                        //还要修改ac_fund_money表中的信息
                        fundMoney.setAvailableShare(fundMoney.getAvailableShare()-num);
                        Integer share = fundMoney.getAvailableShare();
                        fundMoney.setAmountAvailable(share * fundInfo.getSharePrice());
                        int b = fundRedemptionDao.updateRedemptionInfo(fundMoney);
                        if (bankShare == 1 && b == 1){
                            result.setMessage("-基金赎回-进行了撤单，基金-"+name+"-增加-"+num+"-份");
                            result.setResultCode(ResultCode.SUCCESS);
                            res.setStatus(1);
                            res.setOperationType(res.getOperatingTime()+"，客户进行了-基金赎回-的交易撤单成功,-基金赎回-进行了撤单，基金-"+name+"-增加-"+num+"-份");
                            fundRedemptionDao.inserBillInfo(res);
                        }
                    }

                }
                boolean contains2 = operationType.contains("基金申购");
            }

        }
        return result;
    }

    /**资金存入*/


    /**double对比大小*/
    public boolean equal(double a, double b) {
        if ((a- b> -0.000001) && (a- b) < 0.000001){
            return true;
        } else{
            return false;
        }
    }

    /**新增流水信息*/
    public Counter addBillInfo(Counter counter){
        //柜台编号是自增的
        String currenTime = GetTime.getCurrenTime();
        //操作时间
        counter.setOperatingTime(currenTime);
        //流水单状态
        counter.setStatus(0);
        //还缺操作类型，管理员编号，交易账号，基金账号
        return counter;
    }
}
