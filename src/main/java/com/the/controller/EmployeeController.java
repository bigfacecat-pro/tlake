package com.the.controller;

import com.the.Util.JsonUtil;
import com.the.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
        return JsonUtil.getJson(employee==null,employee);

    }
    @RequestMapping("/list")
    public String employeeList(String keyword){

        List<HashMap<String,String>> employeeList= employeeService.getEmployeeByKeyword(keyword);
        return JsonUtil.getJson(true,employeeList);

    }
}
