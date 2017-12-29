package com.itqf.lvyou.service;

import java.util.List;
import java.util.Map;

import com.itqf.lvyou.model.Menu;

/**
 * 菜单业务逻辑处理接口service
 * @author Administrator
 *
 */
public interface MenuService {

	/**
	 * 通过当前顶级菜单ID和当前子菜单ID获取所有主页面需要的菜单数据
	 * @param currentTopId   dangqian dingji caidan
	 * @param currentSubId
	 * @return
	 */
	public abstract Map<String,Object> getMenuData(String currentTopId,String currentSubId);

	/**
	 * 用户登录时根据角色权限分配不同的菜单权限
	 * @param roleId
	 * @param currentTopId
	 * @param currentSubId
	 * @return
	 */
	public abstract Map<String,Object> getMenuData(String roleId, String currentTopId,String currentSubId);
	
	/**
	 * 查询所有菜单
	 * @return
	 */
	public abstract List<Menu> getAllMenus();

	/**
	 * 创建顶级菜单
	 * @param menu
	 */
	public abstract void createMenu(Menu menu);

	/**根据ID查询父菜单
	 * @param parentId
	 * @return
	 */
	public abstract Menu getMenuById(String menuId);

	/**
	 * 根据菜单名模糊进行查询
	 * @param name
	 * @return
	 */
	public abstract List<Menu> getMenusByName(String name);

	/**
	 * 修改菜单
	 * @param menu
	 */
	public abstract void updateMenu(Menu menu);

	/**
	 * 根据menuId删除菜单
	 * @param menuId
	 */
	public abstract void deletMenu(String menuId);
}
