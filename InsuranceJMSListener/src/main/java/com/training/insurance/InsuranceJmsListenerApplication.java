package com.training.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class InsuranceJmsListenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceJmsListenerApplication.class, args);
	}

}
