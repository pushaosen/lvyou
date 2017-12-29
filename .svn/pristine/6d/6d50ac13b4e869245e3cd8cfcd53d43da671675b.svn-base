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
import com.itqf.lvyou.model.Site;
import com.itqf.lvyou.service.SiteService;
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/ly/site")
public class SiteController {

	@Resource
	private SiteService siteService;
	
	@RequestMapping("/list")
	public ModelAndView getList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> userData = (Map<String, Object>) request.getSession().getAttribute("userData");
		List<Site> sites = new ArrayList<>();
		if (Role.EMPLOYEE.equals(userData.get("role"))) {
			Employee emp = (Employee) userData.get("employee");
			sites = siteService.getSiteBySceneId(emp.getScene().getId());
		}else {
			sites = siteService.getAllSite();
		}
		mav.setViewName("site/list");
		mav.addObject("sites", sites);
		return mav;
	}
}
