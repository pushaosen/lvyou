package com.itqf.lvyou.dao.impl;

import java.util.List;
import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.itqf.lvyou.dao.UserDao;
import com.itqf.lvyou.model.User;

/**
 * @author Administrator
 *
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User, String> implements UserDao {

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void authenticate(String username, String password) {
		String hql = "from User u where u.loginName= :loginName and u.password= :password";
		List<User> users = sessionFactory.getCurrentSession().createQuery(hql, User.class)
				.setParameter("loginName", username).setParameter("password", password)
				.getResultList();
		if (users.size() != 1) {
			throw new RuntimeException("用户验证失败！");
		}
	}

	@Override
	public User getUserByLoginName(String user) {
		String hql = "from User u where u.loginName= :loginName";
		return sessionFactory.getCurrentSession().createQuery(hql,User.class).setParameter("loginName", user).uniqueResult();
	}

	@Override
	public List<User> getUsersByLoginName(String loginName, Long woPageStart, Long woPageSize) {
		String hql = "from User u where u.loginName like:loginName order by u.id";
		return sessionFactory.getCurrentSession().createQuery(hql,User.class)
				.setParameter("loginName", "%"+loginName+"%").setFirstResult(woPageStart.intValue())
				.setMaxResults(woPageSize.intValue()).getResultList();
	}

	@Override
	public Long getUserTotalByLoginName(String loginName) {
		String hql = "select count(*) from User u where u.loginName like:loginName";
		return (Long) sessionFactory.getCurrentSession().createQuery(hql).setParameter("loginName", "%"+loginName+"%").uniqueResult();
	}
}
