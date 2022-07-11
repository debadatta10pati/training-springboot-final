package com.training.insurance.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.insurance.dto.InsuranceApplicantDto;

@Service
public class ApplicantService {
	
	String getApplicantByPersonalId = "https://localhost:8443/applicant?personalId=";

	String newApplication = "https://localhost:8443/createapplicant";

	public String newApplication(InsuranceApplicantDto applicant) {
		String response = null;

		
		SSLContext sslContext;
		try {
			sslContext = new SSLContextBuilder()
					.loadTrustMaterial(new URL("file:src/main/resources/training.p12"), "Deba2021".toCharArray()).build();
			SSLConnectionSocketFactory sslConFactory = new SSLConnectionSocketFactory(sslContext);

			CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslConFactory).build();
			ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
			RestTemplate restTemplate = new RestTemplate(requestFactory);

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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
