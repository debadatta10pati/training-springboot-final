package com.training.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.insurance.model.InsuranceApplicant;

public interface MyInsuranceApplicantRepository extends JpaRepository<InsuranceApplicant, Long> {
	
	
	public InsuranceApplicant findByEmail(String email);
	
	public List<InsuranceApplicant> findByMaritalStatus(String maritalStatus);
}
