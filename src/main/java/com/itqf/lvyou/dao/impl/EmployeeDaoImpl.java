package com.itqf.lvyou.dao.impl;

import java.util.List;
import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.itqf.lvyou.dao.EmployeeDao;
import com.itqf.lvyou.model.Employee;

/**
 * Employee访问数据库
 * @author Administrator
 *
 */
@Repository
public class EmployeeDaoImpl extends BaseDaoImpl<Employee, String> implements EmployeeDao {

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Employee> getEmployeeList(String name, String phone, String idCard) {
		String hql = "from Employee e where e.employName like:employName and e.phone like:phone and e.idCard like:idCard ";
		return sessionFactory.getCurrentSession().createQuery(hql,Employee.class).setParameter("employName", "%"+name+"%").setParameter("phone", "%"+phone+"%").setParameter("idCard", "%"+idCard+"%").getResultList();
	}

	@Override
	public Employee findByCard(String card) {
		String hql = "from Employee e where e.card=:card";
		return sessionFactory.getCurrentSession().createQuery(hql,Employee.class).setParameter("card", card).uniqueResult();
	}

	@Override
	public Employee findByPhone(String phone) {
		String hql = "from Employee e where e.phone=:phone";
		return sessionFactory.getCurrentSession().createQuery(hql,Employee.class).setParameter("phone", phone).uniqueResult();
	}

	@Override
	public Employee findIdCard(String idCard) {
		String hql = "from Employee e where e.idCard=:idCard";
		return sessionFactory.getCurrentSession().createQuery(hql,Employee.class).setParameter("idCard", idCard).uniqueResult();
	}
}
