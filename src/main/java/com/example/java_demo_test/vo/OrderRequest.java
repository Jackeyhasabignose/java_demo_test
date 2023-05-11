package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.Menu;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderRequest {
	@JsonProperty("menu_list") // 改名//這樣從外部近來只會找menu_list這個字
	List<Menu> menuList;
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
}
