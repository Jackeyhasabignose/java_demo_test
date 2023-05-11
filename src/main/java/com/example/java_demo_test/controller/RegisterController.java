package com.example.java_demo_test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.service.ifs.RegisterService;
import com.example.java_demo_test.vo.LoginRequest;
import com.example.java_demo_test.vo.LoginResponse;
import com.example.java_demo_test.vo.RegisterRequest;
import com.example.java_demo_test.vo.RegisterResponse;

@RestController
public class RegisterController {
	@Autowired
	private RegisterService registerService;

	@PostMapping(value = "register")
	public RegisterResponse register(@RequestBody RegisterRequest request) {
		return registerService.register(request.getAccount(), request.getPwd());
	}

	@PostMapping(value = "active")
	public RegisterResponse active(@RequestBody RegisterRequest request) {
		return registerService.active(request.getAccount(), request.getPwd());
	}

	@PostMapping(value = "login")
	// http �����ШD�ɱo��@��session
	public RegisterResponse login(@RequestBody RegisterRequest request, HttpSession session) {
		RegisterResponse res = registerService.login(request.getAccount(), request.getPwd());
		if (res.getMessage().equalsIgnoreCase("�n�����\")) {
			double random = Math.random() * 10000;
			int verifyCode = (int) Math.round(random);// round�|�ˤ��J
			session.setAttribute("verifyCode", verifyCode);// ����Okey�k��Ovalue // key�@�Z�Ostring
			session.setAttribute("account", request.getAccount());
			session.setAttribute("pwd", request.getPwd());
			session.setMaxInactiveInterval(60);// ���O��
			res.setSessionId(session.getId());
			res.setVerifyCode(verifyCode);

		}
		return res;

	}

	@PostMapping(value = "get_Reg_Time")
	public RegisterResponse getRegTime(@RequestBody RegisterRequest request) {
		return registerService.getRegTime(request.getAccount(), request.getPwd());
	}

	@PostMapping(value = "get_Reg_Tim1")
	public RegisterResponse getRegTime1(@RequestBody RegisterRequest request, HttpSession session) {
		String account = (String) session.getAttribute("account");
		String pwd = (String) session.getAttribute("pwd");
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new RegisterResponse("�еn��");
		}
		Integer verifyCode = (Integer) session.getAttribute("verifyCode");// if�H�Usession.getAttribute("verifyCode");�Onull����j��int
																			// �u����integer//int �S��Null
		if (verifyCode == null || verifyCode != request.getVerifyCode()) {
			return new RegisterResponse("verify code incorrect!!!");
		}
		return registerService.getRegTime(account, pwd);
	}

	@PostMapping(value = "get_Reg_Tim2")
	public RegisterResponse getRegTime2(@RequestBody RegisterRequest request, HttpSession session) {
		String account = (String) session.getAttribute("account");
		String pwd = (String) session.getAttribute("pwd");

		Integer verifyCode = (Integer) session.getAttribute("verifyCode");// if�H�Usession.getAttribute("verifyCode");�Onull����j��int

		return registerService.getRegTime2(request, account, pwd, verifyCode);
	}
}
