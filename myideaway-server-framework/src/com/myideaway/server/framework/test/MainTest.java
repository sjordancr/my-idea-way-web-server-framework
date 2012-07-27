package com.myideaway.server.framework.test;

import com.myideaway.server.framework.buffer.UserBuffer;

/**
 *<p>Description:</p>
 *@author charles.chen on 2012-7-16
 **/
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserBuffer.getInstance();
		Thread thread;
		ThreadTest tt ;
		for(int i=0;i<2;i++){
			tt = new ThreadTest();
			if(i==0){
				tt.setA("1") ;
			}else {
				tt.setA("2") ;
			}
			thread = new Thread(tt);
			thread.start();
		}
	}

}
