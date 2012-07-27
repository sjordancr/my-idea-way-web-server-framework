package com.myideaway.server.framework.buffer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.myideaway.server.framework.dao.IBaseEntityDao;
import com.myideaway.server.framework.entities.EntityUser;
import com.myideaway.server.framework.util.UtilPub;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author charles.chen on 2012-7-16
 **/
public class UserBuffer {
	private static IBaseEntityDao<EntityUser, String> dao;
	private static UserBuffer instance = null;
	private Map<String, EntityUser> userListFromBuffer = null;
	private ReadWriteLock rwLock = null;

	public static UserBuffer getInstance() {
		if (instance == null) {
			instance = new UserBuffer();
			try {
				instance.initBuffer();
			} catch (Exception e) {
				instance = null;
				e.printStackTrace();
			}
		}
		return instance;
	}

	private UserBuffer() {
		userListFromBuffer = new ConcurrentHashMap<String, EntityUser>();
		rwLock = new ReentrantReadWriteLock();
	}

	private void initBuffer() {
		List<EntityUser> userList = dao.getEntities(UtilPub.getEntityStatementNamePath(EntityUser.class) + "getUserList");
		if(UtilPub.isCollectionNotEmpty(userList)){
			for(EntityUser user : userList){
				userListFromBuffer.put(user.getEntityId(), user);
			}
		}
	}

	public EntityUser get(String key) {
		try {
			rwLock.readLock().lock();
			EntityUser value = userListFromBuffer.get(key);
			return value;
		} finally {
			rwLock.readLock().unlock();
		}
	}

	public void set(EntityUser user) {
		try {
			rwLock.writeLock().lock();
			userListFromBuffer.put(user.getEntityId(), user);
		} finally {
			rwLock.writeLock().unlock();
		}
	}

	public void remove(EntityUser user) {
		try {
			rwLock.writeLock().lock();
			userListFromBuffer.remove(user.getEntityId());
		} finally {
			rwLock.writeLock().unlock();
		}
	}

	public void update(EntityUser user) {
		remove(user);
		set(user);
	}

	public IBaseEntityDao<EntityUser, String> getDao() {
		return dao;
	}

	public void setDao(IBaseEntityDao<EntityUser, String> dao) {
		UserBuffer.dao = dao;
	}
	
	
}
