package com.componentprocessing.microservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProcessRequestTest {

 
    ProcessRequest processRequestObj=new ProcessRequest();

    @Test
    @DisplayName("Checking if ProcessingRequest class is loading or not.")
     void processingRequestIsLoadedOrNot() {
        assertThat(processRequestObj).isNotNull();
    }

    @DisplayName("Checking if ProcessingRequest class is responding correctly or not.")
    @Test
     void testingProcessRequest(){
    	processRequestObj=new ProcessRequest("Avik",1234567890l,54321,true,"accessory","book",3);
        processRequestObj.setUserName("AdyashaTarasia");
        processRequestObj.setContactNumber(8457023222l);
        processRequestObj.setCreditCardNumber(123456789);
        processRequestObj.setIsPriorityRequest(true);
        processRequestObj.setComponentType("accessory");
        processRequestObj.setComponentName("book");
        processRequestObj.setQuantity(5); 
        
        
        assertEquals("AdyashaTarasia",processRequestObj.getUserName());
        assertEquals(8457023222l,processRequestObj.getContactNumber());
        assertEquals(123456789,processRequestObj.getCreditCardNumber());
        assertEquals(true,processRequestObj.getIsPriorityRequest());
        assertEquals("book",processRequestObj.getComponentName());
        assertEquals("accessory",processRequestObj.getComponentType());
        assertEquals(5,processRequestObj.getQuantity());
        

      
    }
}
