package com.example.java_demo_test;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.java_demo_test.entity.Login;
import com.example.java_demo_test.entity.NewMenu2;
import com.example.java_demo_test.repository.LoginDao;
import com.example.java_demo_test.repository.NewMenuDao;
import com.example.java_demo_test.service.ifs.LoginService;

@SpringBootTest(classes = JavaDemoTestApplication.class)
public class NewMenuTest {

	@Autowired
	private NewMenuDao newMenuDao;
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private LoginService loginService;

	@Test
	public void addDataTest() {
		NewMenu2 um1 = new NewMenu2("fish", "¯N", 100);
		newMenuDao.saveAll(Arrays.asList(um1));
	}

//	@Test
//	public void findUserByCity() {
//		Login um1 = new Login("ggg", "d11233333@", "jack", 20, "¥x¥_", LocalDateTime.now());
//		loginService.Register(um1);
//	}
}
