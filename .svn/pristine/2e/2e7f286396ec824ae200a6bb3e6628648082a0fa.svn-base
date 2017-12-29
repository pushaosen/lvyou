package com.itqf.lvyou.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="sys_user")
public class User {

	@Column(length=50,name="id")
	@Id
	private String id;
	
	@Column(length=20)
	private String loginName;
	
	@Column(length=50)
	private String password = "123456";
	
	@Column(length=200)
	private String headImage;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yy:MM:dd HH:mm:ss")
	private Date createTime;
	
	@OneToOne(mappedBy="user")
	private Guest guest;
	
	@OneToOne(mappedBy="user")
	private Employee employee;
	
	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 判断是否是管理员
	 * @return
	 */
	public Boolean isAdmin() {
		return "admin".equals(this.getLoginName());
	}
}
