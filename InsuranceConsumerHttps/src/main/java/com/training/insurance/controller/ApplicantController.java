package com.training.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.insurance.dto.InsuranceApplicantDto;
import com.training.insurance.service.ApplicantService;

@RestController
public class ApplicantController {
	
	@Autowired
	ApplicantService applicantService;
	
	@PostMapping("/application")
	public ResponseEntity applyInsurance(@RequestBody InsuranceApplicantDto applicant)
	
	{
		
		String response = applicantService.newApplication(applicant);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/premium/{personalId}")
	public ResponseEntity getPremium(@PathVariable("personalId") String personalId)
	
	{
		
		String response = applicantService.getInsurancePremium(personalId);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

}
