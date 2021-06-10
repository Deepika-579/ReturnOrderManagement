package com.returnorder.portal.service;



import org.springframework.stereotype.Service;

import com.returnorder.portal.dto.PaymentStatusDTO;
import com.returnorder.portal.model.ProcessRequest;
import com.returnorder.portal.model.ProcessResponse;


@Service
public interface ProcessRequestService {

	ProcessResponse processRequestSaveService(ProcessRequest processRequestObj,String token);
	public PaymentStatusDTO statusDetails(ProcessRequest processRequestObj,String token);
	

}
