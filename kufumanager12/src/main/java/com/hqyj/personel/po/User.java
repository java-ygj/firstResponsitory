package com.hqyj.personel.po;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User extends PageHelp{
    private Integer userId;

    private String employeeNo;

    private String password;

    private String name;

    private String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(
    	    pattern = "yyyy-MM-dd",
    	    timezone = "GMT+8"
    	)
    private Date birthday;

    private String telephone;

    private String emailAddress;

    private String eduBg;

    private Integer departmentId;

    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(
    	    pattern = "yyyy-MM-dd",
    	    timezone = "GMT+8"
    	)
    private Date entryTime;
    
    private String emploryeeStatus;

    private String remark;

    private String personId;
    
    private String deleteStatus;

    private String checkId;
    
	public User() {
		super();
	}

	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", employeeNo=" + employeeNo + ", password=" + password + ", name=" + name
				+ ", sex=" + sex + ", birthday=" + birthday + ", telephone=" + telephone + ", emailAddress="
				+ emailAddress + ", eduBg=" + eduBg + ", departmentId=" + departmentId + ", address=" + address
				+ ", entryTime=" + entryTime + ", emploryeeStatus=" + emploryeeStatus + ", remark=" + remark
				+ ", personId=" + personId + ", deleteStatus=" + deleteStatus + ", checkId=" + checkId + ", toString()="
				+ super.toString() + "]";
	}



	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEduBg() {
		return eduBg;
	}

	public void setEduBg(String eduBg) {
		this.eduBg = eduBg;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public String getEmploryeeStatus() {
		return emploryeeStatus;
	}

	public void setEmploryeeStatus(String emploryeeStatus) {
		this.emploryeeStatus = emploryeeStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
   
}