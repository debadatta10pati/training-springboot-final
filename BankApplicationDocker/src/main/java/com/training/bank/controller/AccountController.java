package com.training.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@GetMapping("/myaccount")
	public long getAccount()
	{
		return 80901234;
	}
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "welcome to you account dashboard";
	}


}
