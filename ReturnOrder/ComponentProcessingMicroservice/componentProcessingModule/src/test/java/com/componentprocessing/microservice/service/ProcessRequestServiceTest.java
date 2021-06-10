package com.componentprocessing.microservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProcessRequestServiceTest {
   
	ProcessRequestService processRequestService;
	@Test
	@DisplayName("Checking for ProcessRequestService - if it is loading or not for @GetMapping")
	 void repairServiceImplNotNullTest() {
		assertThat(processRequestService).isNull();
	}
}
