package com.example.java_demo_test.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //���Ʈw�s�����@��
@Table(name = "login") //person_info�n���Ʈw�W�r�@��//�n�s���Ʈw���Y�i��

public class Login {
	
	@Id//�Dkey
	@Column(name = "account")
	private String account; 	
	@Column(name = "password")
	private String password;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "city")
	private String city;
	/* ���ͷ�U���ɶ�!!!
	 * private Date registerTime;
	 * Date ==> new Date();
	 * 
	 * private LocalDateTime registerTime;
	 * LocalDateTime==>LocalDateTime.now();
	 * 
	 * 
	 */
	@Column(name = "register_time")
	private LocalDateTime registerTime;//�ɶ����ݩ�Localdatetime!!!�O�oimport//Boolean�w�]��NULL//boolean�Ofalse �b��Ʈw�O0
	@Column(name = "active")
	private boolean isActive; //��ƫ��A�p�G�Oboolean�ܼƫe�|�[is
	
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String account, String password, String name, int age, String city,LocalDateTime registerTime) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.age = age;
		this.city = city;
		this.registerTime = registerTime;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public LocalDateTime getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(LocalDateTime registerTime) {
		this.registerTime = registerTime;
	}
	public boolean isActive() {//���Y��GET�|��is
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	
	
	
	

}
