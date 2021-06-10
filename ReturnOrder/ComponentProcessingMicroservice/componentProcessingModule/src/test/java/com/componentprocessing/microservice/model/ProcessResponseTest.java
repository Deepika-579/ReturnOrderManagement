package com.componentprocessing.microservice.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ProcessResponseTest {

    @Autowired
    ProcessResponse processResponseObj;

    @Test
    @DisplayName("Checking if ProcessingResponse class is loading or not.")
    void processingResponseIsLoadedOrNot() {
        assertThat(processResponseObj).isNotNull();
    }

    @Test
    @DisplayName("Checking if ProcessingResponse class is responding correctly or not.")
    void testingProcessResponse(){

    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  
        String strDate =LocalDateTime.now().toString(); 
    	processResponseObj = new ProcessResponse("abc123",500,50.00,strDate);
        processResponseObj.setProcessingCharge(500);
        processResponseObj.setPackagingAndDeliveryCharge(50.00);
       
    
        processResponseObj.setRequestId("abc123");
    

        processResponseObj.setDateOfDelivery(strDate);
       assertEquals(500,processResponseObj.getProcessingCharge());
       assertEquals(50.00,processResponseObj.getPackagingAndDeliveryCharge());
       assertEquals("abc123",processResponseObj.getRequestId());
      
    }
}