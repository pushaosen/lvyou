package com.itqf.lvyou.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.itqf.lvyou.model.User;
import com.itqf.lvyou.utils.ExcelUtils;

/**
 * 从数据库导出数据
 * @author Administrator
 *
 */
@SuppressWarnings("all")
@Component("userExcelView")
public class UserExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 0、获取用户数据
		List<User> users = (List<User>) model.get("users");
		// 1、获取模板，并解析
		File fileTmpl = ResourceUtils.getFile("classpath:template/user-template.xlsx");
		// 1.1解析WorkBook
		Workbook bookTmpl = null;
		bookTmpl = new XSSFWorkbook(new FileInputStream(fileTmpl));
		// 1.2解析模板里面的sheet
		Sheet sheetImpl = bookTmpl.getSheetAt(0);
		// 1.3解析模板里面的sheet的标题行
		Row rowHeaderTmpl = sheetImpl.getRow(0);
		// 1.4解析模板里面的sheet的数据行
		Row rowDataTmpl = sheetImpl.getRow(1);
		
		// 2、按照模板创建book中的sheet/row/cell
		Sheet sheet = book.createSheet(sheetImpl.getSheetName());
		// 2.1设置列宽
		for(int i = 0; i< rowHeaderTmpl.getLastCellNum(); i++) {
			sheet.setColumnWidth(i, sheetImpl.getColumnWidth(i));
		}
		// 2.2创建标题行
        // Row rowHeader = sheet.createRow(0);
		ExcelUtils.createRowByTmpl(rowHeaderTmpl, sheet, 0, true);
		for(int i = 0; i < users.size(); i ++) {
			User u = users.get(i);
			Row rowData = ExcelUtils.createRowByTmpl(rowDataTmpl, sheet, i + 1, false);
			rowData.getCell(0).setCellValue(u.getId());
			rowData.getCell(1).setCellValue(u.getLoginName());
			if (u.getCreateTime() != null) {
				rowData.getCell(2).setCellValue(String.valueOf(u.getCreateTime()).replace(".0", ""));
			}else {
				rowData.getCell(2).setCellValue("");
			}
		}
	}
	
}
