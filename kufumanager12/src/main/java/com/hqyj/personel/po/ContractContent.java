package com.hqyj.personel.po;

public class ContractContent {
    private Integer contractContentId;

    private String contractContentNo;

    private String contractContentType;

    private String contractContent;

    public Integer getContractContentId() {
        return contractContentId;
    }

    public void setContractContentId(Integer contractContentId) {
        this.contractContentId = contractContentId;
    }

    public String getContractContentNo() {
        return contractContentNo;
    }

    public void setContractContentNo(String contractContentNo) {
        this.contractContentNo = contractContentNo == null ? null : contractContentNo.trim();
    }

    public String getContractContentType() {
        return contractContentType;
    }

    public void setContractContentType(String contractContentType) {
        this.contractContentType = contractContentType == null ? null : contractContentType.trim();
    }

    public String getContractContent() {
        return contractContent;
    }

    public void setContractContent(String contractContent) {
        this.contractContent = contractContent == null ? null : contractContent.trim();
    }
}