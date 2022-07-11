package com.training.insurance.dto;

public class InsuranceDto {

	private String insuranceType;

	private long price;

	private long durationInMonths;

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
