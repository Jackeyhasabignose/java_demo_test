package com.example.java_demo_test.service.ifs;

import java.time.LocalDateTime;

import com.example.java_demo_test.entity.Login;
import com.example.java_demo_test.vo.LoginResponse;

public interface LoginService {

	// 註冊帳號
	public LoginResponse Register(String account, String password, String name, int age, String city);

	// 激活帳號
	public LoginResponse Activate(String account, String password);

	// 登入
	public LoginResponse signIn(String account, String password);

	// 以城市搜索使用者資料不能回傳密碼and照年齡排序
	public LoginResponse findUserByCity(String city);
}
