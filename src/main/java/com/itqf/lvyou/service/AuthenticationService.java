package com.itqf.lvyou.service;

import java.util.Map;

/**
 * @author Administrator
 *
 */
public interface AuthenticationService {

	/**
	 * @param user
	 * @param password
	 * @return
	 */
	public abstract Map<String, Object> authenticate(String user,String password);
	
}
