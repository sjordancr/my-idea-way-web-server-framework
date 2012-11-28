package com.myideaway.server.framework.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myideaway.server.framework.dao.IBaseEntityDao;
import com.myideaway.server.framework.dao.mapper.UserMapper;
import com.myideaway.server.framework.entities.EntityUser;
import com.myideaway.server.framework.util.Pager;
import com.myideaway.server.framework.util.UUIDGenerator;
import com.myideaway.server.framework.util.UtilPub;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author charles.chen on 2012-7-17
 **/
@Service
public class EntityUserService {
	@Autowired
	private IBaseEntityDao<EntityUser, String> dao;
	
	@Autowired
	private UserMapper userMapper;

	// @Autowired
	// private JdbcTemplate jdbcTemplate;

	public void addUser(EntityUser user) {
		user.setEntityId(UUIDGenerator.generate());
		user.setCreateDate(new Date());
		dao.addEntity(UtilPub.getEntityStatementNamePath(EntityUser.class) + "addUser", user);
	}

	public void deleteUser(String userId) {
		dao.deleteEntityById(UtilPub.getEntityStatementNamePath(EntityUser.class) + "deleteUser", userId);
	}

	public void updateUser(EntityUser user) {
		dao.updateEntity(UtilPub.getEntityStatementNamePath(EntityUser.class) + "updateUser", user);
	}

	public List<EntityUser> getUserList(int limit, int offset) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put(Pager.RECORD_LIMIT, limit);
		parameters.put(Pager.RECORD_OFFSET, offset);
		return dao.getEntities(UtilPub.getEntityStatementNamePath(EntityUser.class) + "getUserListPager", parameters);
	}

	public List<EntityUser> getUserList() {
		List<EntityUser> list = userMapper.getUserList();
		return list;
	}

	public int getUserCount() {
		return dao.getEntityCount(UtilPub.getEntityStatementNamePath(EntityUser.class) + "getUserCount", null);
	}

}
