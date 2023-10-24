package com.lokesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Amenities")

public class Amenitie {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "am_id", nullable = false)
	private Long amId;
	
	@Column(name = "am_people", nullable = false)
	private int amPeople;

	@Column(name = "am_hours", nullable = false)
	private int amHours;
	
	@Column(name = "am_price")
	private int amPrice;
	
	
	public Amenitie() {
		
	}
	
	public Amenitie(long amId,int amPeople, int amHours, int amPrice) {
		super();
		this.amId = amId;
		this.amPeople=amPeople;
		this.amHours=amHours;
		this.amPrice =amPrice;
		

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmId() {
		return amId;
	}

	public void setAmId(Long amId) {
		this.amId = amId;
	}

	public int getAmPeople() {
		return amPeople;
	}

	public void setAmPeople(int amPeople) {
		this.amPeople = amPeople;
	}

	public int getAmHours() {
		return amHours;
	}

	public void setAmHours(int amHours) {
		this.amHours = amHours;
	}

	public int getAmPrice() {
		return amPrice;
	}

	public void setAmPrice(int amPrice) {
		this.amPrice = amPrice;
	}
}
