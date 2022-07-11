package com.training.insurance.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Insurance {
	
	@Id
	private long id;
	
	private String insuranceType;
	
	private String document;
	
	private long yearlyPrice;

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

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public long getYearlyPrice() {
		return yearlyPrice;
	}

	public void setYearlyPrice(long yearlyPrice) {
		this.yearlyPrice = yearlyPrice;
	}
	
	
	

}
