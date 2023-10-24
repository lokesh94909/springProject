package com.lokesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requirements")
public class Requirement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "req_type", nullable = false)
	private String reqType;
	
	@Column(name = "req_des")
	private String reqDes;
	
	@Column(name = "date")
	private String date;
	
	public Requirement() {
		
	}
	
	public Requirement(String reqType, String reqDes, String date) {
		super();
		this.reqType = reqType;
		this.reqDes = reqDes;
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	public String getReqDes() {
		return reqDes;
	}
	public void setReqDes(String reqDes) {
		this.reqDes = reqDes;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
