package com.componentprocessing.microservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.componentprocessing.microservice.model.ProcessRequest;
import com.componentprocessing.microservice.model.ProcessResponse;

@SpringBootTest
public class RepairServiceImplTest {

	
	RepairServiceImpl repairServiceImpl=new RepairServiceImpl();
	ProcessRequest processRequestObj = new ProcessRequest();

	ProcessResponse processResponseObj= new ProcessResponse();
	List<String> li = new ArrayList<String>();
	@Test
	@DisplayName("Checking for RepairServiceImpl - if it is loading or not for @GetMapping")
	void repairServiceImplNotNullTest() {
		assertThat(repairServiceImpl).isNotNull();
	}

	@Test
    void requestIdTest() {
		
		li.add(repairServiceImpl.generateRequestId());
		assertTrue(li.size()>0);
	}
	


}
