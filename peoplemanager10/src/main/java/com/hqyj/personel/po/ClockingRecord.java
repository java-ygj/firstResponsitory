package com.hqyj.personel.po;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 考勤管理
 * @author SJY
 *
 */
public class ClockingRecord extends PageHelp{
	/** 考勤_id */
	private Integer clockingId;
	/** 考勤时间 */
	private Date clockingDate;
	/** 员工编号 */
	private String employeeNo;
	/** 类型 */
	private String type;
	/** 奖惩金额 */
	private Integer reardAndPunish;
	/** 考勤人 */
	private String clocker;
	
//	public String strClockingDate() {
//		int year = this.clockingDate.getYear()+1900;
//		int month = this.clockingDate.getMonth()+1;
//		int day = this .clockingDate.getDate();
//		return year+"-"+month+"-"+day;
//	}
	
	@Override
	public String toString() {
		return "ClockingRecord [clockingId=" + clockingId + ", clockingDate=" + clockingDate + ", employeeNo="
				+ employeeNo + ", type=" + type + ", reardAndPunish=" + reardAndPunish + ", clocker=" + clocker + "]";
	}
	public Integer getClockingId() {
		return clockingId;
	}
	public void setClockingId(Integer clockingId) {
		this.clockingId = clockingId;
	}
	@SuppressWarnings("unlikely-arg-type")
	public String getClockingDate() {
		// Date --> String
    	// Date是po里有的，要显示给其他地方
		String str = "";
		if(!"".equals(this.clockingDate)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			str= sdf.format(this.clockingDate);
		}
    	return str;
	}
	public void setClockingDate(String clockingDate) {
		// String --> Data
    	// String是从数据库里拿出来。或是从页面上拿到
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.clockingDate = sdf.parse(clockingDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getReardAndPunish() {
		return reardAndPunish;
	}
	public void setReardAndPunish(Integer reardAndPunish) {
		this.reardAndPunish = reardAndPunish;
	}
	public String getClocker() {
		return clocker;
	}
	public void setClocker(String clocker) {
		this.clocker = clocker;
	}
	

}