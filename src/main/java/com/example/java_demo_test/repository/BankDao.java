 package com.example.java_demo_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;   
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.Bank;

@Repository
public interface BankDao extends JpaRepository<Bank, String>{
	//自定義的名稱是entity的名稱 不是column 的名稱
	public Bank findByAccountAndPassword(String account , String password);
	
 
}
