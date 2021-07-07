package com.the.service;

import com.the.Util.TimeUtil;
import com.the.dao.RecordMapper;
import com.the.pojo.WorkRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class RecordServiceImpl implements RecordService{
    @Autowired
    private RecordMapper recordMapper;


    public void setRecordMapper(RecordMapper recordMapper) {
        this.recordMapper = recordMapper;
    }

    @Override
    public  List<HashMap<String,String>> queryPeriodByEmpID(String start, String end) {
        return recordMapper.queryPeriodByEmpID(start,end);
    }
    @Override
    public List<HashMap<String,String>> queryPeriodByEmpID() {
        String today= TimeUtil.getDate();
        return recordMapper.queryPeriodByEmpID(today,today);
    }


    @Override
    public int employeeLogout(String employeeID) {
        recordMapper.employeeLogout(TimeUtil.getDate(),employeeID,TimeUtil.getClock());
        return 0;
    }

    @Override
    public int employeeLogin(WorkRecord record) {
        recordMapper.addRecord(record);
        return 0;
    }

    @Override
    public List<HashMap<String,String>> queryNameByScenicID(int scenicID) {
        return recordMapper.queryNameByScenicID(TimeUtil.getDate(), scenicID);
    }
}
