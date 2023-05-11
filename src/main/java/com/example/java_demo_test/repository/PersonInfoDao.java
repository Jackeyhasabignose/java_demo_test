package com.example.java_demo_test.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.java_demo_test.entity.Menu;  
import com.example.java_demo_test.entity.PersonInfo;

@Repository // 讓springboot託管
public interface PersonInfoDao extends JpaRepository<PersonInfo, String> {// 左邊是entity的類別名稱//右邊是下@id的資料型態
	public List<PersonInfo> findAllByOrderByAgeAsc();// 自定義方法

	public List<PersonInfo> findByAgeGreaterThan(int age); //by後面是屬性名稱 //第四題//參數內屬性在request要有
	
	public List<PersonInfo> findByAgeLessThanEqualOrderByAgeAsc(int age);// 年齡小於等於//要排序//orderby**是以**做排序語法//asc是小到大desc是大到小
	
	public List<PersonInfo> findFirst3ByAgeBetweenOrderByAgeDesc(int fromAge, int toAge);  //between//大到小
	
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThan(int anamege1, int age2);//不連續區間用or//top跟first都可以//資料庫%是0到多個字元
	
	public List<PersonInfo> findByCityContaining(String str);//找某特定字的哥人資訊//jpa語法// containing=%台%=可以找包含台的所有字彙// like = 台 =只找台這個字
	
	public List<PersonInfo> findByAgeGreaterThanAndCityContainingOrderByAgeDesc(int age, String str);//最後一題//OrderBy不寫後面內定是小排到大
	
	public List<PersonInfo> doQueryByAge(int age);
	
	public List<PersonInfo> doQueryByAge(int age, int limitSize, int stratPosition);
	
	@Transactional
	public int doUpdateAgeByName(int age, String name);

	
//	@Transactional// 這兩個如果是insert delete update才要加的標籤
//	@Modifying
//	@Query("update PersonInfo p set p.name = :newName where p.id =:newId ")// quert內都是字串//update entity/p是asp/
	@Query(value = "select * from  person_info where name = :name or city = :city", nativeQuery = true) // 用nativeQuery前面要加value
	public List<PersonInfo> searchByNameOrCity(@Param("name")String name,@Param("city")String city);// "" 裡面會放:後面的變數 後面的變數稱基本跟entity依樣
	
//	//1.根據學生id撈出學生所選的課程代碼 student--->findbyid-->得到課程代碼
//	//2.根據1得到課程代碼撈出課程所有相關的訊息 course-->findbyids(lisa<string>ids)
//	@Query("select C from Course C where id in(select S.courseCode from Student S where id = :inputId)")
//	public List<Course> findCourseByCode(@Param("inputId")String imputId){
//		 
//	}
	
}
