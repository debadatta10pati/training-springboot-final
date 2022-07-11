package com.training.ldap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.training.ldap.dto.CustomerDto;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "MARITALSTATUS")
    private String maritalStatus;
    
    @Column(name = "INSURANCETYPE")
    private String insuranceType;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public CustomerDto copyValuesFromEntitytoDto(){
    	CustomerDto customerDto = new CustomerDto();
    	customerDto.setId(this.id);
    	customerDto.setEmail(this.email);
    	customerDto.setFirstName(this.firstName);
    	customerDto.setLastName(this.lastName);
    	customerDto.setUsername(this.username);
    	customerDto.setMaritalStatus(this.maritalStatus);
    	customerDto.setInsuranceType(this.insuranceType);
        return customerDto;
    }
}
