package com.hj.aftersaleservice.domain;

import java.math.BigDecimal;

public class Repair {
    private Integer repair_id;
    private String cName; //报修人
    private String cTelephone; //联系电话
    private String saleNumber; //销售单号
    private String content; //报修内容
    private String cTime; //报修时间
    private String repairState; //维修状态
    private String repairName; //维修人
    private String repairTime; //维修时间
    private BigDecimal repairMoney; //维修费用
    private String auditName; //审核人
    private String auditTime; //审核时间
    private String cRemark; //报修人评价

    public Integer getRepair_id() {
        return repair_id;
    }

    public void setRepair_id(Integer repair_id) {
        this.repair_id = repair_id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcTelephone() {
        return cTelephone;
    }

    public void setcTelephone(String cTelephone) {
        this.cTelephone = cTelephone;
    }

    public String getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public String getRepairState() {
        return repairState;
    }

    public void setRepairState(String repairState) {
        this.repairState = repairState;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public String getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(String repairTime) {
        this.repairTime = repairTime;
    }

    public BigDecimal getRepairMoney() {
        return repairMoney;
    }

    public void setRepairMoney(BigDecimal repairMoney) {
        this.repairMoney = repairMoney;
    }

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public String getcRemark() {
        return cRemark;
    }

    public void setcRemark(String cRemark) {
        this.cRemark = cRemark;
    }
}
