package com.example.java_demo_test.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity //���Ʈw�s�����@��
@Table(name = "new_menu") //person_info�n���Ʈw�W�r�@��//�n�s���Ʈw���Y�i��
public class NewMenu {
	
	@Id//�Dkey
	@GeneratedValue(strategy = GenerationType.IDENTITY)//�]��seq�O�۰ʼW�����Ǹ��ҥH�[�o��//seq�n�O1-5���R���T���A�~��s�W���ܤU���s�W���O��6�����//if�s�W��6���b�R���A�s�W���e�U�@���|�O��7�����O�a6��
	@Column(name = "seq")// seq�O�۰ʼW�����Ǹ�
	private int seq; 
	@Column(name = "category")
	private String category; 	
	@Column(name = "item")
	private String item; 
	@Column(name = "price")
	private int price;
	@Type(type = "uuid-char")
	@Column(name = "uuid")
	private UUID uuid = UUID.randomUUID(); //UUID ���O�OUUID//IMPORThibernate�o��//= UUID.randomUUID()�o�O���L�w�]�ȧY����줺�����L�٬O�|����
	
	
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
