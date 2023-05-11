package com.example.java_demo_test.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entity.PersonInfo;

public class PersonInfoDaoImpl extends BaseDao {

	public List<PersonInfo> doQueryByAge(int age) {
		StringBuffer sb = new StringBuffer(); // �r��ۥ[//createnativequery �~�i�H�������Ʈw�ާ@//createquery �z�Lentity
		sb.append("select P from PersonInfo P where P.age   >=:age");
		Map<String, Object> params = new HashMap<>();
		params.put("age", age);// :��᭱����,�a2��age�O int age
		return doQuery(sb.toString(), params, PersonInfo.class);// .class�O�]�����W�nclass �j��
	}

	public List<PersonInfo> doQueryByAge(int age, int limitSize) {
		StringBuffer sb = new StringBuffer(); // �r��ۥ[//createnativequery �~�i�H�������Ʈw�ާ@//createquery �z�Lentity
		sb.append("select P from PersonInfo P where P.age   >=:age");
		Map<String, Object> params = new HashMap<>();
		params.put("age", age);// :��᭱����,�a2��age�O int age
		return doQuery(sb.toString(), params, PersonInfo.class, limitSize);// .class�O�]�����W�nclass �j��
	}

	public List<PersonInfo> doQueryByAge(int age, int limitSize, int startPosition) {
		StringBuffer sb = new StringBuffer(); // �r��ۥ[//createnativequery �~�i�H�������Ʈw�ާ@//createquery �z�Lentity
		sb.append("select P from PersonInfo P where P.age   >=:age");
		Map<String, Object> params = new HashMap<>();
		params.put("age", age);// :��᭱����,�a2��age�O int age
		return doQuery(sb.toString(), params, PersonInfo.class, limitSize, startPosition);// .class�O�]�����W�nclass �j��
	}
	public int doUpdateAgeByName(int age, String name) {
		StringBuffer sb = new StringBuffer();
		sb.append("update PersonInfo set age = :age where name = :name");
		Map<String, Object> params = new HashMap<>();
		params.put("age", age);
		params.put("name", name);
		return doUpdate(sb.toString(), params);
		
		
	}

}
