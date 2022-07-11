package com.training.bcrypt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.bcrypt.entity.InsuranceCustomerEntity;


@Repository
public interface InsuranceCustomerRepository extends JpaRepository<InsuranceCustomerEntity,Long> {
	InsuranceCustomerEntity findByEmail(String email);
}
