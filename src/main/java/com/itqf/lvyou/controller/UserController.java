package com.itqf.lvyou.controller;

import java.io.IOException;
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
import org.springframework.web.servlet.View;
import com.itqf.lvyou.WoException;
import com.itqf.lvyou.WoResultCode;
import com.itqf.lvyou.model.PageBean;
import com.itqf.lvyou.model.User;
import com.itqf.lvyou.service.FileService;
import com.itqf.lvyou.service.UserService;
/**
 * user的控制器
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/sys/user")
public class UserController {

	@Resource
	private UserService userService;
	
	private final Logger LOG = LogManager.getLogger(UserController.class);
	
	private final static WoResultCode IMPORT_FILE = new WoResultCode(5001,"你还没有选择上传的数据文件!");
	
	private final static WoResultCode IMPORT_DATA = new WoResultCode(5001,"你上传的文件中没有数据!");
	
	@Resource
	@Qualifier("userExcelView")
	private View userExcelView;
	
	@Resource
	private FileService fileService;
	
	@RequestMapping("/list")
	public ModelAndView getList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/list");
		PageBean<User> users = userService.getUsersByLoginName("", 0L, 10L);
		mav.addObject("pgUsers", users);
		return mav;
	}
	
	@RequestMapping("/loadCreateForm")
	public String loadCreateForm() {
		return "user/createForm";
	}
	
	@ResponseBody
	@RequestMapping("/create")
	public Object createUser(User user,MultipartFile headImageFile,HttpServletRequest request) {
		try {
			if (headImageFile != null) {
				String path = fileService.uploadFile(headImageFile, request);
				user.setHeadImage(path);
			}
			userService.createUser(user);
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			LOG.error(e.getMessage(), e);
			return e.getCode();
		}catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return WoResultCode.getUnknown().setMsg("创建用户失败！");
		}
	}
	
	@RequestMapping("/search")
	public ModelAndView searchUsers(String loginName, Long woPageStart, Long woPageSize) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/search");
		PageBean<User> users = userService.getUsersByLoginName(loginName, woPageStart, woPageSize);
		mav.addObject("pgUsers", users);
		return mav;
	}
	
	@RequestMapping("/loadUpdateForm")
	public ModelAndView loadUpdateForm(String userId) {
		ModelAndView mav = new ModelAndView();
		User user = userService.getUsersById(userId);
		mav.addObject("user", user);
		mav.setViewName("user/updateForm");
		return mav;
	}
	
	/**
	 * 它使用的是ajax请求，发送的是json数据，不需要跳转页面
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Object update(User user,MultipartFile headImageFile,String headImageClick,HttpServletRequest request) {
		try {
			if ("-1".equals(headImageClick)) {
				if (headImageFile == null) {
					user.setHeadImage(null);
				} else {
					String path = fileService.uploadFile(headImageFile, request);
					user.setHeadImage(path);
				}
			} 
			userService.updateUser(user);
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			LOG.error(e.getMessage(), e);
			return e.getCode();
		}catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return WoResultCode.getUnknown().setMsg("修改用户失败！");
		}
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public Object deleteUsers(String userIds) {
		try {
			String [] ids = userIds.split(",");
			userService.deleteUsers(ids);
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			LOG.error(e.getMessage(), e);
			return e.getCode();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return WoResultCode.getUnknown().setMsg("删除用户失败！");
		}
	}
	
	@RequestMapping("/loadImportForm")
	public String loadImportForm() {
		return "user/importForm";
	}
	
	@ResponseBody
	@RequestMapping("/import")
	public Object importUsers(MultipartFile importFile,HttpServletRequest request) {
		Workbook workbook = null;
		try {
			if (importFile == null) {
				throw new WoException(IMPORT_FILE);
			}
			String fileName = importFile.getOriginalFilename();
			if (fileName.endsWith(".xlsx")) {
				workbook = new XSSFWorkbook(importFile.getInputStream());
			}else {
				workbook = new HSSFWorkbook(importFile.getInputStream());
			}
			Sheet sheet = workbook.getSheetAt(0);
			if (sheet.getLastRowNum() < 1) {
				throw new WoException(IMPORT_DATA);
			}
			List<User> users = new ArrayList<User>();
			for(int i = 1; i <= sheet.getLastRowNum(); i ++) {
				Row r = sheet.getRow(i);
				User user = new User();
				user.setId(r.getCell(0).getStringCellValue());
				user.setLoginName(r.getCell(1).getStringCellValue());
				user.setCreateTime(r.getCell(2).getDateCellValue());
				user.setPassword("123456");
				users.add(user);
			}
			userService.importUsers(users);
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			LOG.error(e.getMessage(), e);
			return e.getCode();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return WoResultCode.getUnknown().setMsg("导入用户数据失败！");
		}finally {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @return
	 */
	@RequestMapping("/export")
	public ModelAndView exportUsers(String loginName) {
		ModelAndView mav = new ModelAndView();
		mav.setView(userExcelView);
		PageBean<User> users = userService.getUsersByLoginName(loginName, 0L, userService.getCountUsersByName(loginName));
		mav.addObject("users", users.getList());
		return mav;
	}
	
}
