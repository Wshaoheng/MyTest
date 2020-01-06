package com.ygjx.wyh.dao;

import com.ygjx.wsh.entity.AcBank;
import com.ygjx.wyh.dto.IsSaveInfoDto;
import com.ygjx.wyh.dto.PurchaseDto;
import com.ygjx.wyh.dto.RegisteredInfoDto;
import com.ygjx.wyh.entity.Fund;
import com.ygjx.wyh.entity.FundAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * create by: wyh
 * description: TODO
 * create time: 2019/10/25 15:39
 * * @Param: null
 *
 * @return 基金账户表的dao接口
 */

@Mapper
public interface FundAccountDao {

    /**查询全部*/
    public FundAccount listInfos();

    /**个人基金账户登记*/
    public int insertInfos(FundAccount fundAccount);

    /**修改个人基金账户*/
    public int updateInfos(FundAccount fundAccount);

    /**根据交易账号信息让用户添加信息然后对比，如果成功则登记成功*/
    /**根据委托方式和账户信息可以去点击客户信息*/
   // public int doCheck();
    /**基金帐号注册*/
    public int registeredFundCode(RegisteredInfoDto registeredInfo);

    /**查询全部*/
    public List<FundAccount> queryInfos();

    /**如果上面的信息存在 可以点击出查询的条件*/
    public List<IsSaveInfoDto> ifSave(IsSaveInfoDto isSaveInfo);

    /**查询基金名称和code*/
    public Fund selectFundName(Fund fundNameAndId);

    /**基金认购  如果成功返回1*/
    public int fundSubscription();

    /**基金认购信息核对*/
    public PurchaseDto checkPurchaseInfos(FundAccount fundAccount);

    /**新增申购信息*/
    public int addPurchaseInfo(PurchaseDto purchaseDto);

    /**根据基金帐号查询基金名称*/
    public List<String> selectFundNameByFundAccount(String fundAccount);

    FundAccount selectFundAccountInfoss(String clientAccount);

    /**银行信息*/
    AcBank selectBnakInfo(Integer id);
}
