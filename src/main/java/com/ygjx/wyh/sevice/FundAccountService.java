package com.ygjx.wyh.sevice;

import com.ygjx.wyh.dto.IsSaveInfoDto;
import com.ygjx.wyh.dto.PurchaseDto;
import com.ygjx.wyh.dto.RegisteredInfoDto;
import com.ygjx.wyh.entity.Fund;
import com.ygjx.wyh.entity.FundAccount;
import com.ygjx.wyh.util.Result;

import java.lang.reflect.InvocationTargetException;


/**
 * create by: wyh
 * description: TODO
 * create time: 2019/10/25 16:26
 * * @Param: null
 *
 * @return service
 */

public interface FundAccountService {

    /**注册*/
    public int enrollInfo(RegisteredInfoDto registeredInfo);

    /**登记*/
    public int saveInfo(FundAccount fundAccount);

    /**修改*/
    public int updateInfo(FundAccount fundAccount);

    /**根据委托方式，和基金/交易账号密码进行查询*/
    public Result toCheck(IsSaveInfoDto isSaveInfo) throws Exception;


    /**获取基金名称*/
    public Result getFundName(Fund fundNameAndCode);

    /**核对基金申购的信息*/
    public Result checkPurchaseInfo(FundAccount fundAccount);

    /**新增申购信息*/
    public Result insertPurchaseInfo(PurchaseDto purchaseDto);

    /**资金存入*/
    public Result depositOfFund();

    FundAccount selectFundAccountInfos( String fundAccount);

    /**撤回信息回显*/

}
