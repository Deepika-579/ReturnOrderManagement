package com.componentprocessing.microservice.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ComponentProcessingControllerTest {

  
    ComponentProcessingController componentProcessingController = new ComponentProcessingController();

    @Test
    @DisplayName("Checking for ComponentProcessingController - if it is loading or not for @GetMapping")
    void componentProcessingControllerNotNullTest(){
        assertThat(componentProcessingController).isNotNull();
    }

  
}
