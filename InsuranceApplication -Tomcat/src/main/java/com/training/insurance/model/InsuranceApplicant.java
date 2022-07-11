package com.training.insurance.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InsuranceApplicant {

	@Id
	private long id;


	private String name;

	private long age;

	private String personalId;

	private String email;

	private String maritalStatus;

	private Date applicationDate;

	private String insuranceType;

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getPersonalId() {
		return personalId;
	}

	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Override
	public String toString() {
		return "InsuranceApplicant [id=" + id + ", name=" + name + ", age=" + age + ", personalId=" + personalId
				+ ", email=" + email + ", maritalStatus=" + maritalStatus + ", applicationDate=" + applicationDate
				+ ", insuranceType=" + insuranceType + "]";
	}

	
	
}
