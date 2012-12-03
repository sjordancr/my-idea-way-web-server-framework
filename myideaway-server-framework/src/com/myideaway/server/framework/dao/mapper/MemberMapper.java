package com.myideaway.server.framework.dao.mapper;

import java.util.HashMap;
import java.util.List;

import com.myideaway.server.framework.entities.MemberInfo;


public interface MemberMapper {
	
	public void addMemberInfo(MemberInfo member);

	public List<HashMap<String, Object>> selectMemberList(HashMap<String, Object> memberInfo);
	public Long selectMemberListCount(MemberInfo memberInfo);
	public int checkReferrer(String value);
	public int checkLoginName(String value);
	public int checkCardId(String value);
	public int checkEmail(String value);
	public int checkBankCardCode(String value);
	public int checkReferrerCanUse(String value);
	public void addMemberTree(HashMap<String, Object> param);
	public List<HashMap<String, Object>> iNeedMoneyMoney(HashMap<String, Object> param);
	public Long iNeedMoneyMoneyCount();
	public List<HashMap<String, Object>> selectCanReferrer(HashMap<String, Object> param);
	public Long selectCanReferrerCount();
	public void checkMember(long id);
}
