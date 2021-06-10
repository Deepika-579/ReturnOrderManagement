package com.payment.microservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentDetailsTest {
	PaymentDetails paymentDetails;
	
	@Test
	void testPaymentDetails() {
		paymentDetails = new PaymentDetails();
		paymentDetails.setRequestId("ab123");
		paymentDetails.setCardNumber(12345);
		paymentDetails.setCreditLimit(50000);
		paymentDetails.setProcessingCharge(100);
		assertEquals("ab123",paymentDetails.getRequestId());
		assertEquals(12345,paymentDetails.getCardNumber());
		assertEquals(50000,paymentDetails.getCreditLimit());
		assertEquals(100,paymentDetails.getProcessingCharge());
		paymentDetails = new PaymentDetails("ab123",12345,50000,100);
		assertEquals(100,paymentDetails.getProcessingCharge());
	}
}
