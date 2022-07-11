package com.training.insurance.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.insurance.model.InsuranceApplicant;
import com.training.insurance.repository.MyInsuranceApplicantRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/applicants")
@Api(value="Insurance Applicant Controller",description=" My insurance application controller")
public class InsuranceApplicantController {

	@Autowired
	MyInsuranceApplicantRepository myInsuranceApplicantRepository;
	
	@Autowired
	JmsTemplate jmsTemplate;

	//@PostMapping("/newinsuranceapplication")
	@ApiOperation(value=" Apply for a new insurance", response=Object.class, tags="newapplication")
	@RequestMapping(value="/newinsuranceapplication",method=RequestMethod.POST)
	public ResponseEntity newInsuranceApplication(@RequestBody InsuranceApplicant customer) {
		
		String response = "Your application has been received. One of our executives will reach out to you";
		customer.setApplicationDate(new Date());

		myInsuranceApplicantRepository.save(customer);
		
		//Queue
		jmsTemplate.convertAndSend("insurance.queue", customer.toString());
		
		// Topic
		
		Topic insurancetopic;
		try {
			insurancetopic = jmsTemplate.getConnectionFactory().createConnection()
					.createSession().createTopic("insurance.topic");
			jmsTemplate.convertAndSend(insurancetopic, customer.toString());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	
	//@GetMapping("/insurancebyemail/{email}")
	@ApiOperation(value=" Fetch insurance by email", response=Object.class, tags="byemail")
	@RequestMapping(value="/insurancebyemail",method=RequestMethod.GET)
	public InsuranceApplicant getInsuranceApplicantByEmail(@RequestParam String email) {

		InsuranceApplicant applicant = myInsuranceApplicantRepository.findByEmail(email);

		return applicant;
	}
	
	@ApiOperation(value=" Fetch insurance by marital status where age is older than given age", response=Object.class, tags="bymaritalstatusandage")
	@GetMapping("/insurancebymaritalstatusandage/{maritalstatus}/{age}")
	public List<InsuranceApplicant> getInsuranceApplicantBymaritalStatusandAge(@PathVariable String maritalstatus, @PathVariable long age) {

		List<InsuranceApplicant> applicants = myInsuranceApplicantRepository.findByMaritalStatus(maritalstatus);

		List<InsuranceApplicant> finalApplicants = new ArrayList<InsuranceApplicant>();
		
		for(int i=0;i<applicants.size();i++)
		{
			if(applicants.get(i).getAge()>age)
			{
				finalApplicants.add(applicants.get(i));
			}
			
			
		}
		
		return finalApplicants;
	}
	

}
