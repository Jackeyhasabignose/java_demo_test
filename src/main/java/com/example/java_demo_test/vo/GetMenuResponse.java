package com.example.java_demo_test.vo;

import com.example.java_demo_test.entity.Menu;

public class GetMenuResponse {

	private Menu menu;//menuªºlist
	private String message;
	public Menu getMenu() {
		return menu;
		
	}
	
	public GetMenuResponse(Menu menu, String message) {
		super();
		this.menu = menu;
		this.message = message;
	}

	public GetMenuResponse(String message) {
		super();
		this.message = message;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
