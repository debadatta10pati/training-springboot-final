package com.training.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.insurance.model.Insurance;
import com.training.insurance.repository.MyInsuranceRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value=" Insurance Controller", description=" Insurance data controller used for fetching insurance data")
@RestController
public class InsuranceController {

	@Autowired
	MyInsuranceRepository myInsuranceRepository;
	
	
	@ApiOperation(value=" Get list of all insurances", response=Iterable.class, tags="allinsurance")
	@GetMapping("/allinsurances")
	public List<Insurance> getAllInsurances()

	{
		return myInsuranceRepository.findAll();
	}
	
	@ApiOperation(value=" Fetch insurance by type", response=Object.class, tags="bytype")
	@GetMapping("/insurancebytype/{type}")
	public Insurance getInsuranceByType(@PathVariable String type)

	{
		return myInsuranceRepository.findByInsuranceType(type);
	}
	
	
	@PostMapping("/newinsurance")
	public Insurance newInsuranceApplication(@RequestBody Insurance insurance )

	{
		return myInsuranceRepository.save(insurance);

	}
}
