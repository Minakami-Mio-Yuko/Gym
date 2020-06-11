package com.ugm.equipmentmanager.entity;

import java.math.BigDecimal;

public class EquOrderRelation {

	/**
	 *  Rent
	 */
	private BigDecimal rentTotalPrice;
	private String returnDate;
	private int rentApproverId;
	/**
	 *  Reservation
	 */
	private Integer orderListId;
	private String resTime;
	private BigDecimal resDeposit;
	private String rentTime;
	private int resApproverId;
	private int userId;
	/**
	 *  Return
	 */

	private String trueReturnDate;
	private int returnCondition;
	private BigDecimal returnDeposit;
	private String remark;
	private int returnApproverId;
	private String orderUpdateTime;
	
	/**
	 *  Equipment
	 */
	private  Integer equId;
	private String equName;
	private int brokenCondition;
	private BigDecimal rentPrice;
	private BigDecimal maintenancePrice;
	private BigDecimal reservationPrice;
	private BigDecimal buyPrice;
	private String equUpdateTime;
	private int orderCondition;
	private int unsubscribeApproverId;
	
	private int quantity;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public BigDecimal getRentTotalPrice() {
		return rentTotalPrice;
	}
	public void setRentTotalPrice(BigDecimal rentTotalPrice) {
		this.rentTotalPrice = rentTotalPrice;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public int getRentApproverId() {
		return rentApproverId;
	}
	public void setRentApproverId(int rentApproverId) {
		this.rentApproverId = rentApproverId;
	}

	public String getResTime() {
		return resTime;
	}
	public void setResTime(String resTime) {
		this.resTime = resTime;
	}
	public BigDecimal getResDeposit() {
		return resDeposit;
	}
	public void setResDeposit(BigDecimal resDeposit) {
		this.resDeposit = resDeposit;
	}
	public String getRentTime() {
		return rentTime;
	}
	public void setRentTime(String rentTime) {
		this.rentTime = rentTime;
	}
	public int getResApproverId() {
		return resApproverId;
	}
	public void setResApproverId(int resApproverId) {
		this.resApproverId = resApproverId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTrueReturnDate() {
		return trueReturnDate;
	}
	public void setTrueReturnDate(String trueReturnDate) {
		this.trueReturnDate = trueReturnDate;
	}
	public int getReturnCondition() {
		return returnCondition;
	}
	public void setReturnCondition(int returnCondition) {
		this.returnCondition = returnCondition;
	}
	public BigDecimal getReturnDeposit() {
		return returnDeposit;
	}
	public void setReturnDeposit(BigDecimal returnDeposit) {
		this.returnDeposit = returnDeposit;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getReturnApproverId() {
		return returnApproverId;
	}
	public void setReturnApproverId(int returnApproverId) {
		this.returnApproverId = returnApproverId;
	}

	public String getOrderUpdateTime() {
		return orderUpdateTime;
	}
	public void setOrderUpdateTime(String orderUpdateTime) {
		this.orderUpdateTime = orderUpdateTime;
	}
	public Integer getOrderListId() {
		return orderListId;
	}
	public void setOrderListId(Integer orderListId) {
		this.orderListId = orderListId;
	}
	public Integer getEquId() {
		return equId;
	}
	public void setEquId(Integer equId) {
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
	public int getOrderCondition() {
		return orderCondition;
	}
	public void setOrderCondition(int orderCondition) {
		this.orderCondition = orderCondition;
	}
	public int getUnsubscribeApproverId() {
		return unsubscribeApproverId;
	}
	public void setUnsubscribeApproverId(int unsubscribeApproverId) {
		this.unsubscribeApproverId = unsubscribeApproverId;
	}

	
	
	
	
}
