package com.example.java_demo_test.service.ifs;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.vo.GetPersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoResponse;

public interface PersonInfoService {

	public PersonInfoResponse addPersonInfo(List<PersonInfo> personInfo);//回傳外部的東西//不知道要步要回傳先打void//因為要PersonInfo裡的欄位內容所以放到參數中//這樣是一筆資料有四個欄位/要多筆的話改成list/void改成List<PersonInfo>是為了回傳要求過的資料/如果只有List<PersonInfo>回傳那只能回傳list形態要其他型態可以自己家class家屬姓
	
	public GetPersonInfoResponse getPersonInfoById(String id);
	
	public GetPersonInfoResponse getAllPersonInfo();
	
	public GetPersonInfoResponse getAllPersonInfoByAge(int age);
	
	public GetPersonInfoResponse getAllPersonInfoLessByAge(int age);
	
	public GetPersonInfoResponse getAllPersonInfoBetweenByAge(int age, int age2); 

	
	
}
