package com.itqf.lvyou.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import com.itqf.lvyou.dao.SiteDao;
import com.itqf.lvyou.model.Scene;
import com.itqf.lvyou.model.Site;
import com.itqf.lvyou.model.User;
import com.itqf.lvyou.service.SiteService;
import com.itqf.lvyou.utils.ExcelUtils;

/**
 * 从数据库导出数据
 * @author Administrator
 *
 */
@SuppressWarnings("all")
@Component("sceneExcelView")
//@Transactional
public class SceneExcelView extends AbstractXlsView {
	
	@Resource
	private SiteService siteDao;

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 获取数据
		List<Scene> scenes = (List<Scene>) model.get("scenes");
		
		// 创建Excel表的名称
		String filename = "景区信息";
		String requestEncode = request.getCharacterEncoding();
		requestEncode = requestEncode == null ? "utf-8" : requestEncode;
		filename = new String(filename.getBytes(requestEncode), "ISO8859-1");
		// 设置文件的文件名
		response.setHeader("Content-disposition", "attachment;filename=" + filename);
		
		// 创建景区sheet
		Sheet sheetScene = book.createSheet("景区");
		
		// 创建景区标题行
        Row rowSceneHeader = sheetScene.createRow(0);
        Cell cellSceneHead1 = rowSceneHeader.createCell(0);
        Cell cellSceneHead2 = rowSceneHeader.createCell(1);
        Cell cellSceneHead3 = rowSceneHeader.createCell(2);
        cellSceneHead1.setCellValue("名称");
        cellSceneHead2.setCellValue("地址");
        cellSceneHead3.setCellValue("描述");
		if (scenes.size() < 1) {
			
		}else {
			for(int i = 0; i < scenes.size(); i ++) {
				// 获取单个景区对象
				Scene s = scenes.get(i);
				
				//导入景区数据
				Row rowSceneData = sheetScene.createRow(i + 1);
				Cell cellSceneData1 = rowSceneData.createCell(0);
			    Cell cellSceneData2 = rowSceneData.createCell(1);
			    Cell cellSceneData3 = rowSceneData.createCell(2);
			    cellSceneData1.setCellValue(s.getName());
			    cellSceneData2.setCellValue(s.getAddress());
			    cellSceneData3.setCellValue(s.getDescription());
				
				
				// 创建景点sheet
				Sheet sheetSite = book.createSheet(s.getName());
				// 创建景点标题行
		        Row rowSiteHeader = sheetSite.createRow(0);
		        Cell cellSiteHead1 = rowSiteHeader.createCell(0);
		        Cell cellSiteHead2 = rowSiteHeader.createCell(1);
		        Cell cellSiteHead3 = rowSiteHeader.createCell(2);
		        cellSiteHead1.setCellValue("名称");
		        cellSiteHead2.setCellValue("地址");
		        cellSiteHead3.setCellValue("描述");
		        List<Site> sites = siteDao.getSiteBySceneId(s.getId());
		        if (sites.size() < 1) {
					
				}else {
					for(int j = 0; j < sites.size(); j ++) {
						// 获取单个景点对象
						Site site = sites.get(j);
						
						//导入景点数据
						Row rowSiteData = sheetSite.createRow(j + 1);
						Cell cellSiteData1 = rowSiteData.createCell(0);
					    Cell cellSiteData2 = rowSiteData.createCell(1);
					    Cell cellSiteData3 = rowSiteData.createCell(2);
					    cellSiteData1.setCellValue(site.getName());
					    cellSiteData2.setCellValue(site.getPlace());
					    cellSiteData3.setCellValue(site.getDescription());
					}
				}
			}
		}
	}
	
}
