package com.itqf.lvyou.dao;

import java.util.List;

import com.itqf.lvyou.model.Menu;

/**
 * 菜单访问数据接口dao
 * @author Administrator
 *
 */
public interface MenuDao extends BaseDao<Menu, String> {

	/**
	 * 获取顶级菜单
	 * @return
	 */
	public abstract List<Menu> getTopMenus();
	
	/**
	 * 根据菜单名模糊查询菜单
	 * @param name
	 * @return
	 */
	public abstract List<Menu> getMenusByName(String name);
}
