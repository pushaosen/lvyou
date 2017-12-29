package com.itqf.lvyou.service.impl;

import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.itqf.lvyou.dao.CommentDao;
import com.itqf.lvyou.model.Comment;
import com.itqf.lvyou.service.CommentService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Resource
	private CommentDao commentDao;
	
	public List<Comment> getAllComment() {
		return commentDao.findAll();
	}

}
