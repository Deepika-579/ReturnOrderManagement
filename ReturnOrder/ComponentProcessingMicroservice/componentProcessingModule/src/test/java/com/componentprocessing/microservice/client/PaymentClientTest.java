package com.componentprocessing.microservice.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentClientTest {
	
PaymentClient paymentClient;
	
	
	@Test
    @DisplayName("Checking if [PaymentClient] is loading or not.")
    void paymentClientIsLoaded(){
        assertThat(paymentClient).isNull();    
    }

}
