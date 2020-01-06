package com.ygjx.wsh.dao;

import com.ygjx.wsh.entity.AcClientScore;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AcClientScoreMapper {
    int deleteByPrimaryKey(Integer clientScoreId);

    int insert(AcClientScore record);

    int insertSelective(AcClientScore record);

    AcClientScore selectByPrimaryKey(Integer clientScoreId);

    int updateByPrimaryKeySelective(AcClientScore record);

    int updateByPrimaryKey(AcClientScore record);

    /**
     * 根据题号查询这道题的所有选项分数
     * @param clientQuesitonNum
     * @return
     */
    List<AcClientScore> getAcClientScoreByclientQuesitonNum(Integer clientQuesitonNum);
}