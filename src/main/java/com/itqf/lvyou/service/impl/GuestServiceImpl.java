package com.itqf.lvyou.service.impl;

import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.itqf.lvyou.dao.GuestDao;
import com.itqf.lvyou.dao.UserDao;
import com.itqf.lvyou.model.Guest;
import com.itqf.lvyou.model.User;
import com.itqf.lvyou.service.GuestService;

@Service
@Transactional
public class GuestServiceImpl implements GuestService {

	@Resource
	private GuestDao guestDao;
	
	@Resource
	private UserDao userDao;
	
	@Override
	public List<Guest> getAllGuest() {
		return guestDao.findAll();
	}

	@Override
	public void createGuest(Guest guest) {
		// 1、判断guest的手机号对应的用户是否存在,如果存在，则获取User，否则创建一个User
		User user = userDao.getUserByLoginName(guest.getMobile());
		if (user == null) {
			user = new User();
			user.setId(UUID.randomUUID().toString());
			user.setLoginName(guest.getMobile());
			userDao.create(user);
		} 
		guest.setUser(user);
		guestDao.create(guest);
	}

}
