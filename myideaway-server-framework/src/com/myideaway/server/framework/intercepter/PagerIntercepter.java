package com.myideaway.server.framework.intercepter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.myideaway.server.framework.annotation.Pager;
import com.myideaway.server.framework.web.common.Page;

public class PagerIntercepter extends HandlerInterceptorAdapter {
	
	public static String KEY_PAGER = "pager";

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("aftercompletion..............");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, org.springframework.web.servlet.ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle..............");
		Page page = (Page) arg0.getAttribute(KEY_PAGER);
		Method[] method = arg2.getClass().getMethods();
		for(Method m:method){
			System.out.println(m.getName());
			Annotation annotation = m.getAnnotation(Pager.class);
			System.out.println(annotation);
		}
		System.out.println(arg2.getClass().getMethods());
		if( null == page){
			page = new Page();
			arg0.setAttribute(KEY_PAGER, page);
		}
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		
		System.out.println("preHandle..............");
		System.out.println(arg2.toString());
		return true;
	}

}
