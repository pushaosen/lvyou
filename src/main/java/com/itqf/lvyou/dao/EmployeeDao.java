package com.itqf.lvyou.dao;

import java.util.List;

import com.itqf.lvyou.model.Employee;

/**
 * Employee访问数据库
 * @author Administrator
 *
 */
public interface EmployeeDao extends BaseDao<Employee, String> {

	/**
	 * 根据姓名、电话、身份证进行模糊查询
	 * @param name
	 * @param idCard 
	 * @param phone 
	 * @return
	 */
	public abstract List<Employee> getEmployeeList(String name, String phone, String idCard);

	/**
	 * 按照工号查询员工信息
	 * @param card
	 * @return
	 */
	public abstract Employee findByCard(String card);

	/**
	 * 按照电话号查询员工信息
	 * @param phone
	 * @return
	 */
	public abstract Employee findByPhone(String phone);

	/**
	 * 按照身份证号查询员工信息
	 * @param idCard
	 * @return
	 */
	public abstract Employee findIdCard(String idCard);
}
