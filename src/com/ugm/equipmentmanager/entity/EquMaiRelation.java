package com.ugm.equipmentmanager.entity;

import java.math.BigDecimal;


public class EquMaiRelation {
	
	/**
	 *  Equipment
	 */
	private int equId;
	private String equName;
	private int useCondition;
	private int brokenCondition;
	private BigDecimal rentPrice;
	private BigDecimal maintenancePrice;
	private BigDecimal reservationPrice;
	private BigDecimal buyPrice;
	private String equUpdateTime;

	/**
	 *  Maintenance
	 */
	private int maiId;
	private String maintenanceReason;
	private int maiCondition;
	private BigDecimal maiCost;
	private String maiStartDate;
	private String maiEndDate;
	private int maiApproverId;

	
	
	private int quantity;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public int getEquId() {
		return equId;
	}
	public void setEquId(int equId) {
		this.equId = equId;
	}
	public String getEquName() {
		return equName;
	}
	public void setEquName(String equName) {
		this.equName = equName;
	}
	public int getUseCondition() {
		return useCondition;
	}
	public void setUseCondition(int useCondition) {
		this.useCondition = useCondition;
	}
	public int getBrokenCondition() {
		return brokenCondition;
	}
	public void setBrokenCondition(int brokenCondition) {
		this.brokenCondition = brokenCondition;
	}
	public BigDecimal getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(BigDecimal rentPrice) {
		this.rentPrice = rentPrice;
	}
	public BigDecimal getMaintenancePrice() {
		return maintenancePrice;
	}
	public void setMaintenancePrice(BigDecimal maintenancePrice) {
		this.maintenancePrice = maintenancePrice;
	}
	public BigDecimal getReservationPrice() {
		return reservationPrice;
	}
	public void setReservationPrice(BigDecimal reservationPrice) {
		this.reservationPrice = reservationPrice;
	}
	public BigDecimal getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}
	public String getEquUpdateTime() {
		return equUpdateTime;
	}
	public void setEquUpdateTime(String equUpdateTime) {
		this.equUpdateTime = equUpdateTime;
	}
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
	public int getMaiApproverId() {
		return maiApproverId;
	}
	public void setMaiApproverId(int maiApproverId) {
		this.maiApproverId = maiApproverId;
	}

	
	
	
	
}
