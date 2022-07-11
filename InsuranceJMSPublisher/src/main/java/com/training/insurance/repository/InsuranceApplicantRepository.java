package com.training.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.insurance.entity.InsuranceApplicant;

public interface InsuranceApplicantRepository extends JpaRepository<InsuranceApplicant, Long> {

	InsuranceApplicant findByPersonalId(String personalId);

}
