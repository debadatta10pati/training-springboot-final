package com.training.bcrypt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.bcrypt.entity.InsuranceCustomerEntity;
import com.training.bcrypt.repository.InsuranceCustomerRepository;


@Service("customUserService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private InsuranceCustomerRepository insuranceCustomerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         final InsuranceCustomerEntity customer = insuranceCustomerRepository.findByEmail(username);
         if(customer ==null){
             throw new UsernameNotFoundException(username);
         }
        UserDetails user = User.withUsername(customer.getEmail()).password(customer.getOtp()).authorities("USER").build();
        return user;
    }
}
