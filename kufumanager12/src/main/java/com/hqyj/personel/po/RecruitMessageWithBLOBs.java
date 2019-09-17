package com.hqyj.personel.po;

public class RecruitMessageWithBLOBs extends RecruitMessage {
    private String duty;

    private String demand;

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand == null ? null : demand.trim();
    }
}