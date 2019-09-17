package com.hqyj.personel.vo;

/**
 * @author SJY
 *
 */
public class PaymentVO {
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
	private String getSalaryTime;
	
	public PaymentVO() {
		super();
	}

	public PaymentVO(Integer paymentId, String employeeNo, Integer basicPayment, Float performance, Float reward,
			Float punishment, Float salary, String getSalaryTime) {
		super();
		this.paymentId = paymentId;
		this.employeeNo = employeeNo;
		this.basicPayment = basicPayment;
		this.performance = performance;
		this.reward = reward;
		this.punishment = punishment;
		this.salary = salary;
		this.getSalaryTime = getSalaryTime;
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
		this.employeeNo = employeeNo;
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
		
		
		return getSalaryTime;
	}

	public void setGetSalaryTime(String getSalaryTime) {
		this.getSalaryTime = getSalaryTime;
	}

}
