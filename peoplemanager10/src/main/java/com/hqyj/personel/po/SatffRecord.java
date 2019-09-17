package com.hqyj.personel.po;

public class SatffRecord extends PageHelp {
	/* 档案id */
	private Integer recordId;
	/* 档案编号 */
	private String recordNo;
	/* 员工编号 */
	private String empolyeeNo;
	/* 员工名字 */
	private String name;
	/* 档案名称 */
	private String recordName;
	/* 备注 */
	private String remark;
	/* 部门id */
	private Integer departmentId;
	/* 内容摘要 */
	private String contentDigest;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public String getRecordNo() {
		return recordNo;
	}

	public void setRecordNo(String recordNo) {
		this.recordNo = recordNo == null ? null : recordNo.trim();
	}

	public String getEmpolyeeNo() {
		return empolyeeNo;
	}

	public void setEmpolyeeNo(String empolyeeNo) {
		this.empolyeeNo = empolyeeNo == null ? null : empolyeeNo.trim();
	}

	public String getRecordName() {
		return recordName;
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName == null ? null : recordName.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getContentDigest() {
		return contentDigest;
	}

	public void setContentDigest(String contentDigest) {
		this.contentDigest = contentDigest == null ? null : contentDigest.trim();
	}
}