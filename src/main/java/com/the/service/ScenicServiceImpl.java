package com.the.service;

import com.the.dao.ScenicMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class ScenicServiceImpl implements ScenicService{

    @Autowired
    private ScenicMapper scenicMapper;

    public void setScenicMapper(ScenicMapper scenicMapper) {
        this.scenicMapper = scenicMapper;
    }


    public ScenicServiceImpl(ScenicMapper scenicMapper) {
        this.scenicMapper = scenicMapper;
    }

    @Override
    public List<HashMap<String, String>> getScenic() {
        return scenicMapper.getScenic();
    }
}
