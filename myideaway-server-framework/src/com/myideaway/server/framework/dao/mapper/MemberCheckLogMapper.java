package com.myideaway.server.framework.dao.mapper;

import java.util.HashMap;
import java.util.List;

public interface MemberCheckLogMapper {

	public void insertlog(Long id);
	public List<HashMap<String, Object>> logList(HashMap<String, Object> param);
	public Long logListCount();
}
