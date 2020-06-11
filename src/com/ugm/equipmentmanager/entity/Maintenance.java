package com.ugm.equipmentmanager.entity;

import java.math.BigDecimal;

public class Maintenance {
	private int maiId;
	private String maintenanceReason;
	private int maiCondition;
	private BigDecimal maiCost;
	private int approverId;
	private String maiStartDate;
	private String maiEndDate;
	public int getMaiId() {
		return maiId;
	}
	public void setMaiId(int maiId) {
		this.maiId = maiId;
	}
	public String getMaintenanceReason() {
		return maintenanceReason;
	}
	public void setMaintenanceReason(String maintenanceReason) {
		this.maintenanceReason = maintenanceReason;
	}
	public int getMaiCondition() {
		return maiCondition;
	}
	public void setMaiCondition(int maiCondition) {
		this.maiCondition = maiCondition;
	}

	public BigDecimal getMaiCost() {
		return maiCost;
	}
	public void setMaiCost(BigDecimal maiCost) {
		this.maiCost = maiCost;
	}
	public int getApproverId() {
		return approverId;
	}
	public void setApproverId(int approverId) {
		this.approverId = approverId;
	}
	public String getMaiStartDate() {
		return maiStartDate;
	}
	public void setMaiStartDate(String maiStartDate) {
		this.maiStartDate = maiStartDate;
	}
	public String getMaiEndDate() {
		return maiEndDate;
	}
	public void setMaiEndDate(String maiEndDate) {
		this.maiEndDate = maiEndDate;
	}
	@Override
	public String toString() {
		return "Maintenance [maiId=" + maiId + ", maintenanceReason=" + maintenanceReason + ", maiCondition="
				+ maiCondition + ", MaiCost=" + maiCost + ", approverId=" + approverId + ", maiStartDate="
				+ maiStartDate + ", maiEndDate=" + maiEndDate + "]";
	}



	
	
}
