package com.itqf.lvyou.test;

import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.itqf.lvyou.dao.MenuDao;
import com.itqf.lvyou.dao.SceneDao;
import com.itqf.lvyou.dao.UserDao;
import com.itqf.lvyou.model.Employee;
import com.itqf.lvyou.model.Guest;
import com.itqf.lvyou.model.Menu;
import com.itqf.lvyou.model.Scene;
import com.itqf.lvyou.model.User;
import com.itqf.lvyou.service.EmployeeService;
import com.itqf.lvyou.service.GuestService;
import com.itqf.lvyou.service.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)  //表示整合JUNIT4进行测试
@ContextConfiguration(locations= {"classpath:applicationContext.xml"}) //加载spring配置文件 //
public class TestDao {

	@Resource
	private MenuDao menuDao;
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private SceneDao sceneDao;
	
	@Resource
	private GuestService guestService;
	
	@Resource
	private EmployeeService employeeService;
	
	@Resource 
	private MenuService menuService;
	
	/**
	 * 测试菜单类的顶级菜单以及子菜单查询
	 */
	@Test
	@Transactional
	@Rollback(value=true)
	public void test01() {
		List<Menu> list=menuDao.getTopMenus();
		for(Menu menu:list) {
			System.out.println(menu);
		}
		
//		List<Menu> set=menuDao.getSubMenusByParent("1");
//		for(Menu m:set) {
//			System.out.println(m);
//		}
	}
	
	/**
	 * 测试按照用户名查找用户
	 */
	@Test
	@Transactional
	@Rollback(value=true)
	public void test02() {
		User user = userDao.getUserByLoginName("admin");
		// 使用断言测试dao层的数据访问
		Assert.assertEquals("1", user.getId());
	}
	
	/**
	 * 测试查询所有菜单
	 */
	@Test
	@Transactional
	@Rollback(value=true)
	public void test03() {
		List<Menu> list = menuDao.findAll();
		Assert.assertEquals(5, list.size());
	}
	
	/**
	 * 测试模糊查询菜单
	 */
	@Test
	@Transactional
	@Rollback(value=true)
	public void test04() {
		List<Menu> list = menuDao.getMenusByName("管理");
		for(Menu menu:list) {
			System.out.println(menu);
		}
	}
	
	/**
	 * 测试模糊查询菜单
	 */
	@Test
	@Transactional
	@Rollback(value=true)
	public void test05() {
		List<Menu> list = menuService.getMenusByName(" ");
		System.out.println(list.size());
		for(Menu menu:list) {
			System.out.println(menu);
		}
	}
	
	/**
	 * 测试创建游客
	 */
	@Test
	@Transactional
	@Rollback(value=false)
	public void test06() {
		Guest g1 = new Guest();
		g1.setId("1");
		g1.setMobile("17828425537");
		g1.setSex("1");
		g1.setName("王五");
		guestService.createGuest(g1);
	}
	
	/**
	 * 测试创建员工
	 */
	@Test
	@Transactional
	@Rollback(value=false)
	public void test07() {
		Scene sc=sceneDao.findById("sc1");
		Employee e=new Employee();
		/*e.setId("emp01");
		e.setEmployName("猴子01");;
		e.setMobile("123");;
		e.setScene(sc);
		employeeService.createEmployee(e);*/
		
		e.setId("emp02");
		e.setEmployName("猴子02");;
		e.setMobile("123444");;
		e.setScene(sc);
		employeeService.createEmployee(e);

	}
}
