package com.myideaway.server.framework.entities;

public class Message {
	
	private boolean success;
	private String message;
	public Message(boolean success,String messag){
		this.success = success;
		this.message = messag;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
