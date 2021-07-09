package com.the.dao;

import com.the.pojo.Reception;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

public interface ReceptionMapper {
    int getPassgerFlow(@Param("date") String date);
    int createReception(Reception reception);
}
/*
 select count(ticketID)
        from reception
        where timeDate='2021-07-08'
        group by ticketID;
 */