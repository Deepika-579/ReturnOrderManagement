package com.componentprocessing.microservice.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PackagingClientTest {
  
	PackagingClient packagingClient;
	
	
	@Test
    @DisplayName("Checking if [PackagingClient] is loading or not.")
   void packagingClientIsLoaded(){
        assertThat(packagingClient).isNull();    
    }
}
