package com.training.bcrypt.data;

public class InsuranceCustomerDto {

    private String firstName;
    private String lastName;
    private String email;
    private String otp;
    private long age;
    
	private String maritalStatus;

	private String insuranceType;


    public InsuranceCustomerDto() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}


}
