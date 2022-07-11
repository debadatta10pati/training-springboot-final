package com.training.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.insurance.entity.Insurance;
import com.training.insurance.repository.InsuranceRepository;

@RestController
public class InsuranceController {

	@Autowired
	InsuranceRepository insuranceRepository;

	
	// List of insurances. No inputs
	@GetMapping("/insurancelist")
	public List<Insurance> getInsuranceList()

	{

		return insuranceRepository.findAll();

	}
	
	
	// Insurance by type. Dynamic input
	@GetMapping("/insurancebytype/{type}")
	public Insurance getInsurancebyType(@PathVariable("type") String type)

	{

		return insuranceRepository.findByInsuranceType(type);

	}


}
