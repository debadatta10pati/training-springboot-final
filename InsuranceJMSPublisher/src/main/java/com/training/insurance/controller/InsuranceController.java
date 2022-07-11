package com.training.insurance.controller;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.insurance.entity.Insurance;
import com.training.insurance.repository.InsuranceRepository;

@RestController
public class InsuranceController {

	@Autowired
	InsuranceRepository insuranceRepository;

	@Autowired
	JmsTemplate jmsTemplate;
	
	// List of insurances. No inputs
	@GetMapping("/insurancelist")
	public List<Insurance> getInsuranceList()

	{

		return insuranceRepository.findAll();

	}
	
	@PostMapping("/newinsurance")
	public void createNewInsurance(@RequestBody Insurance insurance)

	{

		 insuranceRepository.save(insurance);
		 
		 
		 Topic insuranceTopic;
		 
		 
		 try {
			insuranceTopic = jmsTemplate.getConnectionFactory().createConnection().createSession().createTopic("sbc.topic");
			jmsTemplate.convertAndSend(insuranceTopic, insurance.toString());
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 

	}
	
	
	
	// Insurance by type. Dynamic input
	@GetMapping("/insurancebytype/{type}")
	public Insurance getInsurancebyType(@PathVariable("type") String type)

	{

		return insuranceRepository.findByInsuranceType(type);

	}


}
