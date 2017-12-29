package com.itqf.lvyou.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.itqf.lvyou.dao.TicketTypeDao;
import com.itqf.lvyou.model.TicketType;
import com.itqf.lvyou.service.TicketTypeService;

@Service
@Transactional
public class TicketTypeServiceImpl implements TicketTypeService {

	@Resource
	private TicketTypeDao ticketTypeDao;
	
	@Override
	public List<TicketType> getAllTicketType() {
		return ticketTypeDao.findAll();
	}

	@Override
	public List<TicketType> getTicketTypeBySceneId(String id) {
		return ticketTypeDao.findBy("scene.id", id);
	}

}
