package com.hqyj.personel.po;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 薪酬记录
 * @author SJY
 *
 */
public class Payment extends PageHelp {
	/** 薪酬id */
    private Integer paymentId;
    /** 员工编号 */
    private String employeeNo;
    /** 基本工资 */
    private Integer basicPayment;
    /** 绩效工资 */
    private Float performance;
    /** 奖金 */
    private Float reward;
    /** 罚款 */
    private Float punishment;
    /** 薪酬数目 */
    private Float salary;
    /** 获薪时间 */
    private Date getSalaryTime;
    
    public String strSalaryTime() {
		int year = this.getSalaryTime.getYear()+1900;
		int month = this.getSalaryTime.getMonth()+1;
		int day = this .getSalaryTime.getDate();
		return year+"-"+month+"-"+day;
	}

    @Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", employeeNo=" + employeeNo + ", basicPayment=" + basicPayment
				+ ", performance=" + performance + ", reward=" + reward + ", punishment=" + punishment + ", salary="
				+ salary + ", getSalaryTime=" + getSalaryTime + "]";
	}

	public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo == null ? null : employeeNo.trim();
    }

    public Integer getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(Integer basicPayment) {
        this.basicPayment = basicPayment;
    }

    public Float getPerformance() {
        return performance;
    }

    public void setPerformance(Float performance) {
        this.performance = performance;
    }

    public Float getReward() {
        return reward;
    }

    public void setReward(Float reward) {
        this.reward = reward;
    }

    public Float getPunishment() {
        return punishment;
    }

    public void setPunishment(Float punishment) {
        this.punishment = punishment;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getGetSalaryTime() {
    	// Date --> String
    	// Date是po里有的，要显示给其他地方
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(this.getSalaryTime);
    }

    public void setGetSalaryTime(String getSalaryTime) {
    	// String --> Date
    	// String是从数据库里拿出来。或是从页面上拿到
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
			this.getSalaryTime = sdf.parse(getSalaryTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
}