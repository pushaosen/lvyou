package com.itqf.lvyou.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.itqf.lvyou.WoException;
import com.itqf.lvyou.WoResultCode;
import com.itqf.lvyou.dao.UserDao;
import com.itqf.lvyou.model.Employee;
import com.itqf.lvyou.model.Guest;
import com.itqf.lvyou.model.Role;
import com.itqf.lvyou.model.User;
import com.itqf.lvyou.service.AuthenticationService;

/**
 * @author Administrator
 *
 */
@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

	@Resource
	private UserDao userDao;
	
	private final static WoResultCode FAIL = new WoResultCode(2000, "认证失败!");
	
	private final static WoResultCode FAIL2 = new WoResultCode(2001, "该用户未关联任何数据!");
	
//	@Override
//	public User authenticate(String user, String password) {
//		User u = userDao.getUserByLoginName(user);
//		if (u == null || !u.getPassword().equals(password)) {
//			throw new WoException(FAIL);
//		}
//		return u;
//	}
	
	public Map<String, Object> authenticate(String user, String password) {
		Map<String, Object> data = new HashMap<>();
		User u = userDao.getUserByLoginName(user);
		if (u == null || !u.getPassword().equals(password)) {
			throw new WoException(FAIL);
		}
		data.put("user", u);
		if (u.isAdmin()) {
			data.put("role", Role.ADMIN);
			return data;
		}
		Guest guest = u.getGuest();
		if (guest != null) {
			data.put("role", Role.GUEST);
			data.put("guest", guest);
		}else {
			Employee e = u.getEmployee();
			if (e != null) {
				data.put("role", Role.EMPLOYEE);
				data.put("employee", e);
			}else {
				throw new WoException(FAIL2);
			}
		}
		return data;
	}

}
