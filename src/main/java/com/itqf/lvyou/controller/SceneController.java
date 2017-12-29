package com.itqf.lvyou.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.itqf.lvyou.WoException;
import com.itqf.lvyou.WoResultCode;
import com.itqf.lvyou.model.Employee;
import com.itqf.lvyou.model.PageBean;
import com.itqf.lvyou.model.Role;
import com.itqf.lvyou.model.Scene;
import com.itqf.lvyou.model.Site;
import com.itqf.lvyou.service.EmployeeService;
import com.itqf.lvyou.service.FileService;
import com.itqf.lvyou.service.SceneService;
import com.itqf.lvyou.service.SiteService;
import com.itqf.lvyou.view.SceneExcelView;
@SuppressWarnings("all")
@Controller
@RequestMapping("/ly/scene")
public class SceneController {

	@Resource
	private SceneService sceneService;
	
	@Resource
	private SiteService siteService;
	
	@Resource
	private FileService fileService;
	
	@Qualifier("sceneExcelView")
	@Resource
	private View sceneExcelView;
	
	@Resource
	private EmployeeService employeeService;
	
	private final static WoResultCode IMPORT_FILE = new WoResultCode(8001, "你还没有选择上传的文件！");
	
	private final static WoResultCode DATA_FILE = new WoResultCode(8002, "你选择的文件没有数据！");
	
	private final static Logger LOG = LogManager.getLogger(SceneController.class);
	
