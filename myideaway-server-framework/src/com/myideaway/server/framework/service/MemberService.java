package com.myideaway.server.framework.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myideaway.server.framework.dao.mapper.MemberMapper;
import com.myideaway.server.framework.entities.MemberInfo;
import com.myideaway.server.framework.web.common.Page;
import com.myideaway.server.framework.web.common.PageUtil;

@Service("memberService")
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public void add(MemberInfo member){
		memberMapper.addMemberInfo(member);
	}
	
	public List<MemberInfo 
	> list(MemberInfo memberInfo,Page page){
		
		page.setCount(memberMapper.selectMemberListCount(memberInfo));
		PageUtil.makePage(page);
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("start", page.getStart());
		param.put("onePageCount", page.getOnePageCount());
		
		return memberMapper.selectMemberList(param);
	}

}
