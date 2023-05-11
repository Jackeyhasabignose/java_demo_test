package com.example.java_demo_test.service.ifs;

import java.time.LocalDateTime;

import com.example.java_demo_test.entity.Login;
import com.example.java_demo_test.vo.LoginResponse;

public interface LoginService {

	// ���U�b��
	public LoginResponse Register(String account, String password, String name, int age, String city);

	// �E���b��
	public LoginResponse Activate(String account, String password);

	// �n�J
	public LoginResponse signIn(String account, String password);

	// �H�����j���ϥΪ̸�Ƥ���^�ǱK�Xand�Ӧ~�ֱƧ�
	public LoginResponse findUserByCity(String city);
}
