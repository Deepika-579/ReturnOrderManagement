package com.packaging.delivery.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PackagingAndDeliveryTest {

	PackagingAndDelivery packagingAndDelivery = new PackagingAndDelivery(1,10,100);

	@Test
	@DisplayName("Checking if [PackagingAndDelivery] is loading or not.")
	 void packagingAndDeliveryIsLoaded() {
		assertThat(packagingAndDelivery).isNotNull();
	}

	@Test
 void testPAD() {
		packagingAndDelivery.setId(0);
		packagingAndDelivery.setPackagingCost(50);
		packagingAndDelivery.setDeliveryCost(100);
		
		assertEquals(0,packagingAndDelivery.getId());
		assertEquals(50,packagingAndDelivery.getPackagingCost());
		assertEquals(100,packagingAndDelivery.getDeliveryCost());
		assertFalse(packagingAndDelivery.toString().isEmpty());
		

	}

}
