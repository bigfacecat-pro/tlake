package com.the.dao;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import com.the.pojo.WorkRecord;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface RecordMapper {
    int addRecord(WorkRecord record);
    int modifyScenicID(@Param("date")String date,@Param("employeeID") String employeeID,@Param("scenicID")int scenicID);
    int employeeLogout(@Param("date")String date,@Param("employeeID") String employeeID,@Param("clock")String clock);
    int updateRecord();
    WorkRecord queryToday();
    List<HashMap<String,String>> queryPeriodByEmpID(@Param("start") String start,@Param("end") String end);
    List<HashMap<String,String>> queryNameByScenicID(@Param("date")String date, @Param("scenicID") int scenicID);
}

/*


 */