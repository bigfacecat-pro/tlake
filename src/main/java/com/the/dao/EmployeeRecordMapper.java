package com.the.dao;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import com.the.pojo.WorkRecord;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface EmployeeRecordMapper {
    /**
     * 员工打卡上班后，创建一条记录
     * @param record
     * @return
     */
    int addRecord(WorkRecord record);
    /**
     * 员工当天更换工作地点后，调用此方法更新地点
     * @param date 当天日期
     * @param employeeID 员工ID
     * @param scenicID 工作位置ID
     * @return
     */
    int updateScenicID(@Param("date")String date, @Param("employeeID") String employeeID, @Param("scenicID")int scenicID);

    /**
     * 员工扫码后，员工接待数+1
     * @param date 日期
     * @param scenicID 景点ID
     * @return
     */
    int updateReceptionCount(@Param("date")String date,  @Param("scenicID")int scenicID, @Param("ticketCount")int  ticketCount);
    /**
     * 员工打卡退出
     * @param date 日期
     * @param employeeID 员工ID
     * @param clock 时间
     * @return
     */
    int employeeLogout(@Param("date")String date,@Param("employeeID") String employeeID,@Param("clock")String clock);


    /**
     * 获取一段时间内，所有员工的工作记录
     * 对每个员工多天的记录进行累加
     * @param start 其实日期
     * @param end 截至日期
     * @return
     */
    List<HashMap<String,String>> queryAllEmployeeRecord(@Param("start") String start, @Param("end") String end);
    /**
     *  获取指定员工的所有工作记录
     * 对员工多天的记录分条显示而不是累加
     * @param employeeID 员工ID
     * @return
     */
    List<HashMap<String,String>> querySingleEmployeeRecord(@Param("employeeID") String employeeID);
    /**
     * 获取当日在指定景点ID 工作的员工名称、员工ID
     * @param date 日期
     * @param scenicID 景点ID
     * @return
     */
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