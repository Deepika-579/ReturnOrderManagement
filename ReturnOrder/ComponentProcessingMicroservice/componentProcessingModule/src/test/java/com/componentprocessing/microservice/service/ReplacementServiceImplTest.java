package com.componentprocessing.microservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReplacementServiceImplTest {
	
	@Autowired
	ReplacementServiceImpl replacementServiceImpl;
	List<String> li = new ArrayList<String>();
	 @Test
	    @DisplayName("Checking for ReplacementServiceImpl - if it is loading or not for @GetMapping")
	   void replacementServiceImplNotNullTest(){
	        assertThat(replacementServiceImpl).isNotNull();
	    }
	 
	 
		@Test
		 void requestIdTest() {
			
			li.add(replacementServiceImpl.generateRequestId());
			assertTrue(li.size()>0);
		}
    
}
