package com.itqf.lvyou.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 菜单实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="sys_menu")
public class Menu {

	/**
	 * 主键id
	 */
	@Id
	@Column(length=50)
	private String id;
	
	/**
	 * 图标
	 */
	@Column(length=200)
	private String icon;
	
	/**
	 * 名称
	 */
	@Column(length=20)
	private String name;
	
	/**
	 * url
	 */
	@Column(length=200)
	private String url;
	
	/***
	 * 编号
	 */
	@Column(length=30)
	private String no;
	
	/**
	 * 父菜单
	 */
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Menu parent;
	
	/**
	 * 子菜单
	 */
	@OneToMany(mappedBy="parent")
	private List<Menu> children;
	
	@ManyToMany(mappedBy="menus")
	private List<Role> roles;

	public String getId() {
		return id;
	}
	
	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}
	
	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", icon=" + icon + ", name=" + name + ", url=" + url + ", no=" + no + ", parent="
				+ parent + "]";
	}
	
	public boolean isIn (List<Menu> menus) {
		for(Menu m : menus) {
			if(this.getId().equals(m.getId())) {
				return true;
			}
		}
		return false;
	}
}
