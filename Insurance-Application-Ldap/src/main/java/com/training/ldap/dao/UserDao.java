package com.training.ldap.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.ldap.model.Customer;

@Repository
public interface UserDao extends CrudRepository<Customer, Long> {
}
