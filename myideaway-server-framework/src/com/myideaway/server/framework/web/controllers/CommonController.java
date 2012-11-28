package com.myideaway.server.framework.web.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myideaway.server.framework.service.CommonService;

@Controller
@RequestMapping("/common")
public class CommonController {
	
	@Autowired
	private CommonService commonService;
	
	@RequestMapping(value="/treeJson")
	@ResponseBody
	public Object tree(@RequestParam String id){
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		return commonService.getTree(param);
	}

}
