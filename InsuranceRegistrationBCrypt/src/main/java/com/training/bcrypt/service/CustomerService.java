package com.training.bcrypt.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.training.bcrypt.data.InsuranceCustomerDto;
import com.training.bcrypt.entity.InsuranceCustomerEntity;
import com.training.bcrypt.repository.InsuranceCustomerRepository;

@Service("customerService")
public class CustomerService {

	@Autowired
	private InsuranceCustomerRepository insuranceCustomerRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public InsuranceCustomerEntity registerCustomer(final InsuranceCustomerDto customerData) {
		InsuranceCustomerEntity customer = new InsuranceCustomerEntity();
		customer.setFirstName(customerData.getFirstName());
		customer.setLastName(customerData.getLastName());
		customer.setEmail(customerData.getEmail());
		customer.setAge(customerData.getAge());
		customer.setMaritalStatus(customerData.getMaritalStatus());
		customer.setInsuranceType(customerData.getInsuranceType());
		customer.setOtp(passwordEncoder.encode(customerData.getOtp()));
		customer.setApplicationDate(new Date());
		customer.setStatus("Under Process");

		return insuranceCustomerRepository.save(customer);
	}
}
