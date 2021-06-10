package com.componentprocessing.microservice.service;

import java.time.LocalDateTime;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.componentprocessing.microservice.client.PackagingClient;
import com.componentprocessing.microservice.client.PaymentClient;
import com.componentprocessing.microservice.model.ProcessRequest;
import com.componentprocessing.microservice.model.ProcessResponse;
import com.componentprocessing.microservice.repository.ProcessRequestRepo;
import com.componentprocessing.microservice.repository.ProcessResponseRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class ReplacementServiceImpl implements ProcessRequestService{


    @Autowired
    private ProcessRequestRepo processRequestRepo;
    @Autowired
    private ProcessResponse processResponseObj;
    @Autowired
    private ProcessResponseRepo processResponseRepo;
    @Autowired
    private PackagingClient packagingClient;
    
	@Autowired
	private PaymentClient paymentClient;
    
    @Override
    public ProcessResponse processService(ProcessRequest processRequestObj,String token){
    	
    	            
    
        log.info("hi im here " + processRequestObj.toString());
    	if(processRequestObj.getIsPriorityRequest()) {
    		 
    		String strDate = LocalDateTime.now().plusDays(2).toString(); 
    		processResponseObj.setDateOfDelivery(strDate);
    	}
    	else {
    		  
    		String strDate = LocalDateTime.now().plusDays(5).toString(); 
    		processResponseObj.setDateOfDelivery(strDate);
    	}
        processResponseObj.setProcessingCharge(300); 
        processResponseObj.setRequestId(generateRequestId());
        processRequestRepo.save(processRequestObj);
        
        processResponseObj.setPackagingAndDeliveryCharge(packagingClient.save(processRequestObj.getComponentType(), processRequestObj.getQuantity(),token).getCharge());
        processResponseRepo.save(processResponseObj);
        
        return processResponseObj;
    }
    

  



	@Override
	public String messageConfirmation( String requestId, Integer creditCardNumber, Integer creditLimit,
			Integer processingCharge,String token) {
		log.info("Inside Service");
		double check = (paymentClient.paymentDetails(requestId,creditCardNumber, creditLimit, processingCharge,token)).getCharge().doubleValue();
	
    	 if((int)check>0) {
      	   
      	   log.info("Successful Operation Message displayed");
      	   return "Operation Successful";
         }
         else {
      	   return "Operation Not Successful";
         }
	}
	   public String generateRequestId(){

	        return UUID.randomUUID().toString();
	        
	    }


    
}
