package com.hqyj.personel.po;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
/*员工合同管理*/
public class Contract extends PageHelp{
	/*合同id*/
    private Integer contractId;
    /*合同编号*/
    private String contractNo;
    /*员工编号*/
    private String employeeNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(
    	    pattern = "yyyy-MM-dd",
    	    timezone = "GMT+8"
    	)
    /*合同开始日期*/
    private Date contractBeginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(
    	    pattern = "yyyy-MM-dd",
    	    timezone = "GMT+8"
    	)
    /*结束日期*/
    private Date contractEndDate;
    /*职位*/
    private String position;
    /*备注(工作倾向)*/
    private String contractRemark;
    /*合同内容*/
    private String contractContents;
    /*员工姓名*/
    private String name ;
    /*部门id*/
    private int departmentId;
    /*部门名称*/
    private String departmentName;
    
    public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", contractNo=" + contractNo + ", employeeNo=" + employeeNo
				+ ", contractBeginDate=" + contractBeginDate + ", contractEndDate=" + contractEndDate + ", position="
				+ position + ", contractRemark=" + contractRemark + ", contractContents=" + contractContents + ", name="
				+ name + ", departmentId=" + departmentId + ", departmentName=" + departmentName + ", toString()="
				+ super.toString() + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo == null ? null : employeeNo.trim();
    }

    public Date getContractBeginDate() {
        return contractBeginDate;
    }

    public void setContractBeginDate(Date contractBeginDate) {
        this.contractBeginDate = contractBeginDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getContractRemark() {
        return contractRemark;
    }

    public void setContractRemark(String contractRemark) {
        this.contractRemark = contractRemark == null ? null : contractRemark.trim();
    }

    public String getContractContents() {
        return contractContents;
    }

    public void setContractContents(String contractContents) {
        this.contractContents = contractContents == null ? null : contractContents.trim();
    }
}