package com.itqf.lvyou.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.itqf.lvyou.dao.MenuDao;
import com.itqf.lvyou.model.Menu;

/**
 * 菜单实体类访问数据接口实现类
 * @author Administrator
 *
 */
@Repository
public class MenuDaoImpl extends BaseDaoImpl<Menu, String> implements MenuDao {

	@Resource  //@Autowired(自动装配)
	private SessionFactory sessionFactory;
	
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/* 
	 * 获取顶级菜单
	 */
	@Override
	public List<Menu> getTopMenus() {
		String hql = "from Menu m where m.parent.id is null or m.parent.id='' order by m.no";
		return sessionFactory.getCurrentSession().createQuery(hql,Menu.class).getResultList();
	}

	public List<Menu> getMenusByName(String name) {
		String hql = "from Menu m where m.name like:name order by m.no";
		return sessionFactory.getCurrentSession().createQuery(hql,Menu.class).setParameter("name", "%"+name+"%").getResultList();
	}
}
