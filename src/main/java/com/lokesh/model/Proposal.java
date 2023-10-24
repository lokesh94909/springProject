package com.lokesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proposals")
public class Proposal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "pro_id", nullable = false)
	private String proId;

	@Column(name = "supplier_name", nullable = false)
	private String supplierName;
	
	@Column(name = "pro_des")
	private String proDes;
	
	@Column(name = "date")
	private String date;
        @Column(name = "status")
	private String status;
	
	public Proposal() {
		
	}
	
	public Proposal(String proType,String supplierName, String proDes, String date, String status) {
		super();
		this.proId = proId;
		this.supplierName=supplierName;
		this.proDes = proDes;
		this.date = date;
		this.status = status;

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName=supplierName;
	}

	public String getProDes() {
		return proDes;
	}
	public void setProDes(String proDes) {
		this.proDes = proDes;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}