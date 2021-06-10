package com.packaging.delivery.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class InvalidTokenExceptionTest {

	InvalidTokenException exception = new InvalidTokenException("Exception");

	@Test
	@DisplayName("Checking if [InvalidTokenException] is loading or not.")
	 void componentTyepNotFoundExceptionIsLoaded() {
		assertThat(exception).isNotNull();
	}

}
