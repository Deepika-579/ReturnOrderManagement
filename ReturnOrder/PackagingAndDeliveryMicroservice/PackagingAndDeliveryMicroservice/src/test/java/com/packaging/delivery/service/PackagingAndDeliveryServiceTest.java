package com.packaging.delivery.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PackagingAndDeliveryServiceTest {
	@Autowired
	PackagingAndDeliveryService packagingAndDeliveryService;
	@Test
    @DisplayName("Checking if [PackagingAndDeliveryService] is loading or not.")
     void padControllerIsLoaded(){
        assertThat(packagingAndDeliveryService).isNotNull();    
    }

}
