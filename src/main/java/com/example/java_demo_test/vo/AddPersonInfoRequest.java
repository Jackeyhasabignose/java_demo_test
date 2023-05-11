package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;

public class AddPersonInfoRequest {
	
private List<PersonInfo> personInfoList;

public List<PersonInfo> getPersonInfoList() {
	return personInfoList;
}

public void setPersonInfoList(List<PersonInfo> personInfoList) {//vo像把資料帶進來
	this.personInfoList = personInfoList;
}

}
