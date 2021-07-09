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
import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    @Qualifier("recordServiceImpl")
    RecordService recordService;

    @Autowired
    @Qualifier("employeeServiceImpl")
    EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public void setRecordService(RecordService recordService) {
        this.recordService = recordService;
    }

    @RequestMapping("/login")
    public String employeeLogin(String employeeID,int scenicID){
        HashMap<String,String> employee= employeeService.getEmployeeByID(employeeID);
        if(employee==null)
            return JsonUtil.getJson(false,"无效员工ID！");
        WorkRecord record=new WorkRecord(TimeUtil.getDate(),employeeID,scenicID,TimeUtil.getClock());
        int result= recordService.employeeLogin(record);
        if(result==0){
            return JsonUtil.getJson(true,"登录成功^_^",employee);
        }
        return JsonUtil.getJson(false,"请重试！");
    }
    @RequestMapping("/logout")
    public String employeeLogout(String employeeID){
        int result=recordService.employeeLogout(employeeID);
        return JsonUtil.getJson(result==0,result==0?"已退出^_^":"请重试！");

    }

    @RequestMapping("/multiple")
    public String getDailyData(String start,String end){
        List<HashMap<String,String>> result=recordService.queryPeriod(start,end);
        return JsonUtil.getJson(true,result);
    }
    @RequestMapping("/single")
    public String getSingleData(String employeeID){
        List<HashMap<String,String>> result=recordService.querySingleEmployee(employeeID);
        return JsonUtil.getJson(true,result);
    }
}
