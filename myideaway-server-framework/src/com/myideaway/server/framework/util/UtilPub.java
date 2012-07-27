package com.myideaway.server.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * <p>
 * Description:公共工具类，提供了字符串、集合、日期等对象的判断转换工具，在项目工程中根据需要可不断增加。
 * </p>
 * 
 * @author charles.chen on 2012-7-16
 **/
public class UtilPub {
	public static boolean isStrEmpty(String str) {
		return "".equals(str) || null == str;
	}

	public static boolean isStrNotEmpty(String str) {
		return !"".equals(str) && null != str;
	}

	public static boolean isCollectionEmpty(Collection<?> collection) {
		return null == collection || collection.size() == 0;
	}

	public static boolean isCollectionNotEmpty(Collection<?> collection) {
		return null != collection && collection.size() > 0;
	}

	public static String getDateStr(Date date, String regex) {
		return new SimpleDateFormat(regex).format(date);
	}

	public static Date parseStrToDate(String str, String regex) throws ParseException {
		return new SimpleDateFormat(regex).parse(str);
	}

	public static String getEntityStatementNamePath(Class<?> classes) {
		return classes.getName() + ".";
	}
}
