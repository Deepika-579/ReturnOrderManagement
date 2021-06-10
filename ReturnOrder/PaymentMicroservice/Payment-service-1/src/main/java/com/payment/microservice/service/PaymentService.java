package com.payment.microservice.service;

import org.springframework.stereotype.Service;

import com.payment.microservice.dto.PaymentDTO;


@Service
public interface PaymentService {

	public PaymentDTO processPaymentService(String RequestId,Integer cardNumber,Integer creditLimit,Integer processingCharge);

}
