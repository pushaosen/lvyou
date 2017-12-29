package com.itqf.lvyou.dao;

import com.itqf.lvyou.model.Site;

/**
 * 景点访问数据接口
 * @author Administrator
 *
 */
public interface SiteDao extends BaseDao<Site, String> {

	/**
	 * 根据名称查找景点
	 * @param name
	 * @return
	 */
	public abstract Site getSiteByName(String name);
}
