package com.itqf.lvyou.dao.impl;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.itqf.lvyou.dao.RoleDao;
import com.itqf.lvyou.model.Role;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role, String> implements RoleDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
