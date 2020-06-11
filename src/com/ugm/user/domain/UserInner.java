package com.ugm.user.domain;

import java.io.Serializable;

public class UserInner implements Serializable {
	private static final long serialVersionUID = 1L;
	private String usercode;
	private String username;
	private String userclass;
	private String usersex;
	private String userhome;
	
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserclass() {
		return userclass;
	}
	public void setUserclass(String userclass) {
		this.userclass = userclass;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public String getUserhome() {
		return userhome;
	}
	public void setUserhome(String userhome) {
		this.userhome = userhome;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public UserInner() {
		super();
	}
	
}
