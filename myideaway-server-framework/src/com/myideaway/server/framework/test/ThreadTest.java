package com.myideaway.server.framework.test;

import com.myideaway.server.framework.buffer.UserBuffer;
import com.myideaway.server.framework.entities.EntityUser;

/**
 *<p>Description:</p>
 *@author charles.chen on 2012-7-16
 **/
public class ThreadTest implements Runnable{
	private String a;
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(!a.equals("1")){
			System.out.println(UserBuffer.getInstance().get("1"));
		}else UserBuffer.getInstance().set(new EntityUser("100")); 
		
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	
}
