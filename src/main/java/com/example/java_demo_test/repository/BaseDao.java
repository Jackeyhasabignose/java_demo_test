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

	@PersistenceContext // jpa專有註釋
	private EntityManager entityManager;

	@SuppressWarnings({ "unchecked" })
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz) {
		Query query = entityManager.createQuery(sql, clazz);// 第一種,比較直覺好用
		return doQuery( sql,  params,  clazz, -1);//優化 //
//		if (!CollectionUtils.isEmpty(params)) {//將相同程式碼方法抽出優化
		
//		for (Entry<String, Object> item : params.entrySet()) {
//			query.setParameter(item.getKey(), item.getValue());
//		}
//	}
//		for (Parameter p : query.getParameters()) { // 第2種方式
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
			int limitSize, int startPosition) {// 每頁的起始位置
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
			int limitSize, int startPosition) {// 每頁的起始位置
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
