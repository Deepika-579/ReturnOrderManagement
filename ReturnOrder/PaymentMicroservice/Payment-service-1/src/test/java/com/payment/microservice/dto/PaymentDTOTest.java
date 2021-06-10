package com.payment.microservice.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class PaymentDTOTest {
	
	PaymentDTO paymentDTO;
	@Test
	 void testPaymentDTO() {
		paymentDTO=new PaymentDTO();
		paymentDTO.setCharge(50.0);
		assertEquals(50.0,paymentDTO.getCharge());
		paymentDTO = new PaymentDTO(150.0);
		assertEquals(150.0,paymentDTO.getCharge());
	}

}
