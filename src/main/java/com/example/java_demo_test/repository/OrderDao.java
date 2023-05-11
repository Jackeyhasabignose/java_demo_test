package com.example.java_demo_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.Menu;
@Repository
public interface OrderDao extends JpaRepository< Menu , String >{ //左邊是model 代表主題右邊是主key的性質本身比較沒有重複性/左邊一班是類別右邊是主key性質
//public Menu findByName(String name);
}
