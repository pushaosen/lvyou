package com.itqf.lvyou.service;

import java.util.List;
import java.util.Map;

import com.itqf.lvyou.model.Role;

public interface RoleService {

	/**
	 * 获取所有角色信息
	 * @return
	 */
	public abstract List<Role> getRoles();

	/**
	 * 根据roleId查询role角色
	 * @param roleId
	 * @return
	 */
	public abstract Role getRoleById(String roleId);
	
	/**
	 * 根据id查询，然后将其放入map中
	 * @param roleId
	 * @return
	 */
	public abstract Map<String, Object> getRoleAndMenus(String roleId);

	/**
	 * 给角色设置不同的菜单列表
	 * @param roleId
	 * @param menus
	 */
	public abstract void relatedMenus(String roleId, String[] menus);

}
