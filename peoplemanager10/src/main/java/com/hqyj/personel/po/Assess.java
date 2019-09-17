package com.hqyj.personel.po;

import java.util.Date;

public class Assess {
    private Integer assessId;

    private String assessName;

    private String assessCatergery;

    private Date assessBegintime;

    private Integer assessNum;

    private String assessDepartment;

    private Integer assessTime;

    public Integer getAssessId() {
        return assessId;
    }

    public void setAssessId(Integer assessId) {
        this.assessId = assessId;
    }

    public String getAssessName() {
        return assessName;
    }

    public void setAssessName(String assessName) {
        this.assessName = assessName == null ? null : assessName.trim();
    }

    public String getAssessCatergery() {
        return assessCatergery;
    }

    public void setAssessCatergery(String assessCatergery) {
        this.assessCatergery = assessCatergery == null ? null : assessCatergery.trim();
    }

    public Date getAssessBegintime() {
        return assessBegintime;
    }

    public void setAssessBegintime(Date assessBegintime) {
        this.assessBegintime = assessBegintime;
    }

    public Integer getAssessNum() {
        return assessNum;
    }

    public void setAssessNum(Integer assessNum) {
        this.assessNum = assessNum;
    }

    public String getAssessDepartment() {
        return assessDepartment;
    }

    public void setAssessDepartment(String assessDepartment) {
        this.assessDepartment = assessDepartment == null ? null : assessDepartment.trim();
    }

    public Integer getAssessTime() {
        return assessTime;
    }

    public void setAssessTime(Integer assessTime) {
        this.assessTime = assessTime;
    }
}