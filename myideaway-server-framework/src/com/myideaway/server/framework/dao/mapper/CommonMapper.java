package com.myideaway.server.framework.dao.mapper;

import java.util.List;
import java.util.Map;

public interface CommonMapper {

	public List<Map<String, Object>> getTree(Map<String, Object> param);
	public List<Map<String, Object>> getAllProvince();
	public List<Map<String, Object>> getCityListByProvince(long province);
	public List<Map<String, Object>> getAreaListByCity(long city);
}
