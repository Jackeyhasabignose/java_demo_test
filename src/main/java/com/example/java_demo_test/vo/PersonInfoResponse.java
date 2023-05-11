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

	public PersonInfoResponse() {//�u�n���Ѽƪ��غc��k�X�ӭn�O�o���ͪŪ��غc��k
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonInfoResponse(String message) {//���Ѽƪ��غc��k
		super();
		this.message = message;
	}

	//���ͤ�k
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
