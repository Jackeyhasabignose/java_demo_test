package com.example.java_demo_test.vo;

import java.util.List;
import java.util.Optional;

import com.example.java_demo_test.entity.PersonInfo;

public class GetPersonInfoResponse {// getset跟兩個的建構方法跟空的建構方法//屬性加完記得加getset
    
	private PersonInfo personInfo; //類別可以當回資料型態
	private String message;
	private List<PersonInfo> resPersonInfo;
	 
	private Optional<PersonInfo> op;
	
	private int minAge;
	private int maxAge;
	
	
	
	public GetPersonInfoResponse(int minAge, int maxAge) {
		super();
		this.minAge = minAge;
		this.maxAge = maxAge;
	}
	public GetPersonInfoResponse(String message, List<PersonInfo> resPersonInfo) {
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
	public GetPersonInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GetPersonInfoResponse(String message) {
	super();
	this.message = message;
}
	public GetPersonInfoResponse(PersonInfo personInfo, String message) {
		super();
		this.personInfo = personInfo;
		this.message = message;
	}
	
	
	public GetPersonInfoResponse(String message, Optional<PersonInfo> op) {
		super();
		this.message = message;
		this.op = op;
	}
	public PersonInfo getPersonInfo() {
		return personInfo;
	}
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Optional<PersonInfo> getOp() {
		return op;
	}
	public void setOp(Optional<PersonInfo> op) {
		this.op = op;
	}
	
	
}
