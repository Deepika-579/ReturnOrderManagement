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

@Slf4j
@Service
public class RepairServiceImpl implements ProcessRequestService{

    @Autowired
    private ProcessResponse processResponseObj;
    @Autowired
    private ProcessRequestRepo processRequestRepo;
    @Autowired
    private ProcessResponseRepo processResponseRepo;
    @Autowired
    private PackagingClient packagingClient;
    @Autowired
	private PaymentClient paymentClient;
    @Override
    public ProcessResponse processService(ProcessRequest processRequestObj,String token){
    	log.info("Before Priority Check");
        if(processRequestObj.getIsPriorityRequest()){
        	log.info("Priority True");
        	 processResponseObj.setProcessingCharge(700); 
         	log.info("Priority True23");
     		String strDate = LocalDateTime.now().plusDays(2).toString();  
     		log.info(strDate);
     		processResponseObj.setDateOfDelivery(strDate);
        }
        else{
        	log.info("Priority False");
        	 processResponseObj.setProcessingCharge(500); 
     		String strDate = LocalDateTime.now().plusDays(2).toString(); 
     		processResponseObj.setDateOfDelivery(strDate);
        }
        log.info("After Priority Check");
        processResponseObj.setRequestId(generateRequestId());
        processRequestRepo.save(processRequestObj);
        
        processResponseObj.setPackagingAndDeliveryCharge(packagingClient.save(processRequestObj.getComponentType(), processRequestObj.getQuantity(),token).getCharge());
        processResponseRepo.save(processResponseObj);
   
        return processResponseObj;
    }
   @Override
    public String generateRequestId(){

        return UUID.randomUUID().toString();
        
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
    
}
