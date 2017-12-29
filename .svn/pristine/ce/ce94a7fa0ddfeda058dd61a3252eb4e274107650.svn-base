package com.itqf.lvyou.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.itqf.lvyou.model.Comment;
import com.itqf.lvyou.service.CommentService;

@Controller
@RequestMapping("/ly/comment")
public class CommentController {

	@Resource
	private CommentService commentService;
	
	@RequestMapping("/list")
	public ModelAndView getList() {
		ModelAndView mav = new ModelAndView();
		List<Comment> comments = commentService.getAllComment();
		mav.setViewName("comment/list");
		mav.addObject("comments", comments);
		return mav;
	}
}
