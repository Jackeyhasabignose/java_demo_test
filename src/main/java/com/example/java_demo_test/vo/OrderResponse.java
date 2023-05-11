package com.example.java_demo_test.vo;

import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entity.Menu; 
 
public class OrderResponse {   
	
    private List<Menu> menuList; //�n�^�Ǧh�� �ҥH��list   menuList�O�ۤv���w���W�r//�ݩ�
    private Map<String , Integer> orderMap;
   
    private int totalPrice;//��������
	private String message;//�ݩ�
	
	
	public OrderResponse(String message) {
		super();
		this.message = message;
	}
	public OrderResponse(List<Menu> menuList, String message) {//�غc��k�S���^�ǫ��A//�غc��k�O�`�ٵ{���Xresponse
		super();
		this.menuList = menuList;
		this.message = message;
	}
	public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Menu> getMenuList() { //�H�U�O�غc��k get set
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
