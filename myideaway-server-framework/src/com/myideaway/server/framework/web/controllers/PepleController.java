package com.myideaway.server.framework.web.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myideaway.server.framework.service.PepleService;

@Controller
@RequestMapping("/peple")
public class PepleController {
	
	@Autowired
	private PepleService pepleService;
	
	@RequestMapping("/getPepleInfo")
	@ResponseBody
	public Object getPeple(@RequestParam long id){
		
		return pepleService.getPepleById(id);
	}
	
	@RequestMapping("/checkConnectPeple")
	@ResponseBody
	public Object checkConnectPeple(@RequestParam String connect_peple){
		HashMap<String, Object> resultHashMap = new HashMap<String, Object>();
		resultHashMap.put("id", pepleService.checkPeple(connect_peple));
		return resultHashMap;
		
	}
	
	@RequestMapping("/getPepleChildrenCount")
	@ResponseBody
	public Object getPepleChildrenCount(@RequestParam Long id){
		HashMap<String, Object> resultHashMap = new HashMap<String, Object>();
		resultHashMap.put("id", pepleService.getPepleChildrenCount(id));
		return resultHashMap;
		
	}

}
