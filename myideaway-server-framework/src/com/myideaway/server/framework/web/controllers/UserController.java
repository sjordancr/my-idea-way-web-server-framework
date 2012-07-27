package com.myideaway.server.framework.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.myideaway.server.framework.entities.EntityUser;
import com.myideaway.server.framework.service.EntityUserService;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author charles.chen on 2012-7-18
 **/
@Controller
public class UserController {
	@Autowired
	private EntityUserService service;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("user")EntityUser user, BindingResult result) {
		service.addUser(user);
		return "redirect:editUser.action";
	}
	
	@RequestMapping("/editUser")
	public ModelAndView showUser() {
		return new ModelAndView("user/user_edit", "command", new EntityUser());
	}
}
