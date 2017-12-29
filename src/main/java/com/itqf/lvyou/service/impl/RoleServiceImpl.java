package com.itqf.lvyou.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.itqf.lvyou.dao.MenuDao;
import com.itqf.lvyou.dao.RoleDao;
import com.itqf.lvyou.model.Menu;
import com.itqf.lvyou.model.Role;
import com.itqf.lvyou.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;
	
	@Resource
	private MenuDao menuDao;
	
	@Override
	public List<Role> getRoles() {
		return roleDao.findAll();
	}

	@Override
	public Role getRoleById(String roleId) {
		return roleDao.findById(roleId);
	}

	@Override
	public Map<String, Object> getRoleAndMenus(String roleId) {
		Map<String, Object> data = new HashMap<>();
		Role r = this.getRoleById(roleId);
		data.put("role", r);
		List<Menu> menus = new ArrayList<>();
		menus.addAll(r.getMenus());
		data.put("reletedMenus", menus);
		return data;
	}

	@Override
	public void relatedMenus(String roleId, String[] menus) {
		Role role = roleDao.findById(roleId);
		List<Menu> menuList = new ArrayList<Menu>();
		for(int i = 0; i < menus.length; i ++) {
			menuList.add(menuDao.findById(menus[i]));
		}
		role.setMenus(menuList);
		roleDao.update(role);;
	}
}
