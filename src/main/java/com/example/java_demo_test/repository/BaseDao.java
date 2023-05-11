package com.example.java_demo_test.repository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.CollectionUtils;

public class BaseDao {

	@PersistenceContext // jpa�M������
	private EntityManager entityManager;

	@SuppressWarnings({ "unchecked" })
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz) {
		Query query = entityManager.createQuery(sql, clazz);// �Ĥ@��,�����ı�n��
		return doQuery( sql,  params,  clazz, -1);//�u�� //
//		if (!CollectionUtils.isEmpty(params)) {//�N�ۦP�{���X��k��X�u��
		
//		for (Entry<String, Object> item : params.entrySet()) {
//			query.setParameter(item.getKey(), item.getValue());
//		}
//	}
//		for (Parameter p : query.getParameters()) { // ��2�ؤ覡
//			query.setParameter(p, params.get(p.getName()));
//		}
		

	}

	@SuppressWarnings({ "unchecked" })
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz,
			int limitSize) {
		Query query = entityManager.createQuery(sql, clazz);
		return doQuery( sql,  params,  clazz, limitSize, -1);
//		if (!CollectionUtils.isEmpty(params)) {
//			for (Entry<String, Object> item : params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
//		}
//		if (limitSize > 0) {
//			query.setMaxResults(limitSize);
//			return query.getResultList();
//		}
		
	}

	@SuppressWarnings({ "unchecked" })
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz,
			int limitSize, int startPosition) {// �C�����_�l��m
		Query query = null;
		if(clazz == null) {
			query = entityManager.createQuery(sql);			
		}else {
			query = entityManager.createQuery(sql, clazz);			

		}
		if (!CollectionUtils.isEmpty(params)) {
			for (Entry<String, Object> item : params.entrySet()) {
				query.setParameter(item.getKey(), item.getValue());
			}
		}
		if (limitSize > 0) {
			query.setMaxResults(limitSize);
	   
		}
		if(startPosition>=0) {
			query.setMaxResults(startPosition);
		}
		return query.getResultList();
	}
	protected int doUpdate(String sql, Map<String, Object> params) {
		Query query = entityManager.createQuery(sql);
		if (!CollectionUtils.isEmpty(params)) {
			for (Entry<String, Object> item : params.entrySet()) {
				query.setParameter(item.getKey(), item.getValue());
			}
		}
		return query.executeUpdate();
	}
	@SuppressWarnings({ "unchecked" })
	protected <EntityType> List<EntityType> doNativeQuery(String sql, Map<String, Object> params, Class<EntityType> clazz,
			int limitSize, int startPosition) {// �C�����_�l��m
		Query query = entityManager.createNativeQuery(sql , clazz);  
		if (!CollectionUtils.isEmpty(params)) {
			for (Entry<String, Object> item : params.entrySet()) {
				query.setParameter(item.getKey(), item.getValue());
			}
		}
		if (limitSize > 0) {
			query.setMaxResults(limitSize);
	   
		}
		if(startPosition>=0) {
			query.setMaxResults(startPosition);
		}
		return query.getResultList();
	}
}
