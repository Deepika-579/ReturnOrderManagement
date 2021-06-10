package com.packaging.delivery.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class PackagingAndDeliveryServiceImplTest {
	
	@Autowired
	private PackagingAndDeliveryServiceImpl padServiceImpl;

	@Test
    @DisplayName("Checking if [PADServiceImpl] is loading or not.")
    void padControllerIsLoaded(){
        assertThat(padServiceImpl).isNotNull();    
    }
	@Test
    @DisplayName("Checking CalculatePackagingAndDeliveryCharge()")
    void testCalculatePackagingAndDeliveryCharge() {
		
		
		assertEquals(150,padServiceImpl.calculatePackagingAndDeliveryCharge("accessory", 1).getCharge());
		assertEquals(300,padServiceImpl.calculatePackagingAndDeliveryCharge("integral", 1).getCharge());
		assertEquals(250,padServiceImpl.calculatePackagingAndDeliveryCharge("Protective sheath", 1).getCharge());
		
	}

}
