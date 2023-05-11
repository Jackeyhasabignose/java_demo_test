package com.example.java_demo_test.vo;

import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entity.Menu; 
 
public class OrderResponse {   
	
    private List<Menu> menuList; //要回傳多筆 所以用list   menuList是自己喜歡的名字//屬性
    private Map<String , Integer> orderMap;
   
    private int totalPrice;//打折後價格
	private String message;//屬性
	
	
	public OrderResponse(String message) {
		super();
		this.message = message;
	}
	public OrderResponse(List<Menu> menuList, String message) {//建構方法沒有回傳型態//建構方法是節省程式碼response
		super();
		this.menuList = menuList;
		this.message = message;
	}
	public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Menu> getMenuList() { //以下是建構方法 get set
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Map<String, Integer> getOrderMap() {
		return orderMap;
	}
	public void setOrderMap(Map<String, Integer> orderMap) {
		this.orderMap = orderMap;
	}
	public OrderResponse(Map<String, Integer> orderMap, int totalPrice, String message) {
		super();
		this.orderMap = orderMap;
		this.totalPrice = totalPrice;
		this.message = message;
	}
	
	
}
