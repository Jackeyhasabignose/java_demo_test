package com.example.java_demo_test.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.entity.Login;

@Repository
public interface LoginDao extends JpaRepository<Login, String> {
	  Optional<Login> findByAccount(String account);
	public List<Login> findByCityOrderByAgeDesc(String city);
}
