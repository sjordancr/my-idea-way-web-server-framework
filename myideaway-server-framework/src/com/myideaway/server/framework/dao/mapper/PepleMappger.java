package com.myideaway.server.framework.dao.mapper;

import java.util.HashMap;

import com.myideaway.server.framework.entities.Peple;

public interface PepleMappger {
	
	public Peple queryPepleByNameAndPassword(Peple param);
	
	public HashMap<String, Object> queryPepleById(long id);
	
	public Long checkPepleCount(String param);
	
	public Integer queryPepleChildrenById(Long id);

}
