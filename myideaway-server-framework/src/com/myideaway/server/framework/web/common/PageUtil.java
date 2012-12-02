package com.myideaway.server.framework.web.common;

public class PageUtil {

	public static Page makePage(Page page){
		long count = page.getCount();
		int pageCount = page.getOnePageCount();
		if(count > 0){
			if( count / pageCount == 0){
				page.setPageNum(1);
			}
			else{
				page.setPageNum( (count / pageCount) + (((count % pageCount) == 0)?0:1));
			}
		}
		long currentPage = page.getCurrentPage();
		
		page.setStart(currentPage == 1? 0:(currentPage - 1 )*pageCount -1);

		return page;
	}
}
