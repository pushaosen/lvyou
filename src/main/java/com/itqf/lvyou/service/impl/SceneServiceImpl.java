package com.itqf.lvyou.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.itqf.lvyou.WoException;
import com.itqf.lvyou.WoResultCode;
import com.itqf.lvyou.dao.SceneDao;
import com.itqf.lvyou.model.PageBean;
import com.itqf.lvyou.model.Scene;
import com.itqf.lvyou.service.SceneService;

@Service
@Transactional
public class SceneServiceImpl implements SceneService {

	@Resource
	private SceneDao sceneDao;
	
	private final static WoResultCode REPEAT_NAME = new WoResultCode(8000, "该景区已经存在，导入失败！");
	
	@Override
	public List<Scene> getAllScene() {
		return sceneDao.findAll();
	}

	@Override
	public Scene getSceneById(String id) {
		return sceneDao.findById(id);
	}

	@Override
	public void createScene(Scene scene) {
		if (sceneDao.findBy("name", scene.getName()) != null) {
			throw new WoException(REPEAT_NAME);
		}
		sceneDao.create(scene);;
	}

	@Override
	public PageBean<Scene> getSceneByName(String id, String name, Long woPageStart, Long woPageSize) {
		PageBean<Scene> pageScene = new PageBean<>();
		if (StringUtils.isEmpty(name)) {
			name = "";
		}
		if (id == null) {
			pageScene = sceneDao.findByPage("name", name, woPageStart, woPageSize);
		}else {
			Map<String, Object> map = new HashMap<>();
			map.put("id", id);
			map.put("name", name);
			pageScene = sceneDao.findByPage(map, woPageStart, woPageSize);
		}
		return pageScene;
	}

	@Override
	public List<Scene> getExportScene(String id, String name, Long woPageStart, Long woPageSize) {
		if (StringUtils.isEmpty(name)) {
			name = "";
		}
		List<Scene> scenes = new ArrayList<>();
		PageBean<Scene> page  = new PageBean<>();
		if (id == null) {
			page = sceneDao.findByPage("name", name, woPageStart, woPageSize);
			scenes = page.getList();
		}else {
			Map<String, Object> map = new HashMap<>();
			map.put("id", id);
			map.put("name", name);
			page = sceneDao.findByPage(map, woPageStart, woPageSize);
			scenes = page.getList();
		}
		return scenes;
	}

}
