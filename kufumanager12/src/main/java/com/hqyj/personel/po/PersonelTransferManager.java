package com.hqyj.personel.po;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonelTransferManager extends PageHelp{
	/*调配id*/
    private Integer transferId;
    /*调配编号*/
    private String transferNo;
    /*员工编号*/
    private String employeeNo;
    /*老职称*/
    private String oldPosition;
    /*新职称*/
    private String newPosition;
    /*调配时间*/
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(
    	    pattern = "yyyy-MM-dd",
    	    timezone = "GMT+8"
    	)
    private Date transferDate;
    /*调配原因*/
    private String transferReson;

    @Override
	public String toString() {
		return "PersonelTransferManager [transferId=" + transferId + ", transferNo=" + transferNo + ", employeeNo="
				+ employeeNo + ", oldPosition=" + oldPosition + ", newPosition=" + newPosition + ", transferDate="
				+ transferDate + ", transferReson=" + transferReson + ", toString()=" + super.toString() + "]";
	}

	public Integer getTransferId() {
        return transferId;
    }

    public void setTransferId(Integer transferId) {
        this.transferId = transferId;
    }

    public String getTransferNo() {
        return transferNo;
    }

    public void setTransferNo(String transferNo) {
        this.transferNo = transferNo == null ? null : transferNo.trim();
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo == null ? null : employeeNo.trim();
    }

    public String getOldPosition() {
        return oldPosition;
    }

    public void setOldPosition(String oldPosition) {
        this.oldPosition = oldPosition == null ? null : oldPosition.trim();
    }

    public String getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(String newPosition) {
        this.newPosition = newPosition == null ? null : newPosition.trim();
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public String getTransferReson() {
        return transferReson;
    }

    public void setTransferReson(String transferReson) {
        this.transferReson = transferReson == null ? null : transferReson.trim();
    }
}