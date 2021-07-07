package com.the.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ticketReception {
    private String timeDate;
    private long timeClock;
    private String ticketID;
    private int scenicProjectID;
    private String employeeID;
    private int remark;

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }

    public long getTimeClock() {
        return timeClock;
    }

    public void setTimeClock(long timeClock) {
        this.timeClock = timeClock;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public int getScenicProjectID() {
        return scenicProjectID;
    }

    public void setScenicProjectID(int scenicProjectID) {
        this.scenicProjectID = scenicProjectID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public int getRemark() {
        return remark;
    }

    public void setRemark(int remark) {
        this.remark = remark;
    }
}
