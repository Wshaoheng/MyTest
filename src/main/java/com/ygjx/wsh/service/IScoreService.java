package com.ygjx.wsh.service;

import com.ygjx.wsh.entity.Score;

/**
 * Created by strive on 2019/11/18
 */
public interface IScoreService {
    Score findByClientAccount( String clientAccount);

    Integer addScore(Score score);
}
