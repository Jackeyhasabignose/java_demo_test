package com.example.java_demo_test.service.ifs;

import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.vo.GetMenuResponse;
import com.example.java_demo_test.vo.OrderResponse;

public interface OrderService {
	
	public GetMenuResponse getMenuByName(String name); //name�\�I�W�� //����ݩ� �@��menu�@��message
	
	public OrderResponse addMenus(List<Menu> menuList);
	
	public OrderResponse getAllMenus();
	
	public OrderResponse order(Map< String , Integer > orderMap); //OrderResponse���Nvoid
	
	public OrderResponse updateMenu(List<Menu> menuList);//(�D��)1.�u�ק�w�s�b��������2.���s�b����椣��s�W3.��^�ק�᪺���W�ٸ�s����

}
