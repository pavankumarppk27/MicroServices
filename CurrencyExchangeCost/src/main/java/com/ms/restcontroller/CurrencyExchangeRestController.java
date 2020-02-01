package com.ms.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ms.model.CurrencyExchangeModel;
import com.ms.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeRestController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CurrencyExchangeRestController.class);
	
	@Autowired
	private CurrencyExchangeService service;
	
	@GetMapping(value="/getCurrencyValue/currencyFrom/{from}/currencyTo/{to}",produces = "application/json")
	public CurrencyExchangeModel getCurrencyValue(@PathVariable("from") String currencyFrom,@PathVariable("to") String currencyTo) {
	
		LOGGER.info("in side getCurrencyValue() method");
		LOGGER.info("invoking this method with Parameters from:"+currencyFrom+" to:"+currencyTo);
		CurrencyExchangeModel currencyExchangeModel = service.getCurrencyValue(currencyFrom, currencyTo);
		
		if(currencyExchangeModel==null) {
			LOGGER.error("exception inside getCurrencyValue() ");
		}
		
		return currencyExchangeModel;
		}

}
