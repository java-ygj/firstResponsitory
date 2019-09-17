package com.hqyj.personel.po;

import java.util.Date;

public class RecruitMessage  {
    private Integer recuritId;

    private String positionName;

    private String positionCategory;

    private String recuritNum;

    private Date writtenTime;

    private Integer positionId;

    private Date recuritTime;

    private String recuritDepartment;

    private String publisher;

    private Integer departmentId;

    public Integer getRecuritId() {
        return recuritId;
    }

    public void setRecuritId(Integer recuritId) {
        this.recuritId = recuritId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }

    public String getPositionCategory() {
        return positionCategory;
    }

    public void setPositionCategory(String positionCategory) {
        this.positionCategory = positionCategory == null ? null : positionCategory.trim();
    }

    public String getRecuritNum() {
        return recuritNum;
    }

    public void setRecuritNum(String recuritNum) {
        this.recuritNum = recuritNum == null ? null : recuritNum.trim();
    }

    public Date getWrittenTime() {
        return writtenTime;
    }

    public void setWrittenTime(Date writtenTime) {
        this.writtenTime = writtenTime;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Date getRecuritTime() {
        return recuritTime;
    }

    public void setRecuritTime(Date recuritTime) {
        this.recuritTime = recuritTime;
    }

    public String getRecuritDepartment() {
        return recuritDepartment;
    }

    public void setRecuritDepartment(String recuritDepartment) {
        this.recuritDepartment = recuritDepartment == null ? null : recuritDepartment.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}