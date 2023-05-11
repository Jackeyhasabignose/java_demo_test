package com.example.java_demo_test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.constants.RtnCode;
import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.repository.PersonInfoDao;
import com.example.java_demo_test.service.ifs.PersonInfoService;
import com.example.java_demo_test.vo.GetPersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoResponse;

@Service // 讓springboot託管//放類別上面//今天要找到實作內容所以放在實作不是介面//
public class PersonInfoServiceImpl implements PersonInfoService {

	@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public PersonInfoResponse addPersonInfo(List<PersonInfo> personInfoList) { // 新增的方法,資廖庫沒有的//外來的資料//list內放entity類別
		// 實作的參數近來第一件事是防呆//檢查1.是否null
		// if (personInfoList == null) {
		if (CollectionUtils.isEmpty(personInfoList)) {// 跟上一行意思一樣
			return new PersonInfoResponse(RtnCode.DATA_ERROR.getMessage());
		}
		// 檢查2.List 中的每項資訊(PersonInfo)//從list中取出每一項資訊用for
		// each//item自己設的變數//id.name.city不能null全空白字串跟空字串.age不能為負數!!!
		List<String> ids = new ArrayList<>();// 空白list
		for (PersonInfo item : personInfoList) {
			if (!StringUtils.hasText(item.getId()) || !StringUtils.hasText(item.getName())
					|| !StringUtils.hasText(item.getCity()) || item.getAge() < 0) { // 例如檢查name所以item.getname
				return new PersonInfoResponse(RtnCode.DATA_ERROR.getMessage()); // ()內容不一樣是方便讓自己知道作業時哪裡出錯//用||是因為不能有任何錯誤
			}
			// 防呆完存到資料庫//一次蒐集減少進資料庫連結,蒐集id,用空白list去蒐集id//id是主key
			ids.add(item.getId());
		}

		// 檢查新增的ids是否存在於資料庫中
		List<PersonInfo> existed = personInfoDao.findAllById(ids); // 記得接回來
		if (!existed.isEmpty()) {// 不是空的代表有同樣資料在裡面了//不用for迴圈也可以
			return new PersonInfoResponse(RtnCode.DATA_ERROR.getMessage());
		}
		List<PersonInfo> existe2 = personInfoDao.saveAll(personInfoList);
		return new PersonInfoResponse(RtnCode.SUCCESSFFUL.getMessage(), existe2);
	}

	@Override
	public GetPersonInfoResponse getPersonInfoById(String id) {
		if (!StringUtils.hasText(id)) {
			return new GetPersonInfoResponse(RtnCode.DATA_ERROR.getMessage());
		}
		Optional<PersonInfo> op = personInfoDao.findById(id); // findbyid會用op
		if (!op.isPresent()) {
			return new GetPersonInfoResponse(RtnCode.DATA_ERROR.getMessage());
		}
		PersonInfo ot = op.get();
		return new GetPersonInfoResponse(op.get(),RtnCode.SUCCESSFFUL.getMessage());

	}

	@Override
	public GetPersonInfoResponse getAllPersonInfo() {
		List<PersonInfo> list = personInfoDao.findAll();
		return new GetPersonInfoResponse(RtnCode.SUCCESSFFUL.getMessage(), list);
	}

	@Override
	public GetPersonInfoResponse getAllPersonInfoByAge(int age) {
		List<PersonInfo> ids = new ArrayList<>();
		List<PersonInfo> list = personInfoDao.findAll();
		for (PersonInfo item : list) {
			if (item.getAge() >= age) {
				ids.add(item);
			}   

		}
		if (ids.isEmpty()) {// 沒資料
			return new GetPersonInfoResponse(RtnCode.DATA_ERROR.getMessage());

		}
		return new GetPersonInfoResponse(RtnCode.SUCCESSFFUL.getMessage(), ids);

	}

	@Override 
	public GetPersonInfoResponse getAllPersonInfoLessByAge(int age) {
		List<PersonInfo> ids = new ArrayList<>();
		List<PersonInfo> op = personInfoDao.findAllByOrderByAgeAsc();
		for (PersonInfo item : op) {
			if (item.getAge() <= age) {
				ids.add(item);
			}   

		}
		if (ids.isEmpty()) {// 沒資料
			return new GetPersonInfoResponse(RtnCode.DATA_ERROR.getMessage());

		}
		return new GetPersonInfoResponse(RtnCode.SUCCESSFFUL.getMessage(), ids);
		
	}

	

	@Override
	public GetPersonInfoResponse getAllPersonInfoBetweenByAge(int age, int age2) {
		// TODO Auto-generated method stub
		return null;
	}
	
}