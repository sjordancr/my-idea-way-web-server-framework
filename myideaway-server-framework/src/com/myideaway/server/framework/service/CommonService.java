package com.myideaway.server.framework.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myideaway.server.framework.dao.mapper.CommonMapper;

@Service("commonService")
public class CommonService {
	
	@Autowired
	public CommonMapper commonMapper;
	
	public List<Map<String, Object>> getTree(Map<String,Object> param){
		return commonMapper.getTree(param);
	}
	
	public List<Map<String, Object>> provinceList(){
		return commonMapper.getAllProvince();
	}
	
	public List<Map<String, Object>> cityListByProvince(long province){
		return commonMapper.getCityListByProvince(province);
	}
	
	public List<Map<String, Object>> areaListByCity(long city){
		return commonMapper.getAreaListByCity(city);
	}

}
