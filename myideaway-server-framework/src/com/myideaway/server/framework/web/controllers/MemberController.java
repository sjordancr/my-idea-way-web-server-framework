package com.myideaway.server.framework.web.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myideaway.server.framework.entities.MemberInfo;
import com.myideaway.server.framework.service.MemberService;
import com.myideaway.server.framework.web.common.Page;

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
		
		return "redirect:list.action";
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
	
	@RequestMapping(value="/checkUnique", method=RequestMethod.POST)
	@ResponseBody
	public Object checkUnique(@RequestParam String name,@RequestParam String value){
		HashMap<String, Boolean> result = new HashMap<String, Boolean>();
		result.put("unique", memberService.checkUnique(name, value));
		return result;
	}
	
	public Object checkReferrer(@RequestParam String value){
		HashMap<String, Boolean> result = new HashMap<String, Boolean>();
		result.put("canUse", memberService.checkReferrerCanUse(value));
		return result;
	}

}
