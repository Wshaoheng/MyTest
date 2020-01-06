package com.ygjx.wsh.service;

import com.ygjx.wsh.entity.AcCounter;

/**
 *柜台表的业务层接口
 */
public interface IAcCounterService {
    /**
     * 插入数据
     * @param counter
     * @return
     */
     AcCounter create(AcCounter counter);

    /**
     * 根据id 查询数据信息
     * @param counterId
     * @return
     */
    AcCounter selectByPrimaryKey(Integer counterId);

}
