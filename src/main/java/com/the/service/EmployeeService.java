package com.the.service;

import java.util.HashMap;
import java.util.List;

public interface EmployeeService {
    HashMap<String,String> getEmployeeByID(String employeeID);
    List<HashMap<String,String>> getEmployeeByKeyword(String keyword);
}
