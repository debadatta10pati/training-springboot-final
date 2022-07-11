package com.training.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Insurance {
	
	@Id
	private long id;
	
	private String insuranceType;

	private long price;

	private long durationInMonths;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getDurationInMonths() {
		return durationInMonths;
	}

	public void setDurationInMonths(long durationInMonths) {
		this.durationInMonths = durationInMonths;
	}
	
	
	
	

}
