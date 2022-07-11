package com.training.ldap.service;

import java.util.List;

import com.training.ldap.dto.CustomerDto;
import com.training.ldap.model.Customer;

public interface UserService {

    List<CustomerDto> findAll();
    Customer findOne(long id);
}
