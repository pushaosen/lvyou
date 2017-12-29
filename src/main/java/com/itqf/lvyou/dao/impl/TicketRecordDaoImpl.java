package com.itqf.lvyou.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.itqf.lvyou.dao.TicketRecordDao;
import com.itqf.lvyou.model.TicketRecord;

@Repository
public class TicketRecordDaoImpl extends BaseDaoImpl<TicketRecord, String> implements TicketRecordDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
