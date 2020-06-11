package com.ugm.equipmentmanager.entity;

import java.math.BigDecimal;


public class Equipment {
	private int equId;
	private String equName;
	private int brokenCondition;
	private BigDecimal rentPrice;
	private BigDecimal maintenancePrice;
	private BigDecimal reservationPrice;
	private BigDecimal buyPrice;
	private String equUpdateTime;
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
	@Override
	public String toString() {
		return "Equipment [equId=" + equId + ", equName=" + equName 
				+ ", brokenCondition=" + brokenCondition + ", rentPrice=" + rentPrice + ", maintenancePrice="
				+ maintenancePrice + ", reservationPrice=" + reservationPrice + ", buyPrice=" + buyPrice
				+ ", equUpdateTime=" + equUpdateTime + "]";
	}

	private int quantity;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	
	
}