	@RequestMapping("/list")
	public ModelAndView getList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); 
		Map<String, Object> userData = (Map<String, Object>) request.getSession().getAttribute("userData");
		PageBean<Scene> pages = null;
		if (Role.EMPLOYEE.equals(userData.get("role"))) {
			// 获取工作人员的景区，加入景区列表
			Employee emp = (Employee) userData.get("employee");
			pages = sceneService.getSceneByName(emp.getScene().getId(), "", 0L, 10L);
		}else {
			// 否则的话，获取所有景区
			pages = sceneService.getSceneByName(null, "", 0L, 10L);
		}
		mav.setViewName("scene/list");
		mav.addObject("scenes", pages);
		return mav;
	}
	
	@RequestMapping("/search")
	public ModelAndView searchScene(String name, HttpServletRequest request, Long woPageStart, Long woPageSize) {
		ModelAndView mav = new ModelAndView(); 
		Map<String, Object> userData = (Map<String, Object>) request.getSession().getAttribute("userData");
		PageBean<Scene> pages = new PageBean<>();
		if (Role.EMPLOYEE.equals(userData.get("role"))) {
			// 获取工作人员的景区，加入景区列表
			Employee emp = (Employee) userData.get("employee");
			pages = sceneService.getSceneByName(emp.getScene().getId(), name, woPageStart, woPageSize);
		}else {
			// 否则的话，获取所有景区
			pages = sceneService.getSceneByName(null, name, woPageStart, woPageSize);
		}
		mav.setViewName("scene/search");
		mav.addObject("scenes", pages);
		return mav;
	}
	
	@RequestMapping("/loadCreateForm")
	public String loadCreateForm() {
		return "scene/createForm";
	}
	
	@ResponseBody
	@RequestMapping("/create")
	public Object create(MultipartFile headImageFile, Scene scene, HttpServletRequest request) {
		try {
			if (headImageFile != null) {
				String path = fileService.uploadFile(headImageFile, request);
				scene.setImg(path);
			}
			// 保存景区
			sceneService.createScene(scene);
			Employee employee = new Employee();
			employee.setId(UUID.randomUUID().toString());
			employee.setMobile(scene.getTelephone());
			employee.setEmployName(scene.getName());
			employee.setScene(scene);
			
			// 保存景区的时候绑定一个景区的负责人
			employeeService.createEmployee(employee);
			
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			LOG.error(e.getMessage(), e);
			return e.getCode();
		}catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return WoResultCode.getUnknown().setMsg("创建景区失败！");
		}
	}
	
	@RequestMapping("/loadImportForm")
	public String loadImportForm() {
		return "scene/importForm";
	}
	
	// 数据导入
	@ResponseBody
	@RequestMapping("/import")
	public Object importScene(MultipartFile importFile, HttpServletRequest request) {
		Workbook book = null;
		try {
			if (importFile == null) {
				throw new WoException(IMPORT_FILE);
			}
			String fileName = importFile.getOriginalFilename();
			if (fileName.endsWith(".xlsx")) {
				book = new XSSFWorkbook(importFile.getInputStream());
			}else {
				book = new HSSFWorkbook(importFile.getInputStream());
			}
			Sheet sheet = book.getSheetAt(0);
			if (sheet.getLastRowNum() < 1) {
				throw new WoException(DATA_FILE);
			}
			for(int i = 1; i <= sheet.getLastRowNum(); i ++) {
				Row row = sheet.getRow(i);
				Scene scene = new Scene();
				scene.setId(UUID.randomUUID().toString());
				scene.setName(row.getCell(0).getStringCellValue());
				scene.setAddress(row.getCell(1).getStringCellValue());
				scene.setDescription(row.getCell(2).getStringCellValue());
				// 保存景区数据
				sceneService.createScene(scene);;
				
				Employee emp = new Employee();
				emp.setId(UUID.randomUUID().toString());
				emp.setEmployName(row.getCell(3).getStringCellValue());
				emp.setMobile(row.getCell(4).getStringCellValue());
				emp.setScene(scene);
				// 保存景区数据的时候绑定一个负责人
				employeeService.createEmployee(emp);
				
				// 如果有存在多个sheet则循环遍历
				int count = book.getNumberOfSheets();
				if (count > 1) {
					// 通过循环遍历book的各个sheet，来判断当前的景区名的sheet是否存在
					for(int k = 1; k < count; k ++) {
						// 获取当前景区的sheet
						Sheet sheets = book.getSheetAt(k);
						// 如果存在就获取当前景区的sheet，病读取里面的数据
						if (scene.getName().equals(sheets.getSheetName())) {
							
							// 判断里面是否有数据
							if (sheets.getLastRowNum() < 1) {
								throw new WoException(DATA_FILE);
							}
							
							// 否则就有数据，就开始循环读取，并存入数据库
							for(int j = 1; j <= sheets.getLastRowNum(); j ++) {
								Row rr = sheets.getRow(j);
								Site site = new Site();
								site.setId(UUID.randomUUID().toString());
								site.setName(rr.getCell(0).getStringCellValue());
								site.setPlace(rr.getCell(1).getStringCellValue());
								site.setDescription(rr.getCell(2).getStringCellValue());
								site.setScene(scene);
								// 保存景点数据
								siteService.createSite(site);
							}
						}
						// 如果不存在当前景区的sheet，则不做任何处理
					}
				}
				// 如果sheet=1，就只有景区的sheet，没有经典的sheet，就不做任何处理
			}
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			LOG.error(e.getMessage(), e);
			return e.getCode();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return WoResultCode.getUnknown().setMsg("景区数据导入失败！");
		}
	}
	
	// 数据导出
	@RequestMapping("/export")
	public ModelAndView export(String name, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setView(sceneExcelView);
		Map<String, Object> userData = (Map<String, Object>) request.getSession().getAttribute("userData");
		List<Scene> scenes = new ArrayList<>();
		if (Role.EMPLOYEE.equals(userData.get("role"))) {
			Employee employee = (Employee) userData.get("employee");
			scenes = sceneService.getExportScene(employee.getScene().getId(), name, 0L, 10L);
		}else {
			scenes = sceneService.getExportScene(null, name, 0L, 10L);
		}
		mav.addObject("scenes", scenes);
		
		return mav;
	}
}
