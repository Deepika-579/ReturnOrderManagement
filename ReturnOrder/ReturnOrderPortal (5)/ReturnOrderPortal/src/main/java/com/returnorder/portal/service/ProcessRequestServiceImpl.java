package com.returnorder.portal.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.returnorder.portal.client.ComponentClient;
import com.returnorder.portal.dto.PaymentStatusDTO;
import com.returnorder.portal.dto.ProcessDTO;

import com.returnorder.portal.model.ProcessRequest;
import com.returnorder.portal.model.ProcessResponse;
import com.returnorder.portal.repo.ProcessRequestRepo;
import com.returnorder.portal.repo.ProcessResponseRepo;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class ProcessRequestServiceImpl implements ProcessRequestService {

	@Autowired
	private ProcessRequestRepo processRequestRepo;
	@Autowired
	private ProcessResponseRepo processResponseRepo;
	@Autowired
	private ComponentClient componentClient;
	@Autowired
	private ProcessResponse processResponse;

	private ProcessDTO processDTO = new ProcessDTO();

	private PaymentStatusDTO paymentStatusDTO = new PaymentStatusDTO();

	@Override
	public ProcessResponse processRequestSaveService(ProcessRequest processRequestObj,String token) {
		processRequestRepo.save(processRequestObj);
		log.info("In Process Response");
		log.info(token);
		processDTO = (ProcessDTO) (componentClient.processResponseDetails(processRequestObj,token));

		log.info(processDTO.toString());
	
		processResponse.setRequestId(processDTO.getRequestId().toString());
		processResponse.setDateOfDelivery(processDTO.getDateOfDelivery());
		processResponse.setProcessingCharge(processDTO.getProcessingCharge().intValue());
		processResponse.setPackagingAndDeliveryCharge(processDTO.getPackagingAndDeliveryCharge().doubleValue());
	
		log.info("In Response after client 1");
	
		log.info(processResponse.toString());
		
		processResponseRepo.save(processResponse);

		return processResponse;

	}
 
	@Override
	public PaymentStatusDTO statusDetails(ProcessRequest processRequestObj,String token) {
		log.info("In statusDetails Before");
		String s = componentClient.statusConfirmation(processDTO.getRequestId(), processRequestObj.getCreditCardNumber(),
						processRequestObj.getCardLimit(), processDTO.getProcessingCharge().intValue(),token)
				.getStatus();

		log.info(s);

		log.info("In statusDetails After");

		return new PaymentStatusDTO(s);

	}

}
