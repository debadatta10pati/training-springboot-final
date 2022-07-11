package com.training.insurance.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.insurance.dto.InsuranceApplicantDto;

@Service
public class ApplicantService {

	String getApplicantByPersonalId = "httP://localhost:8080/applicant/applicant?personalId=";

	String newApplication = "httP://localhost:8080/applicant/createapplicant";

	public String newApplication(InsuranceApplicantDto applicant) {
		String response = null;

		RestTemplate restTemplate = new RestTemplate();

		if (applicant != null) {
			if (applicant.getPersonalId() != null) {

				// Get existing applicant
				InsuranceApplicantDto existingApplicant = restTemplate.getForObject(
						getApplicantByPersonalId + applicant.getPersonalId(), InsuranceApplicantDto.class);

				if (existingApplicant != null) {
					response = "You already have applied.";
				} else {
					restTemplate.postForObject(newApplication, applicant, InsuranceApplicantDto.class);

					response = " Your application has been registered. One of our executives will reach you.";
				}
			} else {
				response = " Please provide your personal Id";
			}

		}

		return response;
	}

	public String getInsurancePremium(String personalId) {
		String response = null;

		RestTemplate restTemplate = new RestTemplate();

		long carPremium = 300;
		long lifePremium = 200;
		long homePremium = 500;

		long premium = 0L;

		if (personalId != null) {
			InsuranceApplicantDto existingApplicant = restTemplate.getForObject(getApplicantByPersonalId + personalId,
					InsuranceApplicantDto.class);

			if (existingApplicant.getInsuranceType().equals("Car")) {
				premium = carPremium;
			} else if (existingApplicant.getInsuranceType().equals("Home")) {
				premium = homePremium;
			} else if (existingApplicant.getInsuranceType().equals("Life")) {
				premium = lifePremium;
			}

			if ((existingApplicant.getAge() > 60) || (existingApplicant.getAge() < 21)) {
				premium = premium * 2;

			}

			else if ((existingApplicant.getMaritalStatus().equals("Married")) && (existingApplicant.getAge() > 21)
					&& (existingApplicant.getAge() < 60)) {
				premium = premium / 2;
			}

			response = "Your premium is  = " + premium;

		}
		return response;
	}
}
