package com.example.java_demo_test.controller;

import java.util.List;    

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.service.ifs.PersonInfoService;
import com.example.java_demo_test.vo.AddPersonInfoRequest;
import com.example.java_demo_test.vo.GetPersonInfoRequest;
import com.example.java_demo_test.vo.GetPersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoResponse;

@RestController
public class PersonInfoController {
	
	@Autowired
	private PersonInfoService personInfoService;//�򤺳����s��//�s������
	
	@PostMapping(value = "add_personInfo")//���~�����s��
	public PersonInfoResponse addPersonInfo(@RequestBody AddPersonInfoRequest request) {//�ƻsservice������k//���[@RequestBody�ȳ��|�Onull
		return personInfoService.addPersonInfo(request.getPersonInfoList());
	}
	
	@PostMapping(value = "get_personInfoById")// post�@��O�s�W�έק�//get�O���X��Ƭd��
	public GetPersonInfoResponse getPersonInfoById(@RequestBody GetPersonInfoRequest request) {
		return personInfoService.getPersonInfoById(request.getId());
	}
	
	@PostMapping(value = "getAllPersonInfoByAge")// post�@��O�s�W�έק�//get�O���X��Ƭd��
	public GetPersonInfoResponse getAllPersonInfoByAge(@RequestBody GetPersonInfoRequest request) {
		return personInfoService.getAllPersonInfoByAge(request.getAge());
	}
	
	@PostMapping(value = "getAllPersonInfoLessByAge")// post�@��O�s�W�έק�//get�O���X��Ƭd��
	public GetPersonInfoResponse getAllPersonInfoLessByAge(@RequestBody GetPersonInfoRequest request) {
		return personInfoService.getAllPersonInfoLessByAge(request.getAge());
	}


}
