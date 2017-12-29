package com.itqf.lvyou.service.impl;

import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.itqf.lvyou.dao.UserDao;
import com.itqf.lvyou.model.PageBean;
import com.itqf.lvyou.model.User;
import com.itqf.lvyou.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Override
	public String login(String username, String password) {
		if (username.equals("admin") && password.equals("123456")) {
			return "登录成功！！！";
		}
		return "用户名和密码不符合！！！";
	}

	@Override
	public void authenticate(String username, String password) {
		userDao.authenticate(username, password);
	}

	@Override
	public List<User> getUsers() {
		return userDao.findAll();
	}

	@Override
	public void createUser(User user) {
		userDao.create(user);
	}

	@Override
	public PageBean<User> getUsersByLoginName(String loginName, Long woPageStart, Long woPageSize){
		PageBean<User> pg = new PageBean<User>();
		if (StringUtils.isEmpty(loginName)) {
			// return userDao.getUsers();
			loginName = "";
		}
		// 设置分页列表数据
		pg.setList(userDao.getUsersByLoginName(loginName, woPageStart, woPageSize));
		// 设置总数量
		pg.setTotal(userDao.getUserTotalByLoginName(loginName));
		return pg;
	}

	@Override
	public User getUsersById(String userId) {
		return userDao.findById(userId);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	public void deleteUsers(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			User user = this.getUsersById(ids[i]);
			userDao.delete(user);
		}
	}

	@Override
	public void importUsers(List<User> users) {
		for(User user:users) {
			this.createUser(user);;
		}
	}

	@Override
	public Long getCountUsersByName(String loginName) {
		if(loginName == null) {
			loginName = "";
		}
		return userDao.getUserTotalByLoginName(loginName);
	}
}
