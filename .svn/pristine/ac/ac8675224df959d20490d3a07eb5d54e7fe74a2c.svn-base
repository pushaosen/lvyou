package com.itqf.lvyou.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 购票类型实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="ly_tickettype")
public class TicketType {
	
	/**
	 * 票的ID
	 */
	@Id
	@Column(length=50)
	private String id;
	
	/**
	 * 票的名称
	 */
	@Column(length=20)
	private String name;
	
	/**
	 * 票的价格
	 */
	@Column(length=10)
	private String price;

	@OneToMany(mappedBy="tickettype")
	private List<TicketRecord> ticketRecords;
	
	@ManyToOne
	@JoinColumn(name="scene_id")
	private Scene scene;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<TicketRecord> getTicketRecords() {
		return ticketRecords;
	}

	public void setTicketRecords(List<TicketRecord> ticketRecords) {
		this.ticketRecords = ticketRecords;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
}

