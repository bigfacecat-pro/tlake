package com.the.service;

import com.the.Util.TimeUtil;
import com.the.dao.EmployeeRecordMapper;
import com.the.pojo.WorkRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class EmployeeRecordServiceImpl implements EmployeeRecordService {
    @Autowired
    private EmployeeRecordMapper employeeRecordMapper;


    public void setEmployeeRecordMapper(EmployeeRecordMapper employeeRecordMapper) {
        this.employeeRecordMapper = employeeRecordMapper;
    }

    @Override
    public  List<HashMap<String,String>> queryPeriod(String start, String end) {
        return employeeRecordMapper.queryAllEmployeeRecord(start,end);
    }

    @Override
    public int employeeLogout(String employeeID) {
        employeeRecordMapper.employeeLogout(TimeUtil.getDate(),employeeID,TimeUtil.getClock());
        return 0;
    }

    @Override
    public int employeeLogin(WorkRecord record) {
        return employeeRecordMapper.addRecord(record);

    }

    @Override
    public List<HashMap<String,String>> queryNameByScenicID(int scenicID) {
        return employeeRecordMapper.queryNameByScenicID(TimeUtil.getDate(), scenicID);
    }

    @Override
    public List<HashMap<String, String>> querySingleEmployee(String employeeID) {
        return employeeRecordMapper.querySingleEmployeeRecord(employeeID);
    }
}
