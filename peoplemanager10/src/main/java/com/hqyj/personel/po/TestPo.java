package com.hqyj.personel.po;

public class TestPo {
	private Integer sysId;

	private String sysName;

	private String sysPwd;

	private String roleName;

	public TestPo() {
		super();
	}

	public TestPo(Integer sysId, String sysName, String sysPwd, String roleName) {
		super();
		this.sysId = sysId;
		this.sysName = sysName;
		this.sysPwd = sysPwd;
		this.roleName = roleName;
	}

	public TestPo(String sysName, String sysPwd, String roleName) {
		super();
		this.sysName = sysName;
		this.sysPwd = sysPwd;
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "TestPo [sysId=" + sysId + ", sysName=" + sysName + ", sysPwd=" + sysPwd + ", roleName=" + roleName
				+ "]";
	}

	public Integer getSysId() {
		return sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	public String getSysPwd() {
		return sysPwd;
	}

	public void setSysPwd(String sysPwd) {
		this.sysPwd = sysPwd;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
