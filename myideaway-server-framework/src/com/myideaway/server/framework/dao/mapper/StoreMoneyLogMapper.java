package com.myideaway.server.framework.dao.mapper;

import java.util.HashMap;
import java.util.List;

public interface StoreMoneyLogMapper {
	public void insertlog(HashMap<String, Object> param);
	public List<HashMap<String, Object>> logList(HashMap<String, Object> param);
	public Long logListCount(Long id);
}
