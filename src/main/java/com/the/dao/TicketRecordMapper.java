package com.the.dao;

import com.the.pojo.TicketRecord;
import org.apache.ibatis.annotations.Param;

public interface TicketRecordMapper {
    int getPassengerFlow(@Param("date") String date);
    int createReception(TicketRecord ticketRecord);
    int isHaveSameRecord(TicketRecord ticketRecord);
}
/*
 select count(ticketID)
        from reception
        where timeDate='2021-07-08'
        group by ticketID;
 */