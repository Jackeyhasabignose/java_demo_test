package com.example.java_demo_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.service.ifs.OrderService;
import com.example.java_demo_test.vo.GetMenuResponse;
import com.example.java_demo_test.vo.OrderRequest;
import com.example.java_demo_test.vo.OrderResponse;

import io.swagger.v3.oas.annotations.Hidden;

//import springfox.documentation.annotations.ApiIgnore;

@RestController //介面層
public class OrderController {

	@Autowired 
	private OrderService orderService;
	
	
//	@ApiIgnore //swagger用的
	@Hidden //openapi用的
	@PostMapping(value = "add_menus") //跟外部呼叫/ 貼到postman
	public OrderResponse addMenus(@RequestBody OrderRequest request) { //抓要得資訊加出來//@RequestBody對應到要的位置上
		return orderService.addMenus(request.getMenuList()); 
	}
	
	@PostMapping(value = "get_menu_by_name") //跟外部呼叫/ 貼到postman
	public GetMenuResponse getMenu(@RequestBody OrderRequest request) { //抓要得資訊加出來//@RequestBody對應到要的位置上
		return orderService.getMenuByName(request.getName()); 
	}
	
	
}
