package com.the.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.the.Util.JsonUtil;
import com.the.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/scenic")
public class ScenicController {
    @Autowired
    @Qualifier("scenicServiceImpl")
    private ScenicService scenicService;

    public void setScenicService(ScenicService scenicService) {
        this.scenicService = scenicService;
    }

    @RequestMapping("/getscenic")
    public String getScenic(){
        List<HashMap<String,String>> scenicList= scenicService.getScenic();
        String jsonData= JsonUtil.getJson(true,scenicList);
        return jsonData;
    }
}
