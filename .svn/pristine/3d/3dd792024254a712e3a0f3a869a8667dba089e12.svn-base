package com.itqf.lvyou.controller;

import java.util.ArrayList;
import java.util.List;
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
import com.itqf.lvyou.WoException;
import com.itqf.lvyou.WoResultCode;
import com.itqf.lvyou.model.Employee;
import com.itqf.lvyou.service.EmployeeService;
import com.itqf.lvyou.service.FileService;
import com.itqf.lvyou.view.EmployeeExcelView;

/**
 * @author Administrator
 * 员工管理类的Controller
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/ly/employee")
public class EmployeeController {

	private final static Logger LOG = LogManager.getLogger(EmployeeController.class);
	
	private final static WoResultCode IMPORT_FILE =new WoResultCode(6001, "你还没有选择上传的数据文件!");
	
	private final static WoResultCode IMPORT_DATA = new WoResultCode(6002, "你上传的文件中没有数据!");
	
	@Resource
	private FileService fileService;
	
	@Resource
	@Qualifier("employeeExcelView")
	private EmployeeExcelView  employeeExcelView;
	
	@Resource
	private EmployeeService employeeService;
	
	@RequestMapping("/list")
	public ModelAndView getList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("employee/list");
		List<Employee> employees = employeeService.getEmployees();
		mav.addObject("employees", employees);
		return mav;
	}
	
	@RequestMapping("/loadCreateForm")
	public String loadCreateForm() {
		return "employee/createForm";
	}
	
	@ResponseBody
	@RequestMapping("/create")
	public Object createUser(Employee employee,MultipartFile headImageFile,HttpServletRequest request) {
		try {
			if (headImageFile != null) {
				String path = fileService.uploadFile(headImageFile, request);
				employee.setHeadImage(path);
			}
			employeeService.createEmployee(employee);
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			LOG.error(e.getMessage(), e);
			return e.getCode();
		}catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return WoResultCode.getUnknown().setMsg("创建员工失败！");
		}
	}
	
	@RequestMapping("/loadUpdateForm")
	public ModelAndView loadUpdateForm(String employeeId) {
		ModelAndView mav = new ModelAndView();
		Employee e = employeeService.getEmployeeById(employeeId);
		mav.addObject("employee", e);
		mav.setViewName("employee/updateForm");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Object update(Employee employee,MultipartFile headImageFile,String headImageClick,HttpServletRequest request) {
		try {
			if ("-1".equals(headImageClick)) {
				if (headImageFile == null) {
					employee.setHeadImage(null);
				} else {
					String path = fileService.uploadFile(headImageFile, request);
					employee.setHeadImage(path);
				}
			} 
			employeeService.updateEmployee(employee);
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			LOG.error(e.getMessage(), e);
			return e.getCode();
		}catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return WoResultCode.getUnknown().setMsg("修改员工失败！");
		}
	}
	
	@RequestMapping("/search")
	public ModelAndView searchUsers(String employName,String phone,String idCard) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("employee/search");
		List<Employee> employees = employeeService.getEmployeeList(employName,phone,idCard);
		mav.addObject("employees", employees);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public Object deleteUsers(String employeeIds) {
		try {
			String [] ids = employeeIds.split(",");
			employeeService.deleteEmployees(ids);
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			LOG.error(e.getMessage(), e);
			return e.getCode();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return WoResultCode.getUnknown().setMsg("删除员工失败！");
		}
	}
	
	@RequestMapping("/loadImportForm")
	public String loadImportForm() {
		return "employee/importForm";
	}
	
	@ResponseBody
	@RequestMapping("/import")
	public Object importEmployees(MultipartFile importFile,HttpServletRequest request) {
		Workbook book = null;
		try {
			if (importFile == null) {
				throw new WoException(IMPORT_FILE);
			}
			String filename = importFile.getOriginalFilename();
			if (filename.endsWith(".xlsx")) {
				book = new XSSFWorkbook(importFile.getInputStream());
			} else {
				book = new HSSFWorkbook(importFile.getInputStream());
			}
			Sheet sheet = book.getSheetAt(0);
			if (sheet.getLastRowNum() < 1) {
				throw new WoException(IMPORT_DATA);
			}
			List<Employee> employees = new ArrayList<>();
			for(int i = 1; i <= sheet.getLastRowNum(); i ++) {
				Row r = sheet.getRow(i);
				Employee employee = new Employee();
				employee.setId(r.getCell(0).getStringCellValue());
				employee.setEmployName(r.getCell(1).getStringCellValue());
				employee.setSex(r.getCell(2).getStringCellValue());
				employee.setNo(r.getCell(3).getStringCellValue());
				employee.setMobile(r.getCell(4).getStringCellValue());
				employee.setIdCard(r.getCell(5).getStringCellValue());
				employee.setPosition(r.getCell(6).getStringCellValue());
				employees.add(employee);
			}
			employeeService.importEmployees(employees);
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			LOG.error(e.getMessage(), e);
			return e.getCode();
		}catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return WoResultCode.getUnknown().setMsg("员工数据导入失败！");
		}
	}
	
	@RequestMapping("/export")
	public ModelAndView exportEmployees(String employName, String phone, String idCard) {
		ModelAndView mav = new ModelAndView();
		List<Employee> employeeList = employeeService.getEmployeeList(employName, phone, idCard);
		mav.setView(employeeExcelView);
		mav.addObject("employees", employeeList);
		return mav;
	}
	
}
