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

@RestController //�����h
public class OrderController {

	@Autowired 
	private OrderService orderService;
	
	
//	@ApiIgnore //swagger�Ϊ�
	@Hidden //openapi�Ϊ�
	@PostMapping(value = "add_menus") //��~���I�s/ �K��postman
	public OrderResponse addMenus(@RequestBody OrderRequest request) { //��n�o��T�[�X��//@RequestBody������n����m�W
		return orderService.addMenus(request.getMenuList()); 
	}
	
	@PostMapping(value = "get_menu_by_name") //��~���I�s/ �K��postman
	public GetMenuResponse getMenu(@RequestBody OrderRequest request) { //��n�o��T�[�X��//@RequestBody������n����m�W
		return orderService.getMenuByName(request.getName()); 
	}
	
	
}
