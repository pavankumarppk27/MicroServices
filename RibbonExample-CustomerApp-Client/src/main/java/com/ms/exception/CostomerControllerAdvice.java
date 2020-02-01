package com.ms.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class CostomerControllerAdvice{
	
	
	@ExceptionHandler(CustomerIDNotFoundException.class)
	public String customerIdNotFound() {
		
		return "THE GIVEN CUSTOMER-ID IS NOT FOUND";
	}

}
