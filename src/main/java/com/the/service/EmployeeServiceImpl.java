package com.the.service;

import com.the.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeMapper employeeMapper;

    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public HashMap<String, String> getEmployeeByID(String employeeID) {
        return employeeMapper.getEmployeeByID(employeeID);
    }
}
