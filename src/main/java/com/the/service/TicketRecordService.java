package com.the.service;

import com.the.pojo.TicketRecord;

public interface TicketRecordService {
    int getPassengerFLow();
    int createReception(TicketRecord ticketRecord);
}
