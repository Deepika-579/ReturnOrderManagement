package com.payment.microservice.model;

import lombok.*;




import org.springframework.stereotype.Component;

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
@Component
public class PaymentDetails {
	


	private String requestId;
	

	private Integer cardNumber;
	
	

	private int creditLimit;            
	

	private int processingCharge;
}
