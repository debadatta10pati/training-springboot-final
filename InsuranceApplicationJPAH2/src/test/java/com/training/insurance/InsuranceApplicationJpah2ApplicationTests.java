package com.training.insurance;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.insurance.entity.Insurance;
import com.training.insurance.repository.InsuranceRepository;

@SpringBootTest
class InsuranceApplicationJpah2ApplicationTests {

	@Autowired
	InsuranceRepository insuranceRepository;
	
	
	
	@Test
	void testListOfInsurances() {
		
		//Entity class 
		Insurance insurance = new Insurance();
		
		insurance.setInsuranceType("Home");
		insurance.setPrice(450);
		insurance.setDurationInMonths(12);
		
		//Database operation to create the record
		insuranceRepository.save(insurance);
		
		//Find the list of records
		List<Insurance> savedInsurance = insuranceRepository.findAll();
		
		
		//Test
		
		assertNotNull(savedInsurance);
		
	}

}
