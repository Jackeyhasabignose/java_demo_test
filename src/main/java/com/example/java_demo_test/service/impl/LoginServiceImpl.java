package com.example.java_demo_test.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Login;
import com.example.java_demo_test.repository.LoginDao;
import com.example.java_demo_test.service.ifs.LoginService;
import com.example.java_demo_test.vo.LoginResponse;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;

	@Override
	public LoginResponse Register(String account, String password, String name, int age, String city) {
		// 防呆：登录信息为空
		if (account == null || password == null) {
			return new LoginResponse("登录信息为空");
		}

		// 防呆：账号不符合要求

		if (account == null || account.length() < 3 || account.length() > 8 || account.contains(" ")) {
			return new LoginResponse("账号不符合要求");
		}

		// 防呆：密码不符合要求

		if (password == null || password.isEmpty() || !password.matches(".*[!@#$%^&*()].*") || password.contains(" ")) {
			return new LoginResponse("密码不符合要求");
		}

		// 防呆：该用户已存在
		if (loginDao.findByAccount(account).isPresent()) {
			return new LoginResponse("该用户已存在");
		}

		// 注册成功，将登录信息添加到数据库中
		Login login = new Login(account, password, name, age, city, LocalDateTime.now());

		loginDao.save(login);
		return new LoginResponse("注册成功");
	}

	@Override
	public LoginResponse Activate(String account, String password) {
		// 防呆：登录信息为空
		if (account == null||password == null) {
			return new LoginResponse("登陸信息为空");
		}

		// 防呆：账号不符合要求
		
		if (account == null || account.length() < 3 || account.length() > 8 || account.contains(" ")) {
			return new LoginResponse("账号不符合要求");
		}

		// 从数据库中查找该账号
		Optional<Login> optionalLogin = loginDao.findByAccount(account);
		if (!optionalLogin.isPresent()) {
			return new LoginResponse("该用户不存在");
		}

		Login dbLogin = optionalLogin.get();

		// 防呆：账号已激活
		if (dbLogin.isActive()) {
			return new LoginResponse("该用户已激活");
		}

		// 激活账号
		dbLogin.setActive(true);// 對物件屬性修改用set
		loginDao.save(dbLogin);

		return new LoginResponse("激活成功");
	}

	@Override
	public LoginResponse signIn(String account, String password) {
		// 防呆
		if (account == null||password == null) {
			return new LoginResponse("請輸入帳號和密碼");
		}

		// 確認資料庫有帳號
		Optional<Login> optionalLogin = loginDao.findByAccount(account);
		if (!optionalLogin.isPresent()) {
			return new LoginResponse("此帳號不存在");
		}

		// 確認狀態是激活
		Login dbLogin = optionalLogin.get();
		if (!dbLogin.isActive()) {
			return new LoginResponse("此帳號未激活");
		}

		// 登入
		if (!dbLogin.getPassword().equals(password)) {
			return new LoginResponse("密碼錯誤");
		} else {
			return new LoginResponse("登入成功");
		}
	}

	@Override
	public LoginResponse findUserByCity(String city) {
		// 確認登入資訊中城市不為空白
		if (!StringUtils.hasText(city)) {
			return new LoginResponse("City cannot be empty");
		}

		// 查詢符合城市的使用者資料，並依照年齡遞減排序
		List<Login> users = loginDao.findByCityOrderByAgeDesc(city);
		List<Login> newList = new ArrayList<>();
		for (Login item : users) {
			item.setPassword("xxx");
			newList.add(item);
		}
		// 將查詢結果轉換為 LoginResponse 物件返回
		return new LoginResponse( "Found users", newList);
	}

	
}
