package com.lokesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="delivery")
public class Delivery {
	
	@Id
	@Column(name="del_id", nullable=false)
	private long id;
	@Column(name = "del_status", nullable = false)
	private String status;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Delivery(String status,long id) {
		super();
		this.id = id;
		this.status = status;	
	
}
	public Delivery() {
		// TODO Auto-generated constructor stub
	}
	
}
