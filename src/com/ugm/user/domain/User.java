package com.ugm.user.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String userPass;
	private boolean isManager;
	private boolean isDeleted;
	private String useRright;
	private BigDecimal userMoney;

	public String getUserName() {
		return userName;
	}

	public void setUserPame(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getUseRright() {
		return useRright;
	}

	public void setUseRright(String useRright) {
		this.useRright = useRright;
	}

	public BigDecimal getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(BigDecimal userMoney) {
		this.userMoney = userMoney;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User() {
		super();
	}
}
