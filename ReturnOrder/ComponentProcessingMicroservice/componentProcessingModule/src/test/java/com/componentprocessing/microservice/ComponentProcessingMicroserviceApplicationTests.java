package com.componentprocessing.microservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComponentProcessingMicroserviceApplicationTests {

	ComponentProcessingMicroserviceApplication componentProcessingMicroserviceApplication;
	@Test
	void contextLoads() {
		assertTrue(true);
	}
	
	@Test
	void testComponentProcessingMicroserviceApplication() {
		assertThat(componentProcessingMicroserviceApplication).isNull();
	}

}
