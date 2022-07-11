package com.training.bcrypt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.bcrypt.entity.InsuranceCustomerEntity;
import com.training.bcrypt.repository.InsuranceCustomerRepository;

@RestController
public class InsuranceApplicantController {

	@Autowired
	InsuranceCustomerRepository myInsuranceApplicantRepository;
	

	@RequestMapping(value="/checkapplications",method=RequestMethod.GET)
	public List<InsuranceCustomerEntity> checkApplications() {

		return myInsuranceApplicantRepository.findAll();
	}
}
