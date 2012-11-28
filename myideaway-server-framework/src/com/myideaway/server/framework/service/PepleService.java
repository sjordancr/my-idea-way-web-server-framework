package com.myideaway.server.framework.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myideaway.server.framework.dao.mapper.PepleMappger;

@Service("pepleService")
public class PepleService {
	
	@Autowired
	private PepleMappger pepleMappger;
	
	public HashMap<String, Object> getPepleById(long id){
		return pepleMappger.queryPepleById(id);
	}

	public long checkPeple(String param){
		
		try {
			return pepleMappger.checkPepleCount(param);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int getPepleChildrenCount(Long id){
		return pepleMappger.queryPepleChildrenById(id);
	}
}
