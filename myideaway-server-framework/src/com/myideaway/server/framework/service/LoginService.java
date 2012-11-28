package com.myideaway.server.framework.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myideaway.server.framework.dao.mapper.PepleMappger;
import com.myideaway.server.framework.entities.Peple;

@Service("lgoinService")
public class LoginService {
	
	
	
	@Autowired
	private PepleMappger pepleMappger;
	
	public Peple login(Peple param){
		Peple peple = pepleMappger.queryPepleByNameAndPassword(param);
		return peple;
	}

}
