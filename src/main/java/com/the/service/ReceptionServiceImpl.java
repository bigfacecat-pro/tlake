package com.the.service;

import com.the.Util.TimeUtil;
import com.the.dao.ReceptionMapper;
import com.the.pojo.Reception;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public class ReceptionServiceImpl implements ReceptionService {
    @Autowired
    ReceptionMapper receptionMapper;

    public void setReceptionMapper(ReceptionMapper receptionMapper) {
        this.receptionMapper = receptionMapper;
    }

    @Override
    public int getPassgerFLow() {
        return receptionMapper.getPassgerFlow(TimeUtil.getDate());
    }

    @Override
    public int createReception(Reception reception) {
        return receptionMapper.createReception(reception);
    }
}
