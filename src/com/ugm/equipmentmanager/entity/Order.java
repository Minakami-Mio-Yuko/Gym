package com.ugm.equipmentmanager.entity;

import java.math.BigDecimal;

public class Order {
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
	private String order_update_time;
	private int orderCondition;
	private int unsubscribeApproverId;
	
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
	public String getOrder_update_time() {
		return order_update_time;
	}
	public void setOrder_update_time(String order_update_time) {
		this.order_update_time = order_update_time;
	}
	public Integer getOrderListId() {
		return orderListId;
	}
	public void setOrderListId(Integer orderListId) {
		this.orderListId = orderListId;
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
