package com.myideaway.server.framework.entities;


public class MemberInfo {
	
	long id;
	private String referrer;
	String receiver;
	int is_order_store;
	String login_name;
	String real_name;
	String card_id;
	String account_bank;
	String bank_card_code;
	int bank_province;
	int bank_city;
	String phone;
	String detail_addres;
	int is_check_cash;
	String store_name;
	String store_agent_address;
	String email;
	String remit_account;
	String remit_account_bank;
	String remit_datetime;
	String remit_peple;
	float remit_money;
	long referrerId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReferrer() {
		return referrer;
	}
	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public int getIs_order_store() {
		return is_order_store;
	}
	public void setIs_order_store(int is_order_store) {
		this.is_order_store = is_order_store;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getAccount_bank() {
		return account_bank;
	}
	public void setAccount_bank(String account_bank) {
		this.account_bank = account_bank;
	}
	public String getBank_card_code() {
		return bank_card_code;
	}
	public void setBank_card_code(String bank_card_code) {
		this.bank_card_code = bank_card_code;
	}
	public int getBank_province() {
		return bank_province;
	}
	public void setBank_province(int bank_province) {
		this.bank_province = bank_province;
	}
	public int getBank_city() {
		return bank_city;
	}
	public void setBank_city(int bank_city) {
		this.bank_city = bank_city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDetail_addres() {
		return detail_addres;
	}
	public void setDetail_addres(String detail_addres) {
		this.detail_addres = detail_addres;
	}
	public int getIs_check_cash() {
		return is_check_cash;
	}
	public void setIs_check_cash(int is_check_cash) {
		this.is_check_cash = is_check_cash;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getStore_agent_address() {
		return store_agent_address;
	}
	public void setStore_agent_address(String store_agent_address) {
		this.store_agent_address = store_agent_address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemit_account() {
		return remit_account;
	}
	public void setRemit_account(String remit_account) {
		this.remit_account = remit_account;
	}
	public String getRemit_account_bank() {
		return remit_account_bank;
	}
	public void setRemit_account_bank(String remit_account_bank) {
		this.remit_account_bank = remit_account_bank;
	}
	public String getRemit_datetime() {
		return remit_datetime;
	}
	public void setRemit_datetime(String remit_datetime) {
		this.remit_datetime = remit_datetime;
	}
	public String getRemit_peple() {
		return remit_peple;
	}
	public void setRemit_peple(String remit_peple) {
		this.remit_peple = remit_peple;
	}
	public float getRemit_money() {
		return remit_money;
	}
	public void setRemit_money(float remit_money) {
		this.remit_money = remit_money;
	}
	public long getReferrerId() {
		return referrerId;
	}
	public void setReferrerId(long referrerId) {
		this.referrerId = referrerId;
	}
}
