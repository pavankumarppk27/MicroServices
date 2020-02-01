package com.ms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ms.model.CurrencyConvertorModel;
import com.ms.service.CurrencyConvertorService;

@RestController
public class CurrencyConvertorController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CurrencyConvertorController.class);
	
	@Autowired
	private CurrencyConvertorService service;
	
	@GetMapping(value="/getCurrencyConvertorValue/from/{from}/to/{to}/value/{value}",produces = "application/json")
	public CurrencyConvertorModel getCurrencyConvertorValue(@PathVariable("from") String currencyFrom,@PathVariable("to") String currencyTo,@PathVariable("value") Double value) {
		
		LOGGER.info("getCurrencyConvertorValue() invoked with from:"+currencyFrom+" currencyTo:"+currencyTo);
		
		CurrencyConvertorModel currencyConvertorModel= service.getCurrencyConvertorValue(currencyFrom, currencyTo, value);
		
		return currencyConvertorModel;
	}
	

}
