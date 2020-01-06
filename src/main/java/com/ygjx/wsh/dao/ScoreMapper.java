package com.ygjx.wsh.dao;

import com.ygjx.wsh.entity.Score;

public interface ScoreMapper {
    int deleteByPrimaryKey(String clientAccount);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(String clientAccount);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
}