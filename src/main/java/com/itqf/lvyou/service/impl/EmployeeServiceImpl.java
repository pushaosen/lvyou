package com.itqf.lvyou.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.itqf.lvyou.WoException;
import com.itqf.lvyou.WoResultCode;
import com.itqf.lvyou.dao.EmployeeDao;
import com.itqf.lvyou.dao.UserDao;
import com.itqf.lvyou.model.Employee;
import com.itqf.lvyou.model.User;
import com.itqf.lvyou.service.EmployeeService;

@SuppressWarnings("all")
@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeDao employeeDao;
	
	@Resource
	private UserDao userDao;
	
	private final static WoResultCode REPEAT_1 = new WoResultCode(4001, "电话号码已经存在!");
	
	private final static WoResultCode REPEAT_2 = new WoResultCode(4002, "工号已经存在!");
	
	private final static WoResultCode REPEAT_3 = new WoResultCode(4003, "身份证号已经存在!");
	
	private final static WoResultCode REPEAT_4 = new WoResultCode(4003, "编号已经存在!");


	@Override
	public List<Employee> getEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public Employee getEmployeeById(String employeeId) {
		return employeeDao.findById(employeeId);
	}

	@Override
	public List<Employee> getEmployeeList(String name, String phone, String idCard) {
		if (StringUtils.isEmpty(name) && StringUtils.isEmpty(phone) && StringUtils.isEmpty(idCard)) {
			return this.getEmployees();
		}
		return employeeDao.getEmployeeList(name,phone,idCard);
	}

	@Override
	public void deleteEmployees(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			Employee e = this.getEmployeeById(ids[i]);
			employeeDao.delete(e);
		}
	}

	@Override
	public void createEmployee(Employee employee) {
		/*if(employeeDao.findById(employee.getId()) != null) {
			throw new WoException(REPEAT_4);
		}
		if(employeeDao.findByCard(employee.getNo()) != null) {
			throw new WoException(REPEAT_2);
		}
		if(employeeDao.findByPhone(employee.getMobile()) != null) {
			throw new WoException(REPEAT_1);
		}else {
			if(StringUtils.isEmpty(employee.getIdCard())) {
				employeeDao.createEmployee(employee);
			}else {
				if (employeeDao.findIdCard(employee.getIdCard()) != null) {
					throw new WoException(REPEAT_3);
				}else {
					employeeDao.createEmployee(employee);
				}
			}
		}*/
		User user = userDao.getUserByLoginName(employee.getMobile());
		if (user == null) {
			user = new User();
			user.setId(UUID.randomUUID().toString());
			user.setLoginName(employee.getMobile());
			userDao.create(user);
		}
		employee.setUser(user);
		employeeDao.create(employee);;
	}
	
	@Override
	public void updateEmployee(Employee employee) {
		/*Employee employeeByCard = employeeDao.findByCard(employee.getNo());
		Employee employeeByPhone = employeeDao.findByPhone(employee.getMobile());
		
		if( employeeByCard != null && !employeeByCard.getId().equals(employee.getId())) {
			throw new WoException(REPEAT_2);
		}
		if(employeeByPhone != null && !employeeByPhone.getId().equals(employee.getId())) {
			throw new WoException(REPEAT_1);
		}else {
			if(StringUtils.isEmpty(employee.getIdCard())) {
				employeeDao.updateEmployee(employee);
			}else {
				Employee employeeByIdCard = employeeDao.findIdCard(employee.getIdCard());
				if (employeeByIdCard != null && !employeeByIdCard.getId().equals(employee.getId())) {
					throw new WoException(REPEAT_3);
				}else {
					employeeDao.updateEmployee(employee);
				}
			}
		}*/
	}

	@Override
	public void importEmployees(List<Employee> employees) {
		for(Employee employee:employees) {
			this.createEmployee(employee);
		}
	}
	
}
