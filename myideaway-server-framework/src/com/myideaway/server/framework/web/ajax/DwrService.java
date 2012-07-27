package com.myideaway.server.framework.web.ajax;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.spring.SpringCreator;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;

import com.myideaway.server.framework.service.EntityUserService;

/**
 * <p>
 * Description:dwr ajax实现类，您可以将远程调用方法全部写在其中。交由spring管理。
 * 只需要在方法前注明@RemoteMethod即可。
 * 若要使用您的service，请直接用@Autowired注入进来。若不够。可以直接使用jdbcTemplate
 * </p>
 * 
 * @author charles.chen on 2012-7-17
 **/

@RemoteProxy(creator = SpringCreator.class)
public class DwrService {
	@Autowired
	private EntityUserService service;
//	@Autowired
//	private JdbcTemplate jdbcTemplate;

	@RemoteMethod
	public void deleteUser(String userId) {
		service.deleteUser(userId);
	}

}
