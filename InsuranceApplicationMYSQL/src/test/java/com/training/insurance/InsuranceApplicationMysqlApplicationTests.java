package com.training.insurance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.insurance.entity.Insurance;
import com.training.insurance.repository.InsuranceRepository;

@SpringBootTest
class InsuranceApplicationMysqlApplicationTests {

	@Autowired
	InsuranceRepository insuranceRepository;

	// @Test
	void testListOfInsurances() {

		// Entity class
		Insurance insurance = new Insurance();

		insurance.setInsuranceType("Life");
		insurance.setPrice(200);
		insurance.setDurationInMonths(18);

		// Database operation to create the record
		insuranceRepository.save(insurance);

		// Find the list of records
		List<Insurance> savedInsurance = insuranceRepository.findAll();

		// Test

		assertNotNull(savedInsurance);

	}

	//@Test
	void testInsuranceDetails()

	{
		
		Insurance insuranceDetails = insuranceRepository.findByInsuranceType("Home");	
		
		assertEquals(insuranceDetails.getPrice(),400);
	}
	
	@Test
	void testInsuranceCount()

	{
		
		List<Insurance> insurances = insuranceRepository.findAll();
		
		assertEquals(insurances.size(),6);
	}
	
	
	
	
	
	
	
	
	
	
	

}
