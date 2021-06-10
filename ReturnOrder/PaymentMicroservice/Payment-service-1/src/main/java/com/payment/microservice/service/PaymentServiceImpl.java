package com.payment.microservice.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.microservice.dto.PaymentDTO;
import com.payment.microservice.exception.InvalidFormatException;
import com.payment.microservice.model.PaymentDetails;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService{
	

	
	@Autowired
	private PaymentDetails paymentDetails;
    @Override
	public PaymentDTO processPaymentService(String RequestId,Integer cardNumber,Integer creditLimit,Integer processingCharge) throws InvalidFormatException{
		log.info("Payment service started");
		
			try {
				paymentDetails.setCardNumber(cardNumber);
				paymentDetails.setRequestId(RequestId);
				paymentDetails.setCreditLimit(creditLimit-processingCharge);
				paymentDetails.setProcessingCharge(processingCharge);
				
			} catch (Exception e) {
				throw new InvalidFormatException("Wrong type of the input provided...");
			}
			
		
		
		
		
		log.info("Payment service ended");
		return new PaymentDTO( (double)paymentDetails.getCreditLimit());
		
		
	}

}
