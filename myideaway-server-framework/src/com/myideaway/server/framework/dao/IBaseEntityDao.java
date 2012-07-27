package com.myideaway.server.framework.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Description: 基础的实体数据库访问接口，提供基本的实体操作方法。
 * </p>
 * 
 * @author charles.chen on 2012-7-16
 **/
public interface IBaseEntityDao<T, PK extends Serializable> {
	/**
	 * 根据实体主键ID得到某个实体对象
	 * 
	 * @param statementName
	 * @param entityId
	 * @return
	 */
	public T getEntityById(String statementName, PK entityId);

	/**
	 * 根据多个条件得到某个实体对象
	 * 
	 * @param statementName
	 * @param parameterMap
	 * @return
	 */
	public T getEntityByConditions(String statementName, Map<String, ?> parameterMap);

	/**
	 * 得到实体兑现集合
	 * 
	 * @param statementName
	 * @return
	 */
	public List<T> getEntities(String statementName);

	/**
	 * 根据特定条件得到实体对象集合
	 * 
	 * @param statementName
	 * @param parameterMap
	 * @return
	 */
	public List<T> getEntities(String statementName, Map<String, ?> parameterMap);

	/**
	 * 增加一个实体
	 * 
	 * @param statementName
	 * @param t
	 */
	public void addEntity(String statementName, T t);

	/**
	 * 修改一个实体
	 * 
	 * @param statementName
	 * @param t
	 */
	public void updateEntity(String statementName, T t);

	/**
	 * 删除一个实体
	 * 
	 * @param statementName
	 * @param entityId
	 */
	public void deleteEntityById(String statementName, PK entityId);

	/**
	 * 得到某个实体对象总数
	 * 
	 * @param statementName
	 * @return
	 */
	public Integer getEntityCount(String statementName, Map<String, ?> parameterMap);
}
