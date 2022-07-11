package com.training.ldap.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.ldap.dao.UserDao;
import com.training.ldap.dto.CustomerDto;
import com.training.ldap.model.Customer;
import com.training.ldap.service.UserService;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<CustomerDto> findAll() {
        List<CustomerDto> customers = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(customer -> customers.add(customer.copyValuesFromEntitytoDto()));
        return customers;
    }

    @Override
    public Customer findOne(long id) {
        return userDao.findById(id).get();
    }
}
