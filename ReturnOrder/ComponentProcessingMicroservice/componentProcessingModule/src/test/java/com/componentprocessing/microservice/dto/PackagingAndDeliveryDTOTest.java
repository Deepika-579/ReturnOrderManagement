package com.componentprocessing.microservice.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PackagingAndDeliveryDTOTest {

	
	PackagingAndDeliveryDTO packagingAndDeliveryDTO;
	@Test
	 void testPackagingAndDeliveryDTO() {
		packagingAndDeliveryDTO = new PackagingAndDeliveryDTO();
		packagingAndDeliveryDTO.setCharge(50.0);
		assertEquals(50.0,packagingAndDeliveryDTO.getCharge());
		packagingAndDeliveryDTO=new PackagingAndDeliveryDTO(120.0);
		assertEquals(120.0,packagingAndDeliveryDTO.getCharge());
	}
}
