package com.training.insurance.queue;

import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class InsuranceQueueListener {
	
	@JmsListener(destination = "sbc.queue")
	public void receiveInsuranceApplicant(final Message message)
	
	{
		
		System.out.println(" New applicant registered "+message );
		
	}

}
