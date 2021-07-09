package com.the.service;

import com.the.pojo.WorkRecord;

import java.util.HashMap;
import java.util.List;

public interface RecordService {
    int employeeLogin(WorkRecord record);
    int employeeLogout(String employeeID);


    List<HashMap<String,String>> queryPeriod(String start,  String end);
    List<HashMap<String,String>> queryNameByScenicID(int scenicID);
    List<HashMap<String,String>> querySingleEmployee(String employeeID);

}
