package com.ygjx.wsh.dao;

import com.ygjx.wsh.entity.AcCounter;
import org.apache.ibatis.annotations.Mapper;

/**
 * 柜台表的持久层接口
 */
@Mapper
public interface AcCounterMapper {
    /**
     *插入一条数据
     * @param counter
     * @return
     */
    int insert(AcCounter counter);

    /**
     * 根据柜台编号查询数据
     *
     * @param counterId
     * @return
     */
     AcCounter selectByPrimaryKey(Integer counterId);

}