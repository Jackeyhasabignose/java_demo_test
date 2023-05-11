package com.example.java_demo_test.service.ifs;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.vo.GetPersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoResponse;

public interface PersonInfoService {

	public PersonInfoResponse addPersonInfo(List<PersonInfo> personInfo);//�^�ǥ~�����F��//�����D�n�B�n�^�ǥ���void//�]���nPersonInfo�̪���줺�e�ҥH���ѼƤ�//�o�ˬO�@����Ʀ��|�����/�n�h�����ܧ令list/void�令List<PersonInfo>�O���F�^�ǭn�D�L�����/�p�G�u��List<PersonInfo>�^�Ǩ��u��^��list�κA�n��L���A�i�H�ۤv�aclass�a�ݩm
	
	public GetPersonInfoResponse getPersonInfoById(String id);
	
	public GetPersonInfoResponse getAllPersonInfo();
	
	public GetPersonInfoResponse getAllPersonInfoByAge(int age);
	
	public GetPersonInfoResponse getAllPersonInfoLessByAge(int age);
	
	public GetPersonInfoResponse getAllPersonInfoBetweenByAge(int age, int age2); 

	
	
}
