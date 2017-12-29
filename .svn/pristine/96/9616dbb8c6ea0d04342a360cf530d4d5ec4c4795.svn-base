package com.itqf.lvyou.service;

import java.util.List;

import com.itqf.lvyou.model.PageBean;
import com.itqf.lvyou.model.User;

public interface UserService {

	//用于用户登录
	public abstract String login(String username,String password);
	
	public abstract void authenticate(String username,String password);

	/**
	 * 查询全部用户
	 * @return
	 */
	public abstract List<User> getUsers();

	/**
	 * 创建用户
	 * @param user
	 */
	public abstract void createUser(User user);

	/**
	 * 按照用户名查找用户实现分页
	 * @param loginName
	 * @param woPageSize 
	 * @param woPageStart 
	 * @return
	 */
	public abstract PageBean<User> getUsersByLoginName(String loginName, Long woPageStart, Long woPageSize);

	/**
	 * 根据用户ID查询用户
	 * @param userId
	 * @return
	 */
	public abstract User getUsersById(String userId);

	/**
	 * 修改用户信息
	 * @param user
	 */
	public abstract void updateUser(User user);

	/**
	 * 删除用户
	 * @param ids
	 */
	public abstract void deleteUsers(String[] ids);

	/**
	 * 使用POI批量导入数据
	 * @param users
	 */
	public abstract void importUsers(List<User> users);

	/**
	 * 按照用户名查询所有用户总量
	 * @param loginName
	 * @return
	 */
	public abstract Long getCountUsersByName(String loginName);
}
