package com.example.java_demo_test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //���Ʈw�s�����@��
@Table(name = "person_info") //person_info�n���Ʈw�W�r�@��//�n�s���Ʈw���Y�i��
public class PersonInfo {

	@Id//�Dkey
	@Column(name = "id")//�̭���id�n���Ʈw�̪��@��
	private String id; //���ܼƷ|�����W�٤@��//�o�ܼƥi�H�è�
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "city")
	private String city;
	
	
	public PersonInfo(String id, String name, int age, String city) { //���Ѽƪ��غc��k �O�o�n���Ū��غc��k
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
