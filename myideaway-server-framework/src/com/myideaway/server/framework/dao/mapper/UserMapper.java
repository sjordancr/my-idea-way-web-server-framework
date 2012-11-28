package com.myideaway.server.framework.dao.mapper;

import java.util.List;

import com.myideaway.server.framework.entities.EntityUser;

/**
 * 用户DAO映射借口，直接对应mybatis的文件，方法名直接对应id值
 * @author wwp
 *
 */
public interface UserMapper {
	
	EntityUser addUser(EntityUser user);
	
	List<EntityUser> getUserList();

}
