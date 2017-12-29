package com.itqf.lvyou.dao.impl;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.itqf.lvyou.dao.TicketTypeDao;
import com.itqf.lvyou.model.TicketType;

@Repository
public class TicketTypeDaoImpl extends BaseDaoImpl<TicketType, String> implements TicketTypeDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
