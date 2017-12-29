package com.itqf.lvyou.service.impl;

import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.itqf.lvyou.WoException;
import com.itqf.lvyou.WoResultCode;
import com.itqf.lvyou.dao.SiteDao;
import com.itqf.lvyou.model.Site;
import com.itqf.lvyou.service.SiteService;

@Service
@Transactional
public class SiteServiceImpl implements SiteService {

	private final static WoResultCode REPEAT_NAME = new WoResultCode(10000,"该景点名称已经存在，创建失败！"); 
	
	@Resource
	private SiteDao siteDao;
	
	@Override
	public List<Site> getAllSite() {
		return siteDao.findAll();
	}

	@Override
	public List<Site> getSiteBySceneId(String id) {
		return siteDao.findBy("parent.id", id);
	}

	@Override
	public void createSite(Site site) {
		if(siteDao.getSiteByName(site.getName()) != null) {
			throw new WoException(REPEAT_NAME);
		}
		siteDao.create(site);;
	}

}
