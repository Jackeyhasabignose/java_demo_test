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

		return new OrderResponse(orderDao.findAll(), "���o�\�I���\");

	}

	@Override
	public OrderResponse addMenus(List<Menu> menuList) {
//		if(CollectionUtils.isEmpty(menuList)) {
//			return new OrderResponse("�s�W�\�I���~");// �i�H�N��if(menuList == null || menuList.isEmpty()) �T�{�r��484null or�Ŧr��
//		}
		if (menuList == null || menuList.isEmpty()) {
			return new OrderResponse("�s�W�\�I���~");// �Ű}�C���|�i�Jfor�j��
		}
		for (Menu menuItem : menuList) { // �ˬd���~
			if (!StringUtils.hasText(menuItem.getItem())) {// �ˬd�\�I�W�٤��o���ťո�Ŧr��
				return new OrderResponse("�\�I�W�٤��ର�ť�");
			}
			if (menuItem.getPrice() <= 0) {
				return new OrderResponse("�\�I������~");
			}

		}
		List<Menu> response = orderDao.saveAll(menuList);// �\�I�s�W list, set�N�O�h�� �x�s�ҥH�Osaveall/ dao �e���ݭn���F��
		return new OrderResponse(response, "�s�W�\�I���\");

	}

	@Override
	public OrderResponse order(Map<String, Integer> orderMap) {// OrderResponse���Nvoid//String, Integer�O�\�I�W�ٸ�ƶq //beef:10
//		List<String> itemList = new ArrayList<>();
//		for (Entry<String, Integer> item : orderMap.entrySet()) { // �P�_�ƶq�O�_�t�� �O���ܻ����~ (item:orderMap ��.entryset
//																	// �f�tforeach)
//			if (item.getValue() < 0) {
//				return new OrderResponse("�\�I�ƶq���~!!!");
//			}
//			itemList.add(item.getKey());// getkey �����O�\�I�W��(string)
//		}
//		List<Menu> result = orderDao.findAllById(itemList); // dao�e���n�@�ӰѼƱ��^��//()�̭���A�n�䪺�F��ex itemlist//�ھڧڪ��\�I�W�ٱq��Ʈw���X
//		int totalPrice = 0;// ���
//		Map<String, Integer> finalOrderMap = new HashMap<>();// ��ڤW���T���\�I�~��
//		for (Menu menu : result) {
//			String item = menu.getItem();// �\�I�W��1.
//			int price = menu.getPrice();
//			for (Entry<String, Integer> map : orderMap.entrySet()) {
//				String key = map.getKey(); // ordermap�����\�I�W��
//				int value = map.getValue();// ordermap�����\�I�ƶq
//				if (item.equals(key)) {
//					int singleTotalPrice = price * value; // ����*�ƶq / �n�ΰѼƱ��^��
//					// totalPrice = totalPrice + singleTotalPrice; �o�浥��U������
//					totalPrice += singleTotalPrice;
//					finalOrderMap.put(key, value);
//				}
//			}
//
//		}
//
//		totalPrice = totalPrice > 500 ? (int) (totalPrice * 0.9) : totalPrice;// �j��500�|��9��//��9��ҥH�n�j���૬
//		=================
		int totalPrice = 0;
		Map<String, Integer> finalOrderMap = new HashMap<>();
		for (Entry<String, Integer> item : orderMap.entrySet()) { // �P�_�ƶq�O�_�t�� �O���ܻ����~ (item:orderMap ��.entryset
//			// �f�tforeach)
			if (item.getValue() < 0) {
				return new OrderResponse("�\�I�ƶq���~!!!");
			}
			boolean bool = orderDao.existsById(item.getKey());
			if(bool) {
			 Optional<Menu> op = orderDao.findById(item.getKey());//�涵�Ooptional/�h���OList
			 int p = op.get().getPrice()* item.getValue();
			 totalPrice += p;
			 finalOrderMap.put(item.getKey(), item.getValue());
			}
		}
		  
		
		return new OrderResponse(finalOrderMap,totalPrice,"�s�W���\"); // �^�@�ӪŪ��c�l

	}

	@Override
	public GetMenuResponse getMenuByName(String name) {
		if (!StringUtils.hasText(name)) {
			return new GetMenuResponse("�\�I�W�ٿ��~");
		}
		Optional<Menu> op = orderDao.findById(name);
		if (!op.isPresent()) {
			return new GetMenuResponse("�\�I���s�b");
		}
		return new GetMenuResponse(op.get(), "���\");

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
			return new OrderResponse("�d�L���");
		}

		return new OrderResponse(orderDao.saveAll(updateMenus), "���\");

//		if (CollectionUtils.isEmpty(menuList)) {
//			return new OrderResponse("�s�W�\�I���~");// �Ű}�C���|�i�Jfor�j��
//		}
//		for (Menu menuItem : menuList) { // �ˬd���~      
//			if (menuItem.getPrice() <= 0) {
//				return new OrderResponse("�\�I������~");
//			}
//			if (!StringUtils.hasText(menuItem.getItem())) {// �ˬd�\�I�W�٤��o���ťո�Ŧr��
//				return new OrderResponse("�\�I�W�٤��ର�ť�");
//			}
//		}
//		List<Menu> list = orderDao.findAll();
//		for(Menu item : menuList );

	}
}