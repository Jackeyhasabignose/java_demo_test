 package com.example.java_demo_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;   
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.Bank;

@Repository
public interface BankDao extends JpaRepository<Bank, String>{
	//╀쯹퇽ず쫁붙촑entityず쫁붙 ㄳ촑column ず쫁붙
	public Bank findByAccountAndPassword(String account , String password);
	
 
}
