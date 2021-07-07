package com.the.dao;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

public interface EmployeeMapper {
    HashMap<String,String> getEmployeeByID(@Param("employeeID") String employeeID);
}
