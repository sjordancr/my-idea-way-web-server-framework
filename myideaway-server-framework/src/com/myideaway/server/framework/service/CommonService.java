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

}
