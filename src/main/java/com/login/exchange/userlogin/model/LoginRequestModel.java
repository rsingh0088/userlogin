package com.login.exchange.userlogin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LoginRequestModel {
	
	String userName;
	
	String passWord;
	
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
