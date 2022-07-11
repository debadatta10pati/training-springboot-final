package com.training.insurance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.insurance.model.Insurance;
import com.training.insurance.repository.MyInsuranceRepository;

@SpringBootTest
class InsuranceApplicationTests {

	@Autowired
	MyInsuranceRepository myInsuranceRepository;

	void saveInsuranceType() {

		// Instance of an object
		Insurance insurance = new Insurance();

		// Setting the values
		insurance.setInsuranceType("Life");
		insurance.setYearlyPrice(300);
		insurance.setDocument(" Identity document, Employment proof");

		// Database operation
		Insurance newInsurance = myInsuranceRepository.save(insurance);

		// Testing or verifying
		assertNotNull(newInsurance);

	}

	
	void getInsuranceListCount()

	{
		// Database operation to get the insurances
		List<Insurance> insurances = myInsuranceRepository.findAll();

		// Test the count
		assertEquals(insurances.size(), 5);

	}
	
	
	


	void verifyInsuranceType()

	{
		// Database operation to get insurance by type : custom query
		
		Insurance insurance = myInsuranceRepository.findByInsuranceType("Car");
	

		// Test the price
		assertEquals(insurance.getYearlyPrice(),100);

	}


}
