package com.itqf.lvyou.service;

import java.util.List;
import com.itqf.lvyou.model.Comment;

/**
 * 评论service业务逻辑处理
 * @author Administrator
 *
 */
public interface CommentService {

	/**
	 * 获取所有评论
	 * @return
	 */
	public abstract List<Comment> getAllComment();

}
