package com.ygjx.wsh.service.impl;

import com.ygjx.wsh.dao.ScoreMapper;
import com.ygjx.wsh.entity.Score;
import com.ygjx.wsh.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by strive on 2019/11/18
 */
@Service
public class ScoreServiceImpl implements IScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public Score findByClientAccount(String clientAccount) {

        return null;
    }

    @Override
    public Integer addScore(Score score) {
        int i= scoreMapper.insert(score);
        return i;
    }
}
