package com.example.java_demo_test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity //跟資料庫連接的作用
@Table(name = "new_menu2") //要連到資料庫的某張表
@IdClass(value = NewMenu2Id.class)
public class NewMenu2  {

	@Id//雙主key = 複合主key
	@Column(name = "category")
	private String category; 
	
	@Id//主key	
	@Column(name = "item")
	private String item; 
	
	@Column(name = "price")
	private int price;
	

	public NewMenu2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewMenu2(String category, String item, int price) {
		super();
		this.category = category;
		this.item = item;
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	} 
	
	
	
}
