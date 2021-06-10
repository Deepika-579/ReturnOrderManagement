package com.payment.microservice.service;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;


import com.payment.microservice.model.PaymentDetails;

@SpringBootTest
public class PaymentServiceImplTest {
	
	PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();

	PaymentDetails paymentDetails = new PaymentDetails();

	@Test
    @DisplayName("Checking if [PaymentServiceImpl] is loading or not.")
   void paymentServiceImplIsLoaded(){
        assertThat(paymentServiceImpl).isNotNull();    
    }
	@Test
	void testProcessPaymentService() {
		paymentDetails.setCardNumber(12345);
		paymentDetails.setRequestId("abc123");
		paymentDetails.setCreditLimit(500);
		paymentDetails.setProcessingCharge(100);
		
		
		 assertThat(paymentServiceImpl).isNotNull();
	}

}
