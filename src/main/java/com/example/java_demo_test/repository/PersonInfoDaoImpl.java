package com.example.java_demo_test.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entity.PersonInfo;

public class PersonInfoDaoImpl extends BaseDao {

	public List<PersonInfo> doQueryByAge(int age) {
		StringBuffer sb = new StringBuffer(); // 字串相加//createnativequery 才可以直接對資料庫操作//createquery 透過entity
		sb.append("select P from PersonInfo P where P.age   >=:age");
		Map<String, Object> params = new HashMap<>();
		params.put("age", age);// :放後面的詞,地2個age是 int age
		return doQuery(sb.toString(), params, PersonInfo.class);// .class是因為指名要class 強調
	}

	public List<PersonInfo> doQueryByAge(int age, int limitSize) {
		StringBuffer sb = new StringBuffer(); // 字串相加//createnativequery 才可以直接對資料庫操作//createquery 透過entity
		sb.append("select P from PersonInfo P where P.age   >=:age");
		Map<String, Object> params = new HashMap<>();
		params.put("age", age);// :放後面的詞,地2個age是 int age
		return doQuery(sb.toString(), params, PersonInfo.class, limitSize);// .class是因為指名要class 強調
	}

	public List<PersonInfo> doQueryByAge(int age, int limitSize, int startPosition) {
		StringBuffer sb = new StringBuffer(); // 字串相加//createnativequery 才可以直接對資料庫操作//createquery 透過entity
		sb.append("select P from PersonInfo P where P.age   >=:age");
		Map<String, Object> params = new HashMap<>();
		params.put("age", age);// :放後面的詞,地2個age是 int age
		return doQuery(sb.toString(), params, PersonInfo.class, limitSize, startPosition);// .class是因為指名要class 強調
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
