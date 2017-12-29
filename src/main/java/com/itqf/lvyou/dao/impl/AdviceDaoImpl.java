package com.itqf.lvyou.dao.impl;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.itqf.lvyou.dao.AdviceDao;
import com.itqf.lvyou.model.Advice;

@Repository
public class AdviceDaoImpl extends BaseDaoImpl<Advice, String> implements AdviceDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
