package com.myideaway.server.framework.dao.mapper;

import java.util.HashMap;
import java.util.List;

import com.myideaway.server.framework.entities.MemberInfo;


public interface MemberMapper {
	
	public void addMemberInfo(MemberInfo member);

	public List<MemberInfo> selectMemberList(HashMap<String, Object> memberInfo);
	public Long selectMemberListCount(MemberInfo memberInfo);
}
