package com.itqf.lvyou.service;

import java.util.List;
import com.itqf.lvyou.model.PageBean;
import com.itqf.lvyou.model.Scene;

/**
 * 景区service业务逻辑处理
 * @author Administrator
 *
 */
public interface SceneService {

	/**
	 * 获取所有景区
	 * @return
	 */
	public abstract List<Scene> getAllScene();

	/**
	 * 通过id查询景区信息
	 * @param id
	 * @return
	 */
	public abstract Scene getSceneById(String id);

	/**
	 * 创建景区
	 * @param scenes
	 */
	public abstract void createScene(Scene scene);

	/**
	 * 根据景区id、景区名称，
	 * @param id
	 * @param string
	 * @param l
	 * @param m
	 * @return
	 */
	public abstract PageBean<Scene> getSceneByName(String id, String name, Long woPageStart, Long woPageSize);

	/**
	 * 根据不同的权限进行导出数据
	 * @param id
	 * @param name
	 * @param l
	 * @param m
	 * @return
	 */
	public abstract List<Scene> getExportScene(String id, String name, Long woPageStart, Long woPageSize);

}
