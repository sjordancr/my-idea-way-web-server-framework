package com.myideaway.server.framework.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.myideaway.server.framework.dao.IBaseEntityDao;

/**
 * <p>
 * Description:基础的实体数据访问对象。通过泛型进行实体映射，避免每个实体都去写dao的代码。
 * 提供给各个service使用，若您觉得基础实体dao所提供的方法不够用。您可以自行在service中使用jdbctemplate。或者通过该类的超类SqlSessionDaoSupport取得sqlsession来进行操作。
 * </p>
 * 
 * @author charles.chen on 2012-7-17
 **/
public class BaseEntityDaoImpl<T, PK extends Serializable> extends SqlSessionDaoSupport implements IBaseEntityDao<T, Serializable> {

	/*
	 * (non-Javadoc)
	 * @see
	 * com.myideaway.server.framework.dao.IBaseEntityDao#getEntityById(java.
	 * lang.String, java.io.Serializable)
	 */
	@Override
	public T getEntityById(String statementName, Serializable entityId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(statementName, entityId);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.myideaway.server.framework.dao.IBaseEntityDao#getEntityByConditions
	 * (java.lang.String, java.util.Map)
	 */
	@Override
	public T getEntityByConditions(String statementName, Map<String, ?> parameterMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(statementName, parameterMap);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.myideaway.server.framework.dao.IBaseEntityDao#getEntities(java.lang
	 * .String)
	 */
	@Override
	public List<T> getEntities(String statementName) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(statementName);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.myideaway.server.framework.dao.IBaseEntityDao#getEntities(java.lang
	 * .String, java.util.Map)
	 */
	@Override
	public List<T> getEntities(String statementName, Map<String, ?> parameterMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(statementName, parameterMap);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.myideaway.server.framework.dao.IBaseEntityDao#addEntity(java.lang
	 * .String, java.lang.Object)
	 */
	@Override
	public void addEntity(String statementName, T t) {
		// TODO Auto-generated method stub
		getSqlSession().insert(statementName, t);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.myideaway.server.framework.dao.IBaseEntityDao#updateEntity(java.lang
	 * .String, java.lang.Object)
	 */
	@Override
	public void updateEntity(String statementName, T t) {
		// TODO Auto-generated method stub
		getSqlSession().update(statementName, t);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.myideaway.server.framework.dao.IBaseEntityDao#deleteEntityById(java
	 * .lang.String, java.io.Serializable)
	 */
	@Override
	public void deleteEntityById(String statementName, Serializable entityId) {
		// TODO Auto-generated method stub
		getSqlSession().delete(statementName, entityId);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.myideaway.server.framework.dao.IBaseEntityDao#getEntityCount(java
	 * .lang.String)
	 */
	@Override
	public Integer getEntityCount(String statementName, Map<String, ?> parameterMap) {
		// TODO Auto-generated method stub
		return (Integer) getSqlSession().selectOne(statementName, parameterMap);
	}

}
