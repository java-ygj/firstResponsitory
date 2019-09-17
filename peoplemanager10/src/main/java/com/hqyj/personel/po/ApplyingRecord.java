package com.hqyj.personel.po;

import java.util.Date;

public class ApplyingRecord {
    private Integer applyingId;

    private String applyingNo;

    private String applyingName;

    private String applyingSex;

    private Date bornDate;

    private String telpone;

    private String emailAddress;

    private String applyingPosition;

    private String educationBackground;

    private String experience;

    private String school;

    private String remark;

    public Integer getApplyingId() {
        return applyingId;
    }

    public void setApplyingId(Integer applyingId) {
        this.applyingId = applyingId;
    }

    public String getApplyingNo() {
        return applyingNo;
    }

    public void setApplyingNo(String applyingNo) {
        this.applyingNo = applyingNo == null ? null : applyingNo.trim();
    }

    public String getApplyingName() {
        return applyingName;
    }

    public void setApplyingName(String applyingName) {
        this.applyingName = applyingName == null ? null : applyingName.trim();
    }

    public String getApplyingSex() {
        return applyingSex;
    }

    public void setApplyingSex(String applyingSex) {
        this.applyingSex = applyingSex == null ? null : applyingSex.trim();
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getTelpone() {
        return telpone;
    }

    public void setTelpone(String telpone) {
        this.telpone = telpone == null ? null : telpone.trim();
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress == null ? null : emailAddress.trim();
    }

    public String getApplyingPosition() {
        return applyingPosition;
    }

    public void setApplyingPosition(String applyingPosition) {
        this.applyingPosition = applyingPosition == null ? null : applyingPosition.trim();
    }

    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground == null ? null : educationBackground.trim();
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience == null ? null : experience.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}