package com.itqf.lvyou.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.itqf.lvyou.model.Guest;
import com.itqf.lvyou.service.GuestService;

@Controller
@RequestMapping("/ly/guest")
public class GuestController {

	@Resource
	private GuestService guestService;
	
	@RequestMapping("/list")
	public ModelAndView getList() {
		ModelAndView mav = new ModelAndView();
		List<Guest> guests = guestService.getAllGuest();
		mav.setViewName("guest/list");
		mav.addObject("guests", guests);
		return mav;
	}
}
