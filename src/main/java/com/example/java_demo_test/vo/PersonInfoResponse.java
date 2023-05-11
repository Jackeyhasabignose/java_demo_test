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

	public PersonInfoResponse() {//璶Τ把计篶よ猭ㄓ璶癘眔玻ネ篶よ猭
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonInfoResponse(String message) {//Τ把计篶よ猭
		super();
		this.message = message;
	}

	//玻ネよ猭
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
