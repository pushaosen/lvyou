package com.itqf.lvyou.dao;

import java.util.List;

import com.itqf.lvyou.model.User;

/**
 * @author Administrator
 *
 */
public interface UserDao extends BaseDao<User, String> {

	/**
	 * @param username
	 * @param password
	 */
	public abstract void authenticate(String username,String password);

	/**
	 * 通过登录名获取用户
	 * @param user
	 * @return
	 */
	public abstract User getUserByLoginName(String user);

	/**
	 * 按照用户名进行模糊查询用户列表
	 * @param loginName
	 * @param woPageSize 
	 * @param woPageStart 
	 * @return
	 */
	public abstract List<User> getUsersByLoginName(String loginName, Long woPageStart, Long woPageSize);

	/**
	 * 按照用户登录名查询总数量
	 * @param loginName
	 * @return
	 */
	public abstract Long getUserTotalByLoginName(String loginName);
	
}
