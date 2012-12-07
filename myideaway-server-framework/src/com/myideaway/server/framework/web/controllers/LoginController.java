package com.myideaway.server.framework.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myideaway.server.framework.entities.Message;
import com.myideaway.server.framework.entities.Peple;
import com.myideaway.server.framework.service.LoginService;

@Controller

public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login")
	@ResponseBody
	public Object login(HttpServletRequest request,@ModelAttribute("peple") Peple peple){
		Peple result = loginService.login(peple);
		if(null == result){
			return new Message(false,"用户名密码错误");
		}
		else{
			request.getSession().setAttribute("peple", result);
			request.getSession().setAttribute("pepleType", result.getType());
			return new Message(true, "");
		}
	}

}
