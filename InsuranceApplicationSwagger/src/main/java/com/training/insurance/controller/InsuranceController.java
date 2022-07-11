package com.training.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.training.insurance.entity.Insurance;
import com.training.insurance.repository.InsuranceRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class InsuranceController {

	@Autowired
	InsuranceRepository insuranceRepository;

	
	// List of insurances. No inputs
	@ApiOperation(value="Return the list of insurances ",response=Iterable.class, tags="insurancelist")
	@GetMapping("/insurancelist")
	public List<Insurance> getInsuranceList()

	{

		return insuranceRepository.findAll();

	}
	
	
	// Insurance by type. Dynamic input
	@ApiOperation(value="Return the insurance by type ",response=Object.class, tags="insurancebytype")
	@GetMapping("/insurancebytype/{type}")
	public Insurance getInsurancebyType(@PathVariable("type") String type)

	{

		return insuranceRepository.findByInsuranceType(type);

	}


}
