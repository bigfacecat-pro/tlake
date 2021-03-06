package com.the.dao;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface EmployeeMapper {
    HashMap<String,String> getEmployeeByID(@Param("employeeID") String employeeID);
    List<HashMap<String,String>> getEmployeeByKeyword(@Param("keyword") String keyWord);
}
