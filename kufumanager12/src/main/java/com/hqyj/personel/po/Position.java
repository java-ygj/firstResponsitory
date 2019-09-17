package com.hqyj.personel.po;

import java.sql.Date;

public class Position extends PageHelp {
	/* 职位id */
	private Integer positionId;
	
	/*
	 * 职位编号 private String positionNo;
	 */
	
	/* 职称 */
	private String positionName;
	/* 部门id */
	private Integer departmentId;
	/*职位描述*/
	private String positionDesc;
	/*职位状态*/
	private String positionState;
	/*创建时间*/
	private Date positionCreateTime;
	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", positionName=" + positionName + ", departmentId="
				+ departmentId + ", positionDesc=" + positionDesc + ", positionState=" + positionState
				+ ", positionCreateTime=" + positionCreateTime + ", toString()=" + super.toString() + "]";
	}
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getPositionDesc() {
		return positionDesc;
	}
	public void setPositionDesc(String positionDesc) {
		this.positionDesc = positionDesc;
	}
	public String getPositionState() {
		return positionState;
	}
	public void setPositionState(String positionState) {
		this.positionState = positionState;
	}
	public Date getPositionCreateTime() {
		return positionCreateTime;
	}
	public void setPositionCreateTime(Date positionCreateTime) {
		this.positionCreateTime = positionCreateTime;
	}
	
}