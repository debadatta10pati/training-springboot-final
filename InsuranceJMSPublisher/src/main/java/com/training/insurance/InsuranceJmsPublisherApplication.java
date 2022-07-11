package com.training.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class InsuranceJmsPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceJmsPublisherApplication.class, args);
	}

}
