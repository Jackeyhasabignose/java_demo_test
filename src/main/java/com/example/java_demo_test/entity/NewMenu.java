package com.example.java_demo_test.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity //跟資料庫連接的作用
@Table(name = "new_menu") //person_info要跟資料庫名字一樣//要連到資料庫的某張表
public class NewMenu {
	
	@Id//主key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//因為seq是自動增長的序號所以加這行//seq要是1-5筆刪除三筆再繼續新增的話下次新增的是第6筆資料//if新增第6筆在刪掉再新增的畫下一筆會是第7筆不是地6筆
	@Column(name = "seq")// seq是自動增長的序號
	private int seq; 
	@Column(name = "category")
	private String category; 	
	@Column(name = "item")
	private String item; 
	@Column(name = "price")
	private int price;
	@Type(type = "uuid-char")
	@Column(name = "uuid")
	private UUID uuid = UUID.randomUUID(); //UUID 類別是UUID//IMPORThibernate這個//= UUID.randomUUID()這是給他預設值即使欄位內部給他還是會產生
	
	
	public NewMenu() { 
		super();
		// TODO Auto-generated constructor stub
	}
	public NewMenu(String category, String item, int price, UUID uuid) {
		super();
		this.category = category;
		this.item = item;
		this.price = price;
		this.uuid = uuid;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	} 
	
	
	

}
