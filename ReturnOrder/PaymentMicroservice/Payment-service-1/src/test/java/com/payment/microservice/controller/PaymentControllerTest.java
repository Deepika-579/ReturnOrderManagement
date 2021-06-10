package com.payment.microservice.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentControllerTest {

 PaymentController  paymentController = new PaymentController();
	
	
	@Test
    @DisplayName("Checking if [PaymentController] is loading or not.")
     void paymentControllerIsLoaded(){
        assertThat(paymentController).isNotNull();    
    }
}
