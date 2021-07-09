package com.the.controller;

import com.the.Util.JsonUtil;
import com.the.Util.TimeUtil;
import com.the.config.SpringWebSocketHandler;
import com.the.pojo.Reception;
import com.the.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

import java.util.HashMap;

@RestController
@RequestMapping("/reception")
public class ReceptionController {
    @Autowired
    ReceptionService receptionService;
    public SpringWebSocketHandler infoHandler() {
        return new SpringWebSocketHandler();
    }

    public void setReceptionService(ReceptionService receptionService) {
        this.receptionService = receptionService;
    }

    @RequestMapping("/flow")
    public String getPassgerFlow(){
        int flow= receptionService.getPassgerFLow();
        HashMap<String,String> res=new HashMap<>();
        res.put("flow",String.valueOf(flow));
        return JsonUtil.getJson(true,res);
    }
    @RequestMapping("create")
    public String createReception(String ticketID,String scenicID,String employeeID){
        Reception reception=new Reception(TimeUtil.getDate(),TimeUtil.getClock(),ticketID,employeeID,scenicID);
        int res= receptionService.createReception(reception);
        if(res==1){
            int flow= receptionService.getPassgerFLow();
            infoHandler().broadCast(new TextMessage(String.valueOf(flow)));
        }
        return JsonUtil.getJson(res==1);

    }
}
