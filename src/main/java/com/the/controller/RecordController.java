package com.the.controller;

import com.the.Util.JsonUtil;
import com.the.Util.TimeUtil;
import com.the.dao.EmployeeMapper;
import com.the.pojo.WorkRecord;
import com.the.service.EmployeeService;
import com.the.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    @Qualifier("recordServiceImpl")
    RecordService recordService;


    public void setRecordService(RecordService recordService) {
        this.recordService = recordService;
    }

    @RequestMapping("/login")
    public String employeeLogin(String employeeID,int scenicID){
        WorkRecord record=new WorkRecord(TimeUtil.getDate(),employeeID,scenicID,TimeUtil.getClock());
        int result= recordService.employeeLogin(record);
        return JsonUtil.getJson(result==0);


    }
}
