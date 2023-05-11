package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;

public class PersonInfoResponse {

	private String message;
	
	private List<PersonInfo> resPersonInfo;
	
	

	

	
	

	public PersonInfoResponse(String message, List<PersonInfo> resPersonInfo) {
		super();
		this.message = message;
		this.resPersonInfo = resPersonInfo;
	}

	public List<PersonInfo> getResPersonInfo() {
		return resPersonInfo;
	}

	public void setResPersonInfo(List<PersonInfo> resPersonInfo) {
		this.resPersonInfo = resPersonInfo;
	}

	public PersonInfoResponse() {//只要有參數的建構方法出來要記得產生空的建構方法
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonInfoResponse(String message) {//有參數的建構方法
		super();
		this.message = message;
	}

	//產生方法
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
