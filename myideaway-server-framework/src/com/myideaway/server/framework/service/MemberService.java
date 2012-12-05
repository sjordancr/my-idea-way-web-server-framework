package com.myideaway.server.framework.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myideaway.server.framework.annotation.Pager;
import com.myideaway.server.framework.dao.mapper.MemberMapper;
import com.myideaway.server.framework.dao.mapper.StoreMoneyLogMapper;
import com.myideaway.server.framework.entities.MemberInfo;
import com.myideaway.server.framework.web.common.Page;
import com.myideaway.server.framework.web.common.PageUtil;
import com.sun.media.sound.HsbParser;

@Service("memberService")
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private StoreMoneyLogMapper storeMoneyLogMapper;
	
	public void add(MemberInfo member){
		memberMapper.addMemberInfo(member);
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", member.getId());
		param.put("pid", member.getReferrerId());
		param.put("name", member.getLogin_name());
		memberMapper.addMemberTree(param);
		
		Thread thread = new Thread(new MathOrderStoreMoney(member.getRecive_order_store(), memberMapper, storeMoneyLogMapper));
		thread.start();
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
	
	public boolean check(long id){
		try {
			memberMapper.checkMember(id);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public List<HashMap<String, Object>> selectOrderStore(HashMap<String, Object> param,Page page){
		page.setCount(memberMapper.selectStoreListCount());
		PageUtil.makePage(page);
		
		param.put("start", page.getStart());
		param.put("onePageCount", page.getOnePageCount());
		
		return memberMapper.selectStoreList(param);
	}
	
	public List<HashMap<String, Object>> selectMoneyOrderStore(HashMap<String, Object> param,Page page){
		page.setCount(memberMapper.selectMoneyStoreListCount());
		PageUtil.makePage(page);
		
		param.put("start", page.getStart());
		param.put("onePageCount", page.getOnePageCount());
		
		return memberMapper.selectMoneyStoreList(param);
	}
	
	public void clearMoney(Long id){
		memberMapper.clearStoreMoney(id);
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("member_id", id);
		param.put("money", 0);
		param.put("flag", 0);
		storeMoneyLogMapper.insertlog(param);
	}
}
