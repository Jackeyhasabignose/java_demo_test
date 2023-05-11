package com.example.java_demo_test.constants;

public enum RtnCode {// 排序//常數都是大寫//集中管理

	SUCCESSFFUL("200", "Successful!!!"), // ,多個
	CANNOT_DOUBLE("400", "Account or password is exist!!!"), 
	DATA_ERROR("400", "Account of password is error or blank!!!"),
	NOT_FOUND("404", "Not found!!!");

	private String code;
	private String message;

	private RtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
