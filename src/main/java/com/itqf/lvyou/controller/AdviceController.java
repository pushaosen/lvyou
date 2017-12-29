package com.itqf.lvyou.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.itqf.lvyou.model.Advice;
import com.itqf.lvyou.service.AdviceService;

@Controller
@RequestMapping("/ly/advice")
public class AdviceController {

	@Resource
	private AdviceService adviceService;
	
	@RequestMapping("/list")
	public ModelAndView getList() {
		ModelAndView mav = new ModelAndView();
		List<Advice> advices = adviceService.getAllAdvice();
		mav.setViewName("advice/list");
		mav.addObject("advices", advices);
		return mav;
	}
}
