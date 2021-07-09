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
    List<HashMap<String,String>> queryPeriod(@Param("start") String start,@Param("end") String end);
    List<HashMap<String,String>> querySingleEmployee(@Param("employeeID") String employeeID);
    List<HashMap<String,String>> queryNameByScenicID(@Param("date")String date, @Param("scenicID") int scenicID);
}

/*
select e.name,w.employeeID,any_value(s.scenicName) as scenicName, sum(w.receptionCount) as receptionCount,sum(w.fiveStarCount) as fiveStarCount, sum(w.fourStarCount) as fourStarCount,
                sum(w.threeStarCount) as threeStarCount,sum(w.twoStarCount) as twoStarCount,sum(w.oneStarCount) as oneStarCount
        from workRecord as w
            join employee  as e on w.employeeID=e.employeeID
            join scenic as s on w.scenicID=s.scenicID
        where w.timeDate between 0 and 2024 group by w.employeeID;

 */
/*
 select w.timeDate, e.name,w.employeeID,s.scenicName , w.receptionCount,w.fiveStarCount, w.fourStarCount, w.threeStarCount,w.twoStarCount,w.oneStarCount
 from employee  as e  join workRecord as w on e.employeeID=w.employeeID  join scenic as s on w.scenicID=s.scenicID
 where w.timeDate between '0'  and '222' and w.employeeID='tldj001';

 */