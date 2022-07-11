package com.training.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.insurance.model.Insurance;

public interface MyInsuranceRepository extends JpaRepository<Insurance, Long> {

	public Insurance findByInsuranceType(String type);
}
