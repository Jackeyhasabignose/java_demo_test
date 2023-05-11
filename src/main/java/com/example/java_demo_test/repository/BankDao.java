 package com.example.java_demo_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;   
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.Bank;

@Repository
public interface BankDao extends JpaRepository<Bank, String>{
	//�۩w�q���W�٬Oentity���W�� ���Ocolumn ���W��
	public Bank findByAccountAndPassword(String account , String password);
	
 
}
