package com.the.controller;

import com.alibaba.fastjson.JSONObject;
import com.the.Util.JsonUtil;
import com.the.pojo.Result;
import com.the.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    @Qualifier("employeeServiceImpl")
    EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/getname")
    public String getEmployeeName(String employeeID){

        HashMap<String,String> employee= employeeService.getEmployeeByID(employeeID);
        Assert.notNull(employee,"无效员工编号");
        Result<HashMap<String,String>> result=new Result<>("success","ok",employee);
        return JSONObject.toJSONString(result);

    }
    @RequestMapping("/list")
    public String employeeList(String keyword){

        List<HashMap<String,String>> employeeList= employeeService.getEmployeeByKeyword(keyword);
        Result< List<HashMap<String,String>>> result=new Result<>("success","ok",employeeList);
        return JSONObject.toJSONString(result);

    }
}
