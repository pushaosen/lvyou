package com.itqf.lvyou.service;

import java.util.List;

import com.itqf.lvyou.model.Employee;

/**
 * Employee业务逻辑处理
 * @author Administrator
 *
 */
public interface EmployeeService {

	/**
	 * 获取所有员工信息
	 * @return
	 */
	public abstract List<Employee> getEmployees();

	/**
	 * 根据员工ID查询员工信息
	 * @param employeeId
	 * @return
	 */
	public abstract Employee getEmployeeById(String employeeId);

	/**
	 * 根据姓名、电话、身份证进行模糊查询
	 * @param name
	 * @param idCard 
	 * @param phone 
	 * @return
	 */
	public abstract List<Employee> getEmployeeList(String name, String phone, String idCard);

	/**
	 * 删除员工信息
	 * @param ids
	 */
	public abstract void deleteEmployees(String[] ids);

	
	/**
	 * 判断创建员工的时候的重复信息
	 * @param employee
	 */
	public abstract void createEmployee(Employee employee);

	/**
	 * 修改员工
	 * @param employee
	 */
	public abstract void updateEmployee(Employee employee);

	/**
	 * 批量导入xls表格中的数据存入数据库
	 * @param employees
	 */
	public abstract void importEmployees(List<Employee> employees);

}
