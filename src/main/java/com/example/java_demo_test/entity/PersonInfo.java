package com.example.java_demo_test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //跟資料庫連接的作用
@Table(name = "person_info") //person_info要跟資料庫名字一樣//要連到資料庫的某張表
public class PersonInfo {

	@Id//主key
	@Column(name = "id")//裡面的id要跟資料庫裡的一樣
	private String id; //基本變數會跟欄位名稱一樣//這變數可以亂取
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "city")
	private String city;
	
	
	public PersonInfo(String id, String name, int age, String city) { //有參數的建構方法 記得要有空的建構方法
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
	}
	public PersonInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	
	
	
}
