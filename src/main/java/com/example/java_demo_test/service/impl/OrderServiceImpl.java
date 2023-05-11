      package com.example.java_demo_test.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.repository.OrderDao;
import com.example.java_demo_test.service.ifs.OrderService;
import com.example.java_demo_test.vo.GetMenuResponse;
import com.example.java_demo_test.vo.OrderResponse;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public OrderResponse getAllMenus() {

		return new OrderResponse(orderDao.findAll(), "取得餐點成功");

	}

	@Override
	public OrderResponse addMenus(List<Menu> menuList) {
//		if(CollectionUtils.isEmpty(menuList)) {
//			return new OrderResponse("新增餐點錯誤");// 可以代替if(menuList == null || menuList.isEmpty()) 確認字串484null or空字串
//		}
		if (menuList == null || menuList.isEmpty()) {
			return new OrderResponse("新增餐點錯誤");// 空陣列不會進入for迴圈
		}
		for (Menu menuItem : menuList) { // 檢查錯誤
			if (!StringUtils.hasText(menuItem.getItem())) {// 檢查餐點名稱不得為空白跟空字串
				return new OrderResponse("餐點名稱不能為空白");
			}
			if (menuItem.getPrice() <= 0) {
				return new OrderResponse("餐點價格錯誤");
			}

		}
		List<Menu> response = orderDao.saveAll(menuList);// 餐點新增 list, set就是多筆 儲存所以是saveall/ dao 前面需要接東西
		return new OrderResponse(response, "新增餐點成功");

	}

	@Override
	public OrderResponse order(Map<String, Integer> orderMap) {// OrderResponse取代void//String, Integer是餐點名稱跟數量 //beef:10
//		List<String> itemList = new ArrayList<>();
//		for (Entry<String, Integer> item : orderMap.entrySet()) { // 判斷數量是否負數 是的話說錯誤 (item:orderMap 用.entryset
//																	// 搭配foreach)
//			if (item.getValue() < 0) {
//				return new OrderResponse("餐點數量錯誤!!!");
//			}
//			itemList.add(item.getKey());// getkey 指的是餐點名稱(string)
//		}
//		List<Menu> result = orderDao.findAllById(itemList); // dao前面要一個參數接回來//()裡面放你要找的東西ex itemlist//根據我的餐點名稱從資料庫撈出
//		int totalPrice = 0;// 原價
//		Map<String, Integer> finalOrderMap = new HashMap<>();// 實際上正確的餐點品項
//		for (Menu menu : result) {
//			String item = menu.getItem();// 餐點名稱1.
//			int price = menu.getPrice();
//			for (Entry<String, Integer> map : orderMap.entrySet()) {
//				String key = map.getKey(); // ordermap中的餐點名稱
//				int value = map.getValue();// ordermap中的餐點數量
//				if (item.equals(key)) {
//					int singleTotalPrice = price * value; // 價格*數量 / 要用參數接回來
//					// totalPrice = totalPrice + singleTotalPrice; 這行等於下面那行
//					totalPrice += singleTotalPrice;
//					finalOrderMap.put(key, value);
//				}
//			}
//
//		}
//
//		totalPrice = totalPrice > 500 ? (int) (totalPrice * 0.9) : totalPrice;// 大於500會打9折//打9折所以要強制轉型
//		=================
		int totalPrice = 0;
		Map<String, Integer> finalOrderMap = new HashMap<>();
		for (Entry<String, Integer> item : orderMap.entrySet()) { // 判斷數量是否負數 是的話說錯誤 (item:orderMap 用.entryset
//			// 搭配foreach)
			if (item.getValue() < 0) {
				return new OrderResponse("餐點數量錯誤!!!");
			}
			boolean bool = orderDao.existsById(item.getKey());
			if(bool) {
			 Optional<Menu> op = orderDao.findById(item.getKey());//單項是optional/多項是List
			 int p = op.get().getPrice()* item.getValue();
			 totalPrice += p;
			 finalOrderMap.put(item.getKey(), item.getValue());
			}
		}
		  
		
		return new OrderResponse(finalOrderMap,totalPrice,"新增成功"); // 回一個空的箱子

	}

	@Override
	public GetMenuResponse getMenuByName(String name) {
		if (!StringUtils.hasText(name)) {
			return new GetMenuResponse("餐點名稱錯誤");
		}
		Optional<Menu> op = orderDao.findById(name);
		if (!op.isPresent()) {
			return new GetMenuResponse("餐點不存在");
		}
		return new GetMenuResponse(op.get(), "成功");

	}

	@Override
	public OrderResponse updateMenu(List<Menu> menuList) {
		List<Menu> updateMenus = new ArrayList<>();
		for (Menu menu : menuList) {
			boolean bool = orderDao.existsById(menu.getItem());
			if (bool) {
				updateMenus.add(menu);
			}
		}
		if (updateMenus.size() == 0) {
			return new OrderResponse("查無菜單");
		}

		return new OrderResponse(orderDao.saveAll(updateMenus), "成功");

//		if (CollectionUtils.isEmpty(menuList)) {
//			return new OrderResponse("新增餐點錯誤");// 空陣列不會進入for迴圈
//		}
//		for (Menu menuItem : menuList) { // 檢查錯誤      
//			if (menuItem.getPrice() <= 0) {
//				return new OrderResponse("餐點價格錯誤");
//			}
//			if (!StringUtils.hasText(menuItem.getItem())) {// 檢查餐點名稱不得為空白跟空字串
//				return new OrderResponse("餐點名稱不能為空白");
//			}
//		}
//		List<Menu> list = orderDao.findAll();
//		for(Menu item : menuList );

	}
}