package com.example.java_demo_test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.repository.PersonInfoDao;

@SpringBootTest(classes = JavaDemoTestApplication.class)
public class PersonInfoTest {
	@Autowired
	public PersonInfoDao personInfoDao;

	@Test
	public void doQueryByAge() {
		List<PersonInfo> res = personInfoDao.doQueryByAge(30);
		System.out.println(res.size());

	}

	@Test
	public void doQueryByAgeTest() {
		int res = personInfoDao.doUpdateAgeByName(30, "ª÷«°ªZ");
		System.out.println(res);

	}

	@Test
	public void searchByNameOrCity() {
		List<PersonInfo> res = personInfoDao.searchByNameOrCity(null, null);
		System.out.println(res.size());

	}

}
