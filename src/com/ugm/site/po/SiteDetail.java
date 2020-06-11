package com.ugm.site.po;

public class SiteDetail {

	  private Integer siteId;
	  private String siteName;
	  private String siteLocation;
	  private String siteConfiguration;
	  private String siteRentprice;
	  private Double siteDepositprice;
	  private Sitestate sitestate;
	  
	  
	public Sitestate getSitestate() {
		return sitestate;
	}
	public void setSitestate(Sitestate sitestate) {
		this.sitestate = sitestate;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteLocation() {
		return siteLocation;
	}
	public void setSiteLocation(String siteLocation) {
		this.siteLocation = siteLocation;
	}
	public String getSiteConfiguration() {
		return siteConfiguration;
	}
	public void setSiteConfiguration(String siteConfiguration) {
		this.siteConfiguration = siteConfiguration;
	}
	public String getSiteRentprice() {
		return siteRentprice;
	}
	public void setSiteRentprice(String siteRentprice) {
		this.siteRentprice = siteRentprice;
	}
	public Double getSiteDepositprice() {
		return siteDepositprice;
	}
	public void setSiteDepositprice(Double siteDepositprice) {
		this.siteDepositprice = siteDepositprice;
	}
	
	
}
