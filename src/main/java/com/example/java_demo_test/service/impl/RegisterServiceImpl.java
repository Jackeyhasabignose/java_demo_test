package com.example.java_demo_test.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Register;
import com.example.java_demo_test.repository.RegisterDao;
import com.example.java_demo_test.service.ifs.RegisterService;
import com.example.java_demo_test.vo.RegisterRequest;
import com.example.java_demo_test.vo.RegisterResponse;

public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private RegisterDao registerDao;

	@Override
	public RegisterResponse register(String account, String pwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new RegisterResponse("輸入不能為空");
		}
		// 通过账号查找用户
		Optional<Register> user = registerDao.findById(account);
		if (user.isPresent()) {
			return new RegisterResponse("帳號已存在");
		}
		// 创建新用户
		Register newUser = new Register();
		newUser.setAccount(account);
		newUser.setPwd(pwd);
		registerDao.save(newUser);
		RegisterResponse response = new RegisterResponse();
		response.setMessage("註冊成功啦"); 
		return response;
	}

	@Override
	public RegisterResponse active(String account, String pwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new RegisterResponse("輸入不能為空");
		}
		// 通过账号和密码查找用户
		Register user = registerDao.findByAccountAndPwd(account, pwd);
		if (user == null) {
			return new RegisterResponse("帳號或密碼不正確");
		}
		// 更新用户为已激活
		if (user.isActive()) {
			return new RegisterResponse("帳號已經激活");
		}
		user.setActive(true);
		registerDao.save(user);
		RegisterResponse response = new RegisterResponse();
		response.setMessage("帳號激活成功");
		return response;
	}

	@Override
	public RegisterResponse login(String account, String pwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new RegisterResponse("輸入不能為空");
		}

		Register reg = registerDao.findByAccountAndPwdAndActive(account, pwd, true);

		if (reg == null) {
			return new RegisterResponse("登陸失敗");
		}

		return new RegisterResponse("登陸成功");
	}

	@Override
	public RegisterResponse getRegTime(String account, String pwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new RegisterResponse("輸入不能為空");
		}
		Register reg = registerDao.findByAccountAndPwdAndActive(account, pwd, true);
		if (reg == null) {
			return new RegisterResponse("找不到使用者");
		}
		LocalDateTime regTime = reg.getRegTime(); // 取得註冊時間
		RegisterResponse response = new RegisterResponse();
		response.setMessage("成功取得註冊時間");
		response.setRegTime(regTime); // 將註冊時間設置至回傳物件中
		return response;
	}

	@Override
	public RegisterResponse getRegTime2(RegisterRequest request, String account, String pwd, Integer verifyCode) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new RegisterResponse("請登陸");
		}
		if (verifyCode == null || verifyCode != request.getVerifyCode()) {
			return new RegisterResponse("verify code incorrect!!!");
	}
		Register reg = registerDao.findByAccountAndPwdAndActive(account, pwd, true);
		if (reg == null) {
			return new RegisterResponse("請登陸");
		}
		return new RegisterResponse("成功",reg.getRegTime());
		
}
}