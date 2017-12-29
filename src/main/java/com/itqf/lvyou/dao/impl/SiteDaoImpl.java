package com.itqf.lvyou.dao.impl;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.itqf.lvyou.dao.SiteDao;
import com.itqf.lvyou.model.Site;

@Repository
public class SiteDaoImpl extends BaseDaoImpl<Site, String> implements SiteDao {

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Site getSiteByName(String name) {
		String hql = "from Site s where s.name =:name";
		return sessionFactory.getCurrentSession().createQuery(hql,Site.class).setParameter("name", name).uniqueResult();
	}
}
