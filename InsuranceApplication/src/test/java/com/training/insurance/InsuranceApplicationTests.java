package com.training.insurance;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.insurance.dto.InsuranceDto;

@SpringBootTest
class InsuranceApplicationTests {
	

	//Testing the method
	@Test
	void checkIfWeHaveInsurances() {
		
		InsuranceDto insuranceDto = new InsuranceDto();
		
		//Setting values
		insuranceDto.setInsuranceType("Home");
		
		insuranceDto.setDurationInMonths(12);
		insuranceDto.setPrice(500);
		
		//Creating a list
		List<InsuranceDto> insuranceList = new ArrayList<InsuranceDto>();
		
		insuranceList.add(insuranceDto);
		
		//Testing
		assertNotNull(insuranceList);
	}

}
