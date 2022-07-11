package com.training.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.training.insurance.config.AppProperties;
import com.training.insurance.entity.Insurance;
import com.training.insurance.repository.InsuranceRepository;

@RestController
public class InsuranceController {

	@Autowired
	InsuranceRepository insuranceRepository;
	
	@Autowired
	AppProperties appProperties;

	@Value("${app.user}")
	private String user;
	
	@Value("${app.password}")
	private String password;
	
	
	// List of insurances. No inputs
	@GetMapping("/insurancelist")
	public List<Insurance> getInsuranceList()

	{
		System.out.println(" Custom properties : + user = "+appProperties.getUser()+ " password = "+appProperties.getPassword() );

		return insuranceRepository.findAll();

	}
	
	
	// Insurance by type. Dynamic input
	@GetMapping("/insurancebytype/{type}")
	public Insurance getInsurancebyType(@PathVariable("type") String type)

	{
		System.out.println(" Custom properties from value annotation : user = "+user+" password = "+password);
		
		return insuranceRepository.findByInsuranceType(type);

	}


}
