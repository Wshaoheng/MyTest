package com.ygjx.wsh.service.impl;

import com.ygjx.wsh.dao.AcClientPersonalMapper;
import com.ygjx.wsh.dao.AcClientScoreMapper;
import com.ygjx.wsh.entity.AcClientPersonal;
import com.ygjx.wsh.entity.AcClientScore;
import com.ygjx.wsh.service.IAcClientPersonalService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by strive on 2019/11/15
 */
public class AcClientPersonalServiceImpl implements IAcClientPersonalService {
    @Autowired
    private AcClientPersonalMapper acClientPersonalMapper;
    @Autowired
    private AcClientScoreMapper acClientScoreMapper;

    @Override
    public List<AcClientPersonal> getByclientAccount(String acount) {
        List<Integer> selected = new ArrayList<>();
        List<AcClientPersonal> acClientPersonal= acClientPersonalMapper.getByclientAccount(acount);
            for(int i=0;i<acClientPersonal.size();i++){
                AcClientPersonal clientPersonal =acClientPersonal.get(i);

                List<AcClientScore> clientScores = acClientScoreMapper.getAcClientScoreByclientQuesitonNum(clientPersonal.getClientPersonalId());
                for(int j=0;j<clientScores.size();j++){

                    if(clientPersonal.getClientPersonalChecked().equals(clientScores.get(j).getClientScoreId())){

                        Integer score = clientScores.get(j).getClientScore();

                         selected.add(score);
                    }

                }
            }
        return acClientPersonal;
    }

    @Override
    public AcClientPersonal getByclientPersonalId(Integer clientPersonalId) {
        AcClientPersonal personal = acClientPersonalMapper.getByclientPersonalId(clientPersonalId);
        List<AcClientScore> clientScores = acClientScoreMapper.getAcClientScoreByclientQuesitonNum(clientPersonalId);
        for(int i=0;i<clientScores.size();i++){
          AcClientScore  clientscore =clientScores.get(i);

        }
        return null;
    }
}
