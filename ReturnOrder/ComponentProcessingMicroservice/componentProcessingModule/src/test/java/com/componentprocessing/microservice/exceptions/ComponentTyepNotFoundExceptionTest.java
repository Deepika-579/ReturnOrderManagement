package com.componentprocessing.microservice.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ComponentTyepNotFoundExceptionTest {
	ComponentTyepNotFoundException componentTyepNotFoundException = new ComponentTyepNotFoundException("Exception");
	@Test
	 void testComponentTyepNotFoundExceptionTest() {
		
		assertThat(componentTyepNotFoundException).isNotNull();    
	}
	
}
