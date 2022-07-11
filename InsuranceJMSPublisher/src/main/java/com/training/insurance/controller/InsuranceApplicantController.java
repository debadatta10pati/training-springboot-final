package com.training.insurance.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.insurance.dto.InsuranceApplicantDto;
import com.training.insurance.entity.InsuranceApplicant;
import com.training.insurance.repository.InsuranceApplicantRepository;

@RestController
public class InsuranceApplicantController {
	
	@Autowired
	JmsTemplate jmsTemplate;

	@Autowired
	InsuranceApplicantRepository insuranceApplicantRepository;

	@PostMapping("/createapplicant")
	public void createApplicant(@RequestBody InsuranceApplicantDto applicant)

	{

		InsuranceApplicant insuranceEntity = new InsuranceApplicant();

		// Get the user input through Dto and set it to entity
		insuranceEntity.setFirstName(applicant.getFirstName());

		insuranceEntity.setLastName(applicant.getLastName());
		insuranceEntity.setAge(applicant.getAge());
		insuranceEntity.setInsuranceType(applicant.getInsuranceType());

		insuranceEntity.setMaritalStatus(applicant.getMaritalStatus());
		insuranceEntity.setPersonalId(applicant.getPersonalId());

		// Own logic
		insuranceEntity.setApplicationDate(new Date());
		insuranceEntity.setStatus("UnderProcess");

		insuranceApplicantRepository.save(insuranceEntity);
		
		// Send message to queue
		
		jmsTemplate.convertAndSend("sbc.queue", insuranceEntity.toString());
		
		

	}

	@RequestMapping(value = "/applicant", method = RequestMethod.GET)
	public InsuranceApplicant getApplicantbyPersonalId(@RequestParam String personalId)

	{

		return insuranceApplicantRepository.findByPersonalId(personalId);
	}
	
	@PutMapping("/updateapplicant")
	public void updateApplicantDetails(@RequestBody InsuranceApplicantDto applicant)
	
	{
		InsuranceApplicant insuranceEntity = new InsuranceApplicant();
		
		
		//Get the applicant
		insuranceEntity = insuranceApplicantRepository.findByPersonalId(applicant.getPersonalId());

		insuranceEntity.setInsuranceType(applicant.getInsuranceType());

		insuranceEntity.setMaritalStatus(applicant.getMaritalStatus());
	
		insuranceApplicantRepository.save(insuranceEntity);
		
		
	}
	
	

}
