package com.packaging.delivery.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.packaging.delivery.exceptions.ComponentTyepNotFoundException;

public class ComponentTyepNotFoundExceptionTest extends RuntimeException{
	
	
	ComponentTyepNotFoundException exception = new ComponentTyepNotFoundException("Exception");
	
	
	@Test
    @DisplayName("Checking if [ComponentTyepNotFoundException] is loading or not.")
     void componentTyepNotFoundExceptionIsLoaded(){
        assertThat(exception).isNotNull();    
    }
	

}
