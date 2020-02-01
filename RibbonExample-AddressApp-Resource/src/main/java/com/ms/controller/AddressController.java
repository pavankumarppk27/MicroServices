package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ms.model.AddressModel;
import com.ms.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@GetMapping(value="/getAddressDtls/id/{id}")
	public AddressModel getAddressDtls(@PathVariable("id") Integer id) {
		
		return service.getAddress(id);
	}

}
