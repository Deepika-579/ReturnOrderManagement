
package com.returnorder.portal.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "ReturnOrderResponse")

@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
@Component
@ToString
public class ProcessResponse {

    @Id
  
    private String requestId;
   
    private Integer processingCharge;
  
    private Double packagingAndDeliveryCharge;

  
    private String dateOfDelivery;


    
}
