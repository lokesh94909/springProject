package com.lokesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="contracts")
public class Contract {
	

    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "con_type")
    private String conType;

 

    @Column(name = "supplier_name")
    private String supplierName;
    
    @Column(name = "con_des")
    private String conDes;
    
    @Column(name = "date")
    private String date;
        @Column(name = "duration")
    private String duration;
    
    public Contract() {
        
    }
    
    public Contract(String conType,String supplierName, String conDes, String date, String duration) {
        super();
        this.conType = conType;
        this.supplierName=supplierName;
        this.conDes = conDes;
        this.date = date;
        this.duration = duration;

 

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getConType() {
        return conType;
    }
    public void setConType(String conType) {
        this.conType = conType;
    }
    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName=supplierName;
    }

 

    public String getConDes() {
        return conDes;
    }
    public void setConDes(String conDes) {
        this.conDes = conDes;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

 

    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }

 

}
 

