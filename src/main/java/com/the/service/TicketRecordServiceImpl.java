package com.the.service;

import com.the.Util.TimeUtil;
import com.the.config.SpringWebSocketHandler;
import com.the.dao.TicketRecordMapper;
import com.the.dao.EmployeeRecordMapper;
import com.the.pojo.TicketRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.socket.TextMessage;

public class TicketRecordServiceImpl implements TicketRecordService {
    @Autowired
    TicketRecordMapper ticketRecordMapper;
    @Autowired
    EmployeeRecordMapper employeeRecordMapper;

    public SpringWebSocketHandler infoHandler() {
        return new SpringWebSocketHandler();
    }
    public void setEmployeeRecordMapper(EmployeeRecordMapper employeeRecordMapper) {
        this.employeeRecordMapper = employeeRecordMapper;
    }
    public void setTicketRecordMapper(TicketRecordMapper ticketRecordMapper) {
        this.ticketRecordMapper = ticketRecordMapper;
    }

    @Override
    public int getPassengerFLow() {
        return ticketRecordMapper.getPassengerFlow(TimeUtil.getDate());
    }

    /**
     * 员工扫码事务：
     *  1.创建片单游玩记录
     *  2.员工接待数+1
     *  3.WebSocket更新后台管理客流量展示主页
     * @param ticketRecord 片单记录
     * @return 事务执行成功返回1，事务失败回滚返回0,存在相同记录返回-1
     */
    @Override
    @Transactional
    public int createReception(TicketRecord ticketRecord) {
        try{
            if(ticketRecordMapper.isHaveSameRecord(ticketRecord)>0)
                return -1;
            int ticketCount= ticketRecordMapper.createReception(ticketRecord);
            employeeRecordMapper.updateReceptionCount(TimeUtil.getDate(), ticketRecord.getScenicID(),ticketCount);
            int flow= getPassengerFLow();
            infoHandler().broadCast(new TextMessage(String.valueOf(flow)));
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
        return 1;
    }
}
