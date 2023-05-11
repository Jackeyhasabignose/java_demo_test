//package com.example.java_demo_test.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.java_demo_test.service.ifs.LoginService;
//import com.example.java_demo_test.vo.LoginRequest;
//import com.example.java_demo_test.vo.LoginResponse;
//
//@RestController
//public class LoginController {
//
//	@Autowired 
//	private LoginService loginService;
//	
//	@PostMapping(value = "register")
//	public LoginResponse register(@RequestBody LoginRequest request) {
//		return loginService.Register(request.getAccount(),request.getPassword(),request.getName(),request.getAge(),request.getCity());
//		
//	}
//	@PostMapping(value = "register")
//	public LoginResponse activate(@RequestBody LoginRequest request) {
//		return loginService.Activate(request.getAccount(),request.getPassword());
//		
//	}
//	@PostMapping(value = "sign_in")
//	public LoginResponse signIn(@RequestBody LoginRequest request) {
//		return loginService.signIn(request.getAccount(),request.getPassword());
//		
//	}
//	@PostMapping(value = "find_user_by_city")
//	public LoginResponse findUseByCity(@RequestBody LoginRequest request) {
//		return loginService.findUserByCity(request.getCity());
//		
//	}
//}
