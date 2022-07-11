package com.training.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.insurance.entity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

	Insurance findByInsuranceType(String type);

}
