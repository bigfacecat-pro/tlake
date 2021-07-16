package com.the.controller;

import com.alibaba.fastjson.JSONObject;
import com.the.Util.JsonUtil;
import com.the.Util.TimeUtil;
import com.the.config.SpringWebSocketHandler;
import com.the.pojo.Result;
import com.the.pojo.TicketRecord;
import com.the.service.TicketRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ticketrecord")
public class TicketRecordController {
    @Autowired
    @Qualifier("ticketRecordServiceImpl")
    TicketRecordService ticketRecordService;


    public void seTicketRecordService(TicketRecordService ticketRecordService) {
        this.ticketRecordService = ticketRecordService;
    }

    @RequestMapping("/flow")
    public String getPassengerFlow(){
        int flow= ticketRecordService.getPassengerFLow();
        Assert.notNull(flow,"database query error");
        HashMap<String,Integer> map= new HashMap<>();
        map.put("flow",flow);
        Result<HashMap<String,Integer>> result=new Result<>("success","ok",map);
        return JSONObject.toJSONString(result);
    }
    @RequestMapping("create")
    public String createReception(String ticketID,int scenicID,String employeeID){
        TicketRecord ticketRecord =new TicketRecord(TimeUtil.getDate(),TimeUtil.getClock(),ticketID,employeeID,scenicID);
        int res= ticketRecordService.createReception(ticketRecord);
        Assert.isTrue(res>0,"扫码失败");
        Result<String> result=new Result<>("success","ok","nothing");
        return JSONObject.toJSONString(result);

    }
}
