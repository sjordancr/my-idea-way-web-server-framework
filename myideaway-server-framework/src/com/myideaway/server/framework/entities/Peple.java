package com.myideaway.server.framework.entities;

import java.io.Serializable;

public class Peple implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1006038976091838047L;
	private long t_peple_info_id;
	private String name;
	private String connect_peple;
	private float own_money;
	private int own_peple;
	private float pay_money;
	private String emailString;
	private String password;
	
	
	public long getT_peple_info_id() {
		return t_peple_info_id;
	}
	public void setT_peple_info_id(long t_peple_info_id) {
		this.t_peple_info_id = t_peple_info_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConnect_peple() {
		return connect_peple;
	}
	public void setConnect_peple(String connect_peple) {
		this.connect_peple = connect_peple;
	}
	public float getOwn_money() {
		return own_money;
	}
	public void setOwn_money(float own_money) {
		this.own_money = own_money;
	}
	public int getOwn_peple() {
		return own_peple;
	}
	public void setOwn_peple(int own_peple) {
		this.own_peple = own_peple;
	}
	public float getPay_money() {
		return pay_money;
	}
	public void setPay_money(float pay_money) {
		this.pay_money = pay_money;
	}
	public String getEmailString() {
		return emailString;
	}
	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
