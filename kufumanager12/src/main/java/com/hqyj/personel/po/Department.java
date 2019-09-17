package com.hqyj.personel.po;

public class Department extends PageHelp{
    private Integer departmentId;

    private String departmentName;
   
    private int delDepartmentStatus;
    /*简写*/
    private String departmentDes;
    
    
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", delDepartmentStatus=" + delDepartmentStatus + ", departmentDes=" + departmentDes + "]";
	}

	

	public String getDepartmentDes() {
		return departmentDes;
	}



	public void setDepartmentDes(String departmentDes) {
		this.departmentDes = departmentDes;
	}



	public int getDelDepartmentStatus() {
		return delDepartmentStatus;
	}

	public void setDelDepartmentStatus(int delDepartmentStatus) {
		this.delDepartmentStatus = delDepartmentStatus;
	}

	public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }
}