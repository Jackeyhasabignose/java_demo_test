package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.Login;

public class LoginResponse {
	
	private String message;
	private Login login;
	private List<Login> loginList;
	
	
	public LoginResponse(String message, List<Login> loginList) {
		super();
		this.message = message;
		this.loginList = loginList;
	}
	public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginResponse(String message) {
		super();
		this.message = message;
	}
	public LoginResponse(String message, Login login, List<Login> loginList) {
		super();
		this.message = message;
		this.login = login;
		this.loginList = loginList;
	}
	public LoginResponse(String message, Login login) {
		super();
		this.message = message;
		this.login = login;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public List<Login> getLoginList() {
		return loginList;
	}
	public void setLoginList(List<Login> loginList) {
		this.loginList = loginList;
	}
	
	

}
