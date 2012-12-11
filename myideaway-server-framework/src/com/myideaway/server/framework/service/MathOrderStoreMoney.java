package com.myideaway.server.framework.service;

import java.math.BigDecimal;
import java.util.HashMap;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import com.myideaway.server.framework.constant.Constant;
import com.myideaway.server.framework.dao.mapper.MemberMapper;
import com.myideaway.server.framework.dao.mapper.StoreMoneyLogMapper;
import com.myideaway.server.framework.entities.MemberInfo;

public class MathOrderStoreMoney implements Runnable{
	
	public MathOrderStoreMoney(Long reciveOrderStore,Long memberId,String memberName, MemberMapper memberMapper,StoreMoneyLogMapper storeMoneyLogMapper){
		this.reciveOrderStore = reciveOrderStore;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberMapper = memberMapper;
		this.storeMoneyLogMapper = storeMoneyLogMapper;
	}
	private Long reciveOrderStore;
	private Long memberId;
	private MemberMapper memberMapper;
	private StoreMoneyLogMapper storeMoneyLogMapper;
	private String memberName;
	
	public void run(){
		MemberInfo memberInfo = memberMapper.selectMemberById(reciveOrderStore);
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", reciveOrderStore);
		param.put("from_member_id",this.memberId);
		param.put("from_member_name", this.memberName);
		if( Constant.OrderLevel.Provice == memberInfo.getStore_level()){
			int money = new BigDecimal("20").multiply(new BigDecimal("6")).add(new BigDecimal(new Integer(memberInfo.getOwn_money()).toString())).intValue();
			param.put("money", money);
			memberMapper.updateMemberMoney(param);
			param.put("member_id", param.get("id"));
			param.put("flag", "1");
			param.put("money",120);
			storeMoneyLogMapper.insertlog(param);
			
		}else if( Constant.OrderLevel.City == memberInfo.getStore_level()){
			int money = new BigDecimal("20").multiply(new BigDecimal("5")).add(new BigDecimal(new Integer(memberInfo.getOwn_money()).toString())).intValue();
			param.put("money", money);
			param.put("member_id", param.get("id"));
			param.put("flag", "1");
			memberMapper.updateMemberMoney(param);
			
			param.put("money", 100);
			storeMoneyLogMapper.insertlog(param);
			
			//查询市上面的省代理
			param.put("cityID", memberInfo.getArea_level_id());
			param.put("from_member_id", memberInfo.getId());
			param.put("from_member_name", memberInfo.getLogin_name());
			memberInfo = memberMapper.selectProvinceStore(param);
			if(memberInfo != null){
				money = new BigDecimal("20").multiply(new BigDecimal("1")).add(new BigDecimal(new Integer(memberInfo.getOwn_money()).toString())).intValue();
				param.put("money", money);
				param.put("id", memberInfo.getId());
				memberMapper.updateMemberMoney(param);
				param.put("money", 20);
				param.put("member_id", param.get("id"));
				
				storeMoneyLogMapper.insertlog(param);
			}
			
		}else if(Constant.OrderLevel.Area == memberInfo.getStore_level()){
			int money = new BigDecimal("20").multiply(new BigDecimal("4")).add(new BigDecimal(new Integer(memberInfo.getOwn_money()).toString())).intValue();
			param.put("money", money);
			memberMapper.updateMemberMoney(param);
			param.put("member_id", param.get("id"));
			param.put("flag", "1");
			
			param.put("money", 80);
			storeMoneyLogMapper.insertlog(param);
			
			
			param.put("areaID", memberInfo.getArea_level_id());
			param.put("from_member_id", memberInfo.getId());
			param.put("from_member_name", memberInfo.getLogin_name());
			memberInfo = memberMapper.selectCityStore(param);
			if(memberInfo != null){
				money = new BigDecimal("20").multiply(new BigDecimal("1")).add(new BigDecimal(new Integer(memberInfo.getOwn_money()).toString())).intValue();
				param.put("money", money);
				param.put("id", memberInfo.getId());
				memberMapper.updateMemberMoney(param);
				param.put("member_id", param.get("id"));
				
				param.put("money", 20);
				storeMoneyLogMapper.insertlog(param);
				
				param.put("cityID", memberInfo.getArea_level_id());
				param.put("from_member_id", memberInfo.getId());
				param.put("from_member_name", memberInfo.getLogin_name());
				memberInfo = memberMapper.selectProvinceStore(param);
				if(memberInfo != null){
					money = new BigDecimal("20").multiply(new BigDecimal("1")).add(new BigDecimal(new Integer(memberInfo.getOwn_money()).toString())).intValue();
					param.put("money", money);
					param.put("id", memberInfo.getId());
					memberMapper.updateMemberMoney(param);
					
					param.put("money", 20);
					param.put("member_id", param.get("id"));
					storeMoneyLogMapper.insertlog(param);
				}
			}
		}
	}

	public MemberMapper getMemberMapper() {
		return memberMapper;
	}

	public void setMemberMapper(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

}
