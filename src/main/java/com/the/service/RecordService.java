package com.the.service;

import com.the.pojo.WorkRecord;

import java.util.HashMap;
import java.util.List;

public interface RecordService {
    int employeeLogin(WorkRecord record);
    int employeeLogout(String employeeID);


    List<HashMap<String,String>> queryPeriodByEmpID(String start,  String end);
    List<HashMap<String,String>>  queryPeriodByEmpID();
    List<HashMap<String,String>> queryNameByScenicID(int scenicID);

}
