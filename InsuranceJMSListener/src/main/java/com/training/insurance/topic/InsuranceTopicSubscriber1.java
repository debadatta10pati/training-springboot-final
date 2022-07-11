package com.training.insurance.topic;

import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class InsuranceTopicSubscriber1 {


	@JmsListener(destination = "sbc.topic")
	public void receiveInsuranceApplicant(final Message message)
	
	{
		
		System.out.println(" Message received by subscriber 1 "+message );
		
	}
	
}
