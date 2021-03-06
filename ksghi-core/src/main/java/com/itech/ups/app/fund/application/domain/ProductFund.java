package com.itech.ups.app.fund.application.domain;
/*
 * @ huangguohu  2015-08-26
 */

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductFund implements Serializable {

    private static final long serialVersionUID = -8907618150277364610L;

    private String id;

    private String name;

    private String type;

    private String shortName;

    private String code;

    private String company;

    private String manager;

    private String style;

    private Long riskLevel;

    private String photosAttachments;

    private BigDecimal unitNet;

    private BigDecimal cumulativeNet;

    private String upperAndLowerFrame;

    private String remark;

    private String auditStatus;

    private String dataStatus;

    private String createTime;

    private String creatorId;

    private String creatorName;

    private String editTime;

    private String editorId;

    private String editorName;

    private String auditDesc;

    private String auditTime;

    private String auditorId;

    private String auditorName;

    private String status;

    private String description;

    private String firstCapital;

    private BigDecimal buyFeeRate;// 购买费率

    private BigDecimal redeemFeeRate;// 赎回费率

    private String establishDate;// 基金成立日

    public String getFirstCapital() {
        return firstCapital;
    }

    public void setFirstCapital(String firstCapital) {
        this.firstCapital = firstCapital;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Long getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Long riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getPhotosAttachments() {
        return photosAttachments;
    }

    public void setPhotosAttachments(String photosAttachments) {
        this.photosAttachments = photosAttachments;
    }

    public BigDecimal getUnitNet() {
        return unitNet;
    }

    public void setUnitNet(BigDecimal unitNet) {
        this.unitNet = unitNet;
    }

    public BigDecimal getCumulativeNet() {
        return cumulativeNet;
    }

    public void setCumulativeNet(BigDecimal cumulativeNet) {
        this.cumulativeNet = cumulativeNet;
    }

    public String getUpperAndLowerFrame() {
        return upperAndLowerFrame;
    }

    public void setUpperAndLowerFrame(String upperAndLowerFrame) {
        this.upperAndLowerFrame = upperAndLowerFrame;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getEditorId() {
        return editorId;
    }

    public void setEditorId(String editorId) {
        this.editorId = editorId;
    }

    public String getEditorName() {
        return editorName;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(String auditorId) {
        this.auditorId = auditorId;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public BigDecimal getBuyFeeRate() {
        return buyFeeRate;
    }

    public void setBuyFeeRate(BigDecimal buyFeeRate) {
        this.buyFeeRate = buyFeeRate;
    }

    public BigDecimal getRedeemFeeRate() {
        return redeemFeeRate;
    }

    public void setRedeemFeeRate(BigDecimal redeemFeeRate) {
        this.redeemFeeRate = redeemFeeRate;
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }

}