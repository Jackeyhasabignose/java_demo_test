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
	private PersonInfoService personInfoService;//跟內部的連接//連接介面
	
	@PostMapping(value = "add_personInfo")//給外部的連接
	public PersonInfoResponse addPersonInfo(@RequestBody AddPersonInfoRequest request) {//複製service介面方法//不加@RequestBody值都會是null
		return personInfoService.addPersonInfo(request.getPersonInfoList());
	}
	
	@PostMapping(value = "get_personInfoById")// post一般是新增或修改//get是拿出資料查詢
	public GetPersonInfoResponse getPersonInfoById(@RequestBody GetPersonInfoRequest request) {
		return personInfoService.getPersonInfoById(request.getId());
	}
	
	@PostMapping(value = "getAllPersonInfoByAge")// post一般是新增或修改//get是拿出資料查詢
	public GetPersonInfoResponse getAllPersonInfoByAge(@RequestBody GetPersonInfoRequest request) {
		return personInfoService.getAllPersonInfoByAge(request.getAge());
	}
	
	@PostMapping(value = "getAllPersonInfoLessByAge")// post一般是新增或修改//get是拿出資料查詢
	public GetPersonInfoResponse getAllPersonInfoLessByAge(@RequestBody GetPersonInfoRequest request) {
		return personInfoService.getAllPersonInfoLessByAge(request.getAge());
	}


}
