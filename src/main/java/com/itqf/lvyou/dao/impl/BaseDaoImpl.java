package com.itqf.lvyou.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.itqf.lvyou.dao.BaseDao;
import com.itqf.lvyou.model.PageBean;

@SuppressWarnings("all")
public abstract class BaseDaoImpl<E, K extends Serializable> implements BaseDao<E, K> {

	/**
	 * 获取session的抽象方法
	 * 
	 * @return
	 */
	public abstract Session getSession();

	/**
	 * 泛型的具体类型，为实体类
	 */
	private Class<?> entityClass;

	/**
	 * entityClass的名字(无包路径)，为实体类名称
	 */
	private String entityName;

	public BaseDaoImpl() {
		// 获取泛型的参数类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		// 获取第一泛型参数作为实体类的类型
		entityClass = (Class<?>) pt.getActualTypeArguments()[0];
		// 获取实体类名称
		entityName = entityClass.getName();
	}

	@Override
	public E findById(K id) {
		return (E) getSession().get(entityClass, id);
	}

	public void create(E entity) {
		getSession().persist(entity);
	}

	public List<E> findAll() {
		String hql = "from " + entityName;
		return (List<E>) getSession().createQuery(hql, entityClass).getResultList();
	}

	public void update(E entity) {
		getSession().merge(entity);
	}

	public void delete(E entity) {
		getSession().delete(entity);
	}

	public List<E> findBy(Map<String, Object> proValues) {
		// 构造hql
		String hql = "from " + entityName + " e where ";
		// 构造hql中的where
		String wh = "";
		// 遍历proValues，设置where条件
		for (String propName : proValues.keySet()) {
			if (!"".equals(wh)) {
				wh += " and ";
			}
			// hql的参数设置不允许有"."符号，故采用下划线替换参数名称中的"."
			wh += "e." + propName + "=:" + propName.replace('.', '_');
		}
		hql = hql + wh;
		// 构造query
		Query query = getSession().createQuery(hql, entityClass);
		// 遍历proValues，设置where条件
		for (String propName : proValues.keySet()) {
			// hql的参数设置不允许有"."符号，故采用下划线替换参数名称中的"."
			query.setParameter(propName.replace('.', '_'), proValues.get(propName));
		}
		return query.getResultList();
	}

	public List<E> findBy(String propName, Object propValue) {
		Map<String, Object> map = new HashMap<>();
		map.put(propName, propValue);
		return this.findBy(map);
	}

	public PageBean<E> findByPage(String propName, Object propValue, Long pageStart, Long pageSize) {
		Map<String, Object> map = new HashMap<>();
		map.put(propName, propValue);
		return this.findByPage(map, pageStart, pageSize);
	}

	public PageBean<E> findByPage(Map<String, Object> proValues, Long pageStart, Long pageSize) {
		// 构造hql
		String hql = "from " + entityName + " e where ";
		String hqls = "select count(*) " + hql;
		// 构造hql中的where
		String wh = "";
		for (String propName : proValues.keySet()) {
			if (!"".equals(wh)) {
				wh += " and ";
			}
			wh += "e." + propName + " like:" + propName.replace('.', '_');
		}
		hql = hql + wh;
		hqls = hqls + wh;
		Query query = getSession().createQuery(hql, entityClass);
		Query querys = getSession().createQuery(hqls);
		setParameters(query, proValues);
		setParameters(querys, proValues);
		List<E> list = query.setFirstResult(pageStart.intValue()).setMaxResults(pageSize.intValue()).getResultList();
		Long total = (Long) querys.uniqueResult();
		PageBean<E> pageBean = new PageBean<>();
		pageBean.setStart(pageStart);
		pageBean.setSize(pageSize);
		pageBean.setList(list);
		pageBean.setTotal(total);
		return pageBean;
	}

	private void setParameters(Query query, Map<String, Object> map) {
		for(String propName : map.keySet()) {
			query.setParameter(propName.replace('.', '_'), "%" + map.get(propName) + "%");
		}
	}

}
