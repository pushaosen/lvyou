package com.itqf.lvyou.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.itqf.lvyou.model.PageBean;


/**
 * 实现泛型的basedao接口
 * @author Administrator
 *
 * @param <E> 实体类型
 * @param <K> 主键类型
 */
public interface BaseDao<E, K extends Serializable> {

	/**
	 * 根据主键id去查询实体类对象
	 * @param id
	 * @return
	 */
	public abstract E findById(K id);
	
	/**
	 * 创建实体类
	 * @param entity
	 */
	public abstract void create(E entity);
	
	/**
	 * 查询全部
	 * @return
	 */
	public abstract List<E> findAll();
	
	/**
	 * 修改实体类
	 * @param entity
	 */
	public abstract void update(E entity);
	
	/**
	 * 删除实体类
	 * @param entity
	 */
	public abstract void delete(E entity);
	
	/**
	 * 根据Map对象中的多个属性和值(各条件之间是与的关系)，查询实体列表
	 * @param proValues
	 * @return
	 */
	public abstract List<E> findBy (Map<String, Object> proValues);
	
	/**
	 * 根据属性名称和值，查询实体列表
	 * @param propName
	 * @param propValue
	 * @return
	 */
	public abstract List<E> findBy (String propName, Object propValue);
	
	/**
	 * 根据属性名称和值,以及分页的条件，实现分页查询
	 * @param propName
	 * @param propValue
	 * @param pageStart
	 * @param pageSize
	 * @return
	 */
	public abstract PageBean<E> findByPage(String propName, Object propValue, Long pageStart, Long pageSize);
	
	/**
	 * 根据Map对象中的多个属性和值(各条件之间是与的关系),以及分页条件，查询分页查询
	 * @param proValues
	 * @param pageStart
	 * @param pageSize
	 * @return
	 */
	public abstract PageBean<E> findByPage (Map<String, Object> proValues, Long pageStart, Long pageSize);
}
