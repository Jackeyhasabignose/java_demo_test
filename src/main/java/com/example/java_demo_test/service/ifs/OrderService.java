package com.example.java_demo_test.service.ifs;

import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.vo.GetMenuResponse;
import com.example.java_demo_test.vo.OrderResponse;

public interface OrderService {
	
	public GetMenuResponse getMenuByName(String name); //name餐點名稱 //兩個屬性 一個menu一個message
	
	public OrderResponse addMenus(List<Menu> menuList);
	
	public OrderResponse getAllMenus();
	
	public OrderResponse order(Map< String , Integer > orderMap); //OrderResponse取代void
	
	public OrderResponse updateMenu(List<Menu> menuList);//(題目)1.只修改已存在的菜單價格2.不存在的菜單不能新增3.返回修改後的菜單名稱跟新價格

}
