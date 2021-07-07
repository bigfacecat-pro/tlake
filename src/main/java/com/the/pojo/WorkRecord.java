package com.the.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class WorkRecord {
    private String timeDate;
    private String employeeID;
    private int scenicID;
    private String punchIn;
    private String punchOff;
    private int receptionCount;
    private int oneStarCount;
    private int twoStarCount;

    public WorkRecord(){

    }
    public WorkRecord(String timeDate,String employeeID, int scenicID, String punchIn) {
        this.timeDate = timeDate;
        this.employeeID=employeeID;
        this.scenicID = scenicID;
        this.punchIn = punchIn;
    }
    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }

    public int getScenicID() {
        return scenicID;
    }

    public void setScenicID(int scenicProjectID) {
        this.scenicID = scenicProjectID;
    }

    public String getPunchIn() {
        return punchIn;
    }

    public void setPunchIn(String punchIn) {
        this.punchIn = punchIn;
    }

    public String getPunchOff() {
        return punchOff;
    }

    public void setPunchOff(String punchOff) {
        this.punchOff = punchOff;
    }

    public int getReceptionCount() {
        return receptionCount;
    }

    public void setReceptionCount(int receptionCount) {
        this.receptionCount = receptionCount;
    }

    public int getOneStarCount() {
        return oneStarCount;
    }

    public void setOneStarCount(int oneStarCount) {
        this.oneStarCount = oneStarCount;
    }

    public int getTwoStarCount() {
        return twoStarCount;
    }

    public void setTwoStarCount(int twoStarCount) {
        this.twoStarCount = twoStarCount;
    }

    public int getThreeStarCount() {
        return threeStarCount;
    }

    public void setThreeStarCount(int threeStarCount) {
        this.threeStarCount = threeStarCount;
    }

    public int getFourStarCount() {
        return fourStarCount;
    }

    public void setFourStarCount(int fourStarCount) {
        this.fourStarCount = fourStarCount;
    }

    public int getFiveStarCount() {
        return fiveStarCount;
    }

    public void setFiveStarCount(int fiveStarCount) {
        this.fiveStarCount = fiveStarCount;
    }

    private int threeStarCount;
    private int fourStarCount;
    private int fiveStarCount;
}
