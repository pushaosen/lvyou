package com.itqf.lvyou.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.itqf.lvyou.model.Employee;
import com.itqf.lvyou.model.Role;
import com.itqf.lvyou.model.TicketType;
import com.itqf.lvyou.service.TicketTypeService;
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/ly/tickettype")
public class TicketTypeController {

	@Resource
	private TicketTypeService ticketTypeService;
	
	@RequestMapping("/list")
	public ModelAndView getList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> userData = (Map<String, Object>) request.getSession().getAttribute("userData");
		List<TicketType> ticketTypes = new ArrayList<>();
		if (Role.EMPLOYEE.equals(userData.get("role"))) {
			Employee emp = (Employee) userData.get("employee");
			ticketTypes = ticketTypeService.getTicketTypeBySceneId(emp.getScene().getId());
		}else {
			ticketTypes = ticketTypeService.getAllTicketType();
		}
		mav.setViewName("tickettype/list");
		mav.addObject("ticketTypes", ticketTypes);
		return mav;
	}
}
