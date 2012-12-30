package com.myideaway.server.framework.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myideaway.server.framework.annotation.Pager;
import com.myideaway.server.framework.dao.mapper.MemberCheckLogMapper;
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
	
	@Autowired
	private MemberCheckLogMapper memberCheckLogMapper;
	
	public void add(MemberInfo member){
		memberMapper.addMemberInfo(member);
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", member.getId());
		param.put("name", member.getLogin_name());
		memberMapper.addMemberTree(param);
		if( member.getRecive_order_store() != null){
			Thread thread = new Thread(new MathOrderStoreMoney(member.getRecive_order_store(), member.getId(), member.getLogin_name(), memberMapper, storeMoneyLogMapper));
			thread.start();
		}
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
			memberCheckLogMapper.insertlog(id);
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
		MemberInfo memberInfo = memberMapper.selectMemberById(id);
		memberMapper.clearStoreMoney(id);
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("member_id", id);
		param.put("money", memberInfo.getOwn_money());
		param.put("flag", 0);
		storeMoneyLogMapper.insertlog(param);
	}
	
	public List<HashMap<String, Object>> moneyLogList(HashMap<String, Object> param,Page page){
		page.setCount(storeMoneyLogMapper.logListCount((Long)param.get("id")));
		PageUtil.makePage(page);
		
		param.put("start", page.getStart());
		param.put("onePageCount", page.getOnePageCount());
		return storeMoneyLogMapper.logList(param);
	}

	public void changeTypeToActive(Long id){
		memberMapper.changeTypeToActive(id);
	}
	
	public List<HashMap<String, Object>> checkLogList(HashMap<String, Object> param,Page page){
		page.setCount(memberCheckLogMapper.logListCount());
		PageUtil.makePage(page);
		
		param.put("start", page.getStart());
		param.put("onePageCount", page.getOnePageCount());
		return memberCheckLogMapper.logList(param);
	}
	
	public List<HashMap<String, Object>> query5StructTree(Long level){
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("level", level);
		return memberMapper.query5Levelstruct(param);
	}
	
	public Long queryMaxLevel(){
		return memberMapper.queryMaxLevel();
	}
}
