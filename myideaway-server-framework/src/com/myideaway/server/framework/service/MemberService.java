package com.myideaway.server.framework.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myideaway.server.framework.dao.mapper.MemberMapper;
import com.myideaway.server.framework.entities.MemberInfo;
import com.myideaway.server.framework.web.common.Page;
import com.myideaway.server.framework.web.common.PageUtil;
import com.sun.media.sound.HsbParser;

@Service("memberService")
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public void add(MemberInfo member){
		memberMapper.addMemberInfo(member);
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", member.getId());
		param.put("pid", member.getReferrerId());
		param.put("name", member.getLogin_name());
		memberMapper.addMemberTree(param);
	}
	
	public List<HashMap<String, Object>> list(MemberInfo memberInfo,Page page){
		
		page.setCount(memberMapper.selectMemberListCount(memberInfo));
		PageUtil.makePage(page);
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("start", page.getStart());
		param.put("onePageCount", page.getOnePageCount());
		
		return memberMapper.selectMemberList(param);
	}
	
	public boolean checkUnique(String name,Object value){
		int count = 0;
		if("referrer".equals(name)){
			count = memberMapper.checkReferrer((String)value);
		}else if("login_name".equals(name)){
			count = memberMapper.checkLoginName((String)value);
		}else if("card_id".equals(name)){
			count = memberMapper.checkCardId((String)value);
		}else if("email".equals(name)){
			count = memberMapper.checkEmail((String)value);
		}else if("bank_card_code".equals(name)){
			count = memberMapper.checkBankCardCode((String)value);
		}
		
		if(count == 0) return true;
		return false;
	}
	
	public boolean checkReferrerCanUse(Object value){
		int count = 0;
		count = memberMapper.checkReferrerCanUse((String) value);
		if(count == 0) return true;
		return false;
	}
	
	public List<HashMap<String, Object>> statistics(HashMap<String, Object> param,Page page){
		page.setCount(memberMapper.iNeedMoneyMoneyCount());
		PageUtil.makePage(page);
		
		param.put("start", page.getStart());
		param.put("onePageCount", page.getOnePageCount());
		
		return memberMapper.iNeedMoneyMoney(param);
	}
	
	public List<HashMap<String, Object>> selectCanReferrer(HashMap<String, Object> param,Page page){
		page.setCount(memberMapper.selectCanReferrerCount());
		PageUtil.makePage(page);
		
		param.put("start", page.getStart());
		param.put("onePageCount", page.getOnePageCount());
		
		return memberMapper.selectCanReferrer(param);
	}

}
