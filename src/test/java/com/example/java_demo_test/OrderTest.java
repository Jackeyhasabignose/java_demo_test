package com.example.java_demo_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.repository.PersonInfoDao;
import com.example.java_demo_test.service.ifs.OrderService;
import com.example.java_demo_test.vo.OrderResponse;

@SpringBootTest(classes = JavaDemoTestApplication.class)
public class OrderTest {

	@Autowired
	private OrderService orderService;
	@Autowired
	private PersonInfoDao personInfoDao;

	@Test
	public void addMenusTest() {
		List<Menu> list = new ArrayList<>();
		OrderResponse response = orderService.addMenus(list);
		List<Menu> responseList = response.getMenuList();
		Assert.isTrue(responseList != null, "新增餐點錯誤");

	}

//	@Test
//	public void updateNameByIdTest() {
//		int result = personInfoDao.updateNameById("A01", "金城武");
//		System.out.println(result);
//	}

}
