package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ms.exception.CustomerIDNotFoundException;
import com.ms.model.CustomerRespModel;
import com.ms.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/getCustomerDtls/id/{id}")
	public CustomerRespModel getCusomterDtls(@PathVariable("id") Integer id) throws CustomerIDNotFoundException{
		
		CustomerRespModel customerRespModel = service.getCustomerDtls(id);

		
		if(customerRespModel==null) {
			
			throw new CustomerIDNotFoundException();	
		}
		return customerRespModel;
		
	}

}
