package com.the.pojo;

import javax.print.DocFlavor;

public class Reception {
    private String timeDate;
    private  String TimeClock;
    private  String ticketID;
    private  String employeeID;
    private  String scenicID;

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }

    public String getTimeClock() {
        return TimeClock;
    }
    public Reception(){

    }
    public Reception(String timeDate, String timeClock, String ticketID, String employeeID, String scenicID) {
        this.timeDate = timeDate;
        TimeClock = timeClock;
        this.ticketID = ticketID;
        this.employeeID = employeeID;
        this.scenicID = scenicID;
    }

    public void setTimeClock(String timeClock) {
        TimeClock = timeClock;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getScenicID() {
        return scenicID;
    }

    public void setScenicID(String scenicID) {
        this.scenicID = scenicID;
    }

    public int getRemark() {
        return remark;
    }

    public void setRemark(int remark) {
        this.remark = remark;
    }

    private  int remark;
}
