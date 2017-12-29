package com.itqf.lvyou.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 购票记录实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="ly_ticketrecord")
public class TicketRecord {
	/**
	 * ID
	 */
	@Id
	@Column(length=50)
	private String id;
	
	/**
	 * 说明
	 */
	@Column(length=200)
	private String instruction;
	
	/**
	 * 购票时间
	 */
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date time;

	@ManyToOne
	@JoinColumn(name="tickettype_id")
	private TicketType tickettype;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="guest_id")
	private Guest guest;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public TicketType getTickettype() {
		return tickettype;
	}

	public void setTickettype(TicketType tickettype) {
		this.tickettype = tickettype;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}
}

