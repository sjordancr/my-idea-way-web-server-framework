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

import com.myideaway.server.framework.dao.mapper.StoreMoneyLogMapper;
import com.myideaway.server.framework.entities.MemberInfo;
import com.myideaway.server.framework.service.MathOrderStoreMoney;
import com.myideaway.server.framework.service.MemberService;
import com.myideaway.server.framework.web.common.Page;

@RequestMapping("/member")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/addPage")
	public String addPage(){
		return "member/addMember";
	}
	
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
	
	@RequestMapping("/statistics")
	public String statistics(@ModelAttribute Page page,Model model){
		if( page == null){
			page = new Page();
		}
		
		model.addAttribute("page",page);
		model.addAttribute("list", memberService.statistics(new HashMap<String, Object>(), page));
		return "member/statisticsMember";
	}
	
	@RequestMapping("/canReferrer")
	public String canReferrer(@ModelAttribute Page page,Model model){
		if( page == null){
			page = new Page();
		}
		
		model.addAttribute("page",page);
		model.addAttribute("list", memberService.selectCanReferrer(new HashMap<String, Object>(), page));
		return "member/referrer";
	}
	
	@RequestMapping("/check")
	public String check(@RequestParam long id){
		memberService.check(id);
		return "redirect:statistics.action";
	}
	
	@RequestMapping("/orderStoreList")
	public String orderStoreList(@ModelAttribute Page page,Model model){
		if( page == null){
			page = new Page();
		}
		
		model.addAttribute("page",page);
		model.addAttribute("list", memberService.selectOrderStore(new HashMap<String, Object>(), page));
		return "member/orderStoreList";
	}
	
	@RequestMapping("/moneyOrderStoreList")
	public String MoneyOrderStoreList(@ModelAttribute Page page,Model model){
		if( page == null){
			page = new Page();
		}
		
		model.addAttribute("page",page);
		model.addAttribute("list", memberService.selectMoneyOrderStore(new HashMap<String, Object>(), page));
		return "member/statisticsOrderStore";
	}
	
	@RequestMapping("/storeCheck")
	public String storeCheck(@RequestParam Long id){
		
		memberService.clearMoney(id);
		
		return "redirect:moneyOrderStoreList.action";
	}
	
	@RequestMapping("/logList")
	public String logList(@RequestParam Long id,@ModelAttribute Page page,Model model){
		if( page == null){
			page = new Page();
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		model.addAttribute("page",page);
		model.addAttribute("list", memberService.moneyLogList(param, page));
		return "member/logList";
	}
	
	@RequestMapping("/queryCheckLog")
	public String queryCheckLog(@ModelAttribute Page page,Model model){
		if( page == null){
			page = new Page();
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		
		model.addAttribute("page",page);
		model.addAttribute("list", memberService.checkLogList(param, page));
		return "member/memberCheckLogList";
	}
	
	@RequestMapping("/structTree")
	@ResponseBody
	public Object query5LevelMemberInfo(@RequestParam Long level){
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		result.put("list", memberService.query5StructTree(level));
		result.put("maxlevel", memberService.queryMaxLevel());
		return result;
	}
	
}
