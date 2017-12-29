package com.itqf.lvyou.dao.impl;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.itqf.lvyou.dao.SceneDao;
import com.itqf.lvyou.model.Scene;

@Repository
public class SceneDaoImpl extends BaseDaoImpl<Scene, String> implements SceneDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
