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
import com.itqf.lvyou.model.Guest;
import com.itqf.lvyou.model.Role;
import com.itqf.lvyou.model.TicketRecord;
import com.itqf.lvyou.service.TicketRecordService;
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/ly/ticketrecord")
public class TicketRecordController {

	@Resource
	private TicketRecordService ticketRecordService;
	
	@RequestMapping("/list")
	public ModelAndView getList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> userData = (Map<String, Object>) request.getSession().getAttribute("userData");
		List<TicketRecord> ticketrecords = new ArrayList<>();
		if (Role.EMPLOYEE.equals(userData.get("role"))) {
			Employee emp = (Employee) userData.get("employee");
			ticketrecords = ticketRecordService.getTicketRecordByEmployId(emp.getId());
		}else if(Role.GUEST.equals(userData.get("role"))) {
			Guest guest = (Guest) userData.get("guest");
			ticketrecords = ticketRecordService.getTicketRecordByGuestId(guest.getId());
		}else {
			ticketrecords = ticketRecordService.getAllTicketRecord();
		}
		mav.setViewName("ticketrecord/list");
		mav.addObject("ticketrecords", ticketrecords);
		return mav;
	}
}
