package com.itqf.lvyou.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.itqf.lvyou.model.Employee;
import com.itqf.lvyou.utils.ExcelUtils;

/**
 * 适用于员工批量数据导出的service
 * @author Administrator
 *
 */
@SuppressWarnings("all")
@Component("employeeExcelView")
public class EmployeeExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 	0、获取员工数据
		List<Employee> employees = (List<Employee>) model.get("employees");
		// 1、获取模板，并解析
		File fileTmpl = ResourceUtils.getFile("classpath:template/employee-template.xlsx");
		// 1.1、解析WorkBook
		Workbook bookTmpl = null;
		bookTmpl = new XSSFWorkbook(new FileInputStream(fileTmpl));
		// 1.2、解析模板里面的sheet
		Sheet sheetTmpl = bookTmpl.getSheetAt(0);
		// 1.3、解析sheet模板里面的标题行
		Row rowHeaderTmpl = sheetTmpl.getRow(0);
		// 1.4、解析sheet模板里面的数据行
		Row rowDataTmpl = sheetTmpl.getRow(1);
		
		// 2、按照模板创建book中的sheet/row/cell
		Sheet sheet = book.createSheet(sheetTmpl.getSheetName());
		//2.1、设置列宽
		for(int i = 0; i < rowHeaderTmpl.getLastCellNum(); i ++) {
			sheet.setColumnWidth(i, sheetTmpl.getColumnWidth(i));
		}
		// 2.2、创建标题行
		ExcelUtils.createRowByTmpl(rowHeaderTmpl, sheetTmpl, 0, true);
		for(int i = 0; i < employees.size(); i ++) {
			Employee employee = employees.get(i);
			Row rowData = ExcelUtils.createRowByTmpl(rowDataTmpl, sheet, i + 1, false);
			
			rowData.getCell(0).setCellValue(employee.getId());
			rowData.getCell(1).setCellValue(employee.getEmployName());
			rowData.getCell(2).setCellValue(employee.getSex());
			rowData.getCell(3).setCellValue(employee.getNo());
			rowData.getCell(4).setCellValue(employee.getMobile());
			rowData.getCell(5).setCellValue(employee.getPosition());
			if (employee.getIdCard() != null) {
				rowData.getCell(6).setCellValue(employee.getIdCard());
			}else {
				rowData.getCell(6).setCellValue("");
			}
			
		}
	}

}
