package com.the.controller;

import com.alibaba.fastjson.JSONObject;
import com.the.Util.JsonUtil;
import com.the.Util.TimeUtil;
import com.the.pojo.Result;
import com.the.pojo.WorkRecord;
import com.the.service.EmployeeService;
import com.the.service.EmployeeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/record")
public class EmployeeRecordController {

    @Autowired
    @Qualifier("employeeRecordServiceImpl")
    EmployeeRecordService employeeRecordService;

    @Autowired
    @Qualifier("employeeServiceImpl")
    EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public void setEmployeeRecordService(EmployeeRecordService recordService) {
        this.employeeRecordService = recordService;
    }

    @RequestMapping("/login")
    public String employeeLogin(String employeeID,int scenicID){
        HashMap<String,String> employee= employeeService.getEmployeeByID(employeeID);
        Assert.notNull(employee,"无效员工ID");
        WorkRecord record=new WorkRecord(TimeUtil.getDate(),employeeID,scenicID,TimeUtil.getClock());
        int res= employeeRecordService.employeeLogin(record);
        Assert.isTrue(res!=0,"请重试");
        Result<HashMap<String,String>> result=new Result<>("success","登录成功^_^",employee);
        return JSONObject.toJSONString(result);
    }
    @RequestMapping("/logout")
    public String employeeLogout(String employeeID){
        int res=employeeRecordService.employeeLogout(employeeID);
        Assert.isTrue(res>0,"退出失败");
        Result<Integer> result=new Result<>("success","登录成功^_^",res);
        return JSONObject.toJSONString(result);

    }

    @RequestMapping("/multiple")
    public String getDailyData(String start,String end){
        List<HashMap<String,String>> multiple=employeeRecordService.queryPeriod(start,end);
        Result<List<HashMap<String,String>>> result=new Result<>("success","登录成功^_^",multiple);
        return JSONObject.toJSONString(result);
    }
    @RequestMapping("/single")
    public String getSingleData(String employeeID){
        List<HashMap<String,String>> single=employeeRecordService.querySingleEmployee(employeeID);
        Result<List<HashMap<String,String>>> result=new Result<>("success","登录成功^_^",single);
        return JSONObject.toJSONString(result);
    }
}
