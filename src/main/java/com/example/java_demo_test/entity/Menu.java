package com.example.java_demo_test.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity// for���
@Table(name = "menu")
public class Menu {
	@Id
	@Column(name = "item")
	private String item;
	@Column(name = "price")
	private int price;
	
	
	
	public Menu(String item, int price) {
		super();
		this.item = item;
		this.price = price;
		
		
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
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

