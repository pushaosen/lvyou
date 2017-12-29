package com.itqf.lvyou.service.impl;

import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.itqf.lvyou.dao.AdviceDao;
import com.itqf.lvyou.model.Advice;
import com.itqf.lvyou.service.AdviceService;

@Service
@Transactional
public class AdviceServiceImpl implements AdviceService {

	@Resource
	private AdviceDao adviceDao;
	
	@Override
	public List<Advice> getAllAdvice() {
		return adviceDao.findAll();
	}

}
