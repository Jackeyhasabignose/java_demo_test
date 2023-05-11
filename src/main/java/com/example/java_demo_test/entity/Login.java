package com.example.java_demo_test.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //跟資料庫連接的作用
@Table(name = "login") //person_info要跟資料庫名字一樣//要連到資料庫的某張表

public class Login {
	
	@Id//主key
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
	/* 產生當下的時間!!!
	 * private Date registerTime;
	 * Date ==> new Date();
	 * 
	 * private LocalDateTime registerTime;
	 * LocalDateTime==>LocalDateTime.now();
	 * 
	 * 
	 */
	@Column(name = "register_time")
	private LocalDateTime registerTime;//時間的屬性Localdatetime!!!記得import//Boolean預設值NULL//boolean是false 在資料庫是0
	@Column(name = "active")
	private boolean isActive; //資料型態如果是boolean變數前會加is
	
	
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
	public boolean isActive() {//布琳的GET會變is
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	
	
	
	

}
