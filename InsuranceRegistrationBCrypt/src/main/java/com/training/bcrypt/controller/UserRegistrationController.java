package com.training.bcrypt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.training.bcrypt.data.InsuranceCustomerDto;
import com.training.bcrypt.service.CustomerService;

@Controller
public class UserRegistrationController {

    private static final String REGISTRATION_CONFIRMATION_PAGE ="registrationConfirmation";

    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/register")
    public String getRegistrationView(){
        return "registration";
    }

    @PostMapping("/register")
    public String customerRegistration(final InsuranceCustomerDto customer, final Model model){
         customerService.registerCustomer(customer);
         return REGISTRATION_CONFIRMATION_PAGE;
    }
}
