package com.ygjx.wyh.sevice;

import com.ygjx.wyh.dto.AccountDto;
import com.ygjx.wyh.dto.RedemptionInfo2Dto;
import com.ygjx.wyh.util.Result;

/**
 * create by: wyh
 * description: TODO
 * create time: 2019/10/29 18:31
 * @Param: 基金赎回
 * @return
 */

public interface RedemptionService {

    /**1.基金份额赎回  赎回成功则返回1，失败返回0*/
    public Result queryShareRedemption(RedemptionInfo2Dto redemptionInfo2,String ransom);

    /**2.指定赎回 的两个确认信息*/
    public Result queryOkInfo(Integer id);

    /**3.赎回或者指定赎回展示的表格不一样   赎回和知道那个赎回的状态是根据前端给的条件获得的*/
    public Result queryRedemptionForm(String ransom , AccountDto accountDto);
    /**登录后展示客户信息+经办人信息（如果是机构）+银行信息+表格（基金代码，收费方式，当前份额余额，可用份额余额，冻结份额余额，基金赎回）*/

    /**4.交易撤单，申购，赎回，转换的撤单，转托管的撤单  根据流水编号*/
    public Result withdrawal(Integer counterId,AccountDto accountDto);

}
