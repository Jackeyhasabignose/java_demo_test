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

@Repository // ��springboot�U��
public interface PersonInfoDao extends JpaRepository<PersonInfo, String> {// ����Oentity�����O�W��//�k��O�U@id����ƫ��A
	public List<PersonInfo> findAllByOrderByAgeAsc();// �۩w�q��k

	public List<PersonInfo> findByAgeGreaterThan(int age); //by�᭱�O�ݩʦW�� //�ĥ|�D//�ѼƤ��ݩʦbrequest�n��
	
	public List<PersonInfo> findByAgeLessThanEqualOrderByAgeAsc(int age);// �~�֤p�󵥩�//�n�Ƨ�//orderby**�O�H**���Ƨǻy�k//asc�O�p��jdesc�O�j��p
	
	public List<PersonInfo> findFirst3ByAgeBetweenOrderByAgeDesc(int fromAge, int toAge);  //between//�j��p
	
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThan(int anamege1, int age2);//���s��϶���or//top��first���i�H//��Ʈw%�O0��h�Ӧr��
	
	public List<PersonInfo> findByCityContaining(String str);//��Y�S�w�r�����H��T//jpa�y�k// containing=%�x%=�i�H��]�t�x���Ҧ��r�J// like = �x =�u��x�o�Ӧr
	
	public List<PersonInfo> findByAgeGreaterThanAndCityContainingOrderByAgeDesc(int age, String str);//�̫�@�D//OrderBy���g�᭱���w�O�p�ƨ�j
	
	public List<PersonInfo> doQueryByAge(int age);
	
	public List<PersonInfo> doQueryByAge(int age, int limitSize, int stratPosition);
	
	@Transactional
	public int doUpdateAgeByName(int age, String name);

	
//	@Transactional// �o��Ӧp�G�Oinsert delete update�~�n�[������
//	@Modifying
//	@Query("update PersonInfo p set p.name = :newName where p.id =:newId ")// quert�����O�r��//update entity/p�Oasp/
	@Query(value = "select * from  person_info where name = :name or city = :city", nativeQuery = true) // ��nativeQuery�e���n�[value
	public List<PersonInfo> searchByNameOrCity(@Param("name")String name,@Param("city")String city);// "" �̭��|��:�᭱���ܼ� �᭱���ܼƺٰ򥻸�entity�̼�
	
//	//1.�ھھǥ�id���X�ǥͩҿ諸�ҵ{�N�X student--->findbyid-->�o��ҵ{�N�X
//	//2.�ھ�1�o��ҵ{�N�X���X�ҵ{�Ҧ��������T�� course-->findbyids(lisa<string>ids)
//	@Query("select C from Course C where id in(select S.courseCode from Student S where id = :inputId)")
//	public List<Course> findCourseByCode(@Param("inputId")String imputId){
//		 
//	}
	
}
