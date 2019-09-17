package com.hqyj.personel.po;

import java.util.Date;

public class Recruitment {
    private Integer recruitmentId;

    private String recruitmentNo;

    private String recruitmentName;

    private String recruitmentSex;

    private Date bornDate;

    private String telphone;

    private String emailAdress;

    private String recruitmentStatement;

    private String employeeNo;

    private String educationBackgment;

    private String department;

    private String position;

    private Date enterDate;

    private String peopleState;

    private Integer contractYears;

    public Integer getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(Integer recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public String getRecruitmentNo() {
        return recruitmentNo;
    }

    public void setRecruitmentNo(String recruitmentNo) {
        this.recruitmentNo = recruitmentNo == null ? null : recruitmentNo.trim();
    }

    public String getRecruitmentName() {
        return recruitmentName;
    }

    public void setRecruitmentName(String recruitmentName) {
        this.recruitmentName = recruitmentName == null ? null : recruitmentName.trim();
    }

    public String getRecruitmentSex() {
        return recruitmentSex;
    }

    public void setRecruitmentSex(String recruitmentSex) {
        this.recruitmentSex = recruitmentSex == null ? null : recruitmentSex.trim();
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress == null ? null : emailAdress.trim();
    }

    public String getRecruitmentStatement() {
        return recruitmentStatement;
    }

    public void setRecruitmentStatement(String recruitmentStatement) {
        this.recruitmentStatement = recruitmentStatement == null ? null : recruitmentStatement.trim();
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo == null ? null : employeeNo.trim();
    }

    public String getEducationBackgment() {
        return educationBackgment;
    }

    public void setEducationBackgment(String educationBackgment) {
        this.educationBackgment = educationBackgment == null ? null : educationBackgment.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public String getPeopleState() {
        return peopleState;
    }

    public void setPeopleState(String peopleState) {
        this.peopleState = peopleState == null ? null : peopleState.trim();
    }

    public Integer getContractYears() {
        return contractYears;
    }

    public void setContractYears(Integer contractYears) {
        this.contractYears = contractYears;
    }
}