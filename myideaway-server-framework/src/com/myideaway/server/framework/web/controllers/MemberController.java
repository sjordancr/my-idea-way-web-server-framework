package com.myideaway.server.framework.web.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myideaway.server.framework.entities.MemberInfo;
import com.myideaway.server.framework.service.MemberService;
import com.myideaway.server.framework.web.common.Page;
import com.myideaway.server.framework.web.common.PageUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

@RequestMapping("/member")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/add")
	public String addMember(@ModelAttribute MemberInfo memberInfo){
		try {
			memberService.add(memberInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "memberList";
	}
	
	@RequestMapping("/list")
	public String pager(@ModelAttribute MemberInfo memberInfo,@ModelAttribute Page page,Model model){
		if( page == null){
			page = new Page();
		}
		
		model.addAttribute("page",page);
		model.addAttribute("list", memberService.list(memberInfo, page));
		return "member/memberList";
	}

}
