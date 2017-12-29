package com.itqf.lvyou.dao.impl;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.itqf.lvyou.dao.GuestDao;
import com.itqf.lvyou.model.Guest;

@Repository
public class GuestDaoImpl extends BaseDaoImpl<Guest, String> implements GuestDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
