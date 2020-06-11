package com.ugm.site.po;

import java.sql.Timestamp;

public class SiteOrder {
	   private Integer orderId;
	   private Integer ordersiteId;
	   private Timestamp orderStarttime;
	   private Timestamp orderEndtime;
	   private Timestamp orderBooktime;
	   private  String orderRentprice;
	   private  Double orderDepositprice;
	   private   Integer orderIfpay;
	   private SiteDetail siteDetail;
	   
	public SiteDetail getSiteDetail() {
		return siteDetail;
	}
	public void setSiteDetail(SiteDetail siteDetail) {
		this.siteDetail = siteDetail;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getOrdersiteId() {
		return ordersiteId;
	}
	public void setOrdersiteId(Integer ordersiteId) {
		this.ordersiteId = ordersiteId;
	}
	public Timestamp getOrderStarttime() {
		return orderStarttime;
	}
	public void setOrderStarttime(Timestamp orderStarttime) {
		this.orderStarttime = orderStarttime;
	}
	public Timestamp getOrderEndtime() {
		return orderEndtime;
	}
	public void setOrderEndtime(Timestamp orderEndtime) {
		this.orderEndtime = orderEndtime;
	}
	public Timestamp getOrderBooktime() {
		return orderBooktime;
	}
	public void setOrderBooktime(Timestamp orderBooktime) {
		this.orderBooktime = orderBooktime;
	}
	public String getOrderRentprice() {
		return orderRentprice;
	}
	public void setOrderRentprice(String orderRentprice) {
		this.orderRentprice = orderRentprice;
	}
	public Double getOrderDepositprice() {
		return orderDepositprice;
	}
	public void setOrderDepositprice(Double orderDepositprice) {
		this.orderDepositprice = orderDepositprice;
	}
	public Integer getOrderIfpay() {
		return orderIfpay;
	}
	public void setOrderIfpay(Integer orderIfpay) {
		this.orderIfpay = orderIfpay;
	}
		
}
