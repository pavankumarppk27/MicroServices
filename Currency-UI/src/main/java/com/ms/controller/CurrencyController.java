package com.ms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ms.model.CurrencyRequestBindingModel;
import com.ms.model.CurrencyResponseBindingModel;
import com.ms.service.CurrencyService;

@Controller
public class CurrencyController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CurrencyController.class);
	
	@Autowired
	private CurrencyService currencyService;

	@GetMapping("/currency")
	public String showForm(Model model) {

		
		CurrencyRequestBindingModel currencyReqModel = new CurrencyRequestBindingModel();
		model.addAttribute("currencyReqModel", currencyReqModel);

		return "currency";
	}

	@PostMapping(value="/currencyValue")
	public String getCurrencyVal(Model model,
			@ModelAttribute("currencyReqModel") CurrencyRequestBindingModel currencyReqModel) {
		
		LOGGER.error("**********************************ERROR");
		LOGGER.warn("WARN");
		LOGGER.info("INFO");
		LOGGER.debug("DEBUG");
		LOGGER.trace("TRACE");
		
		CurrencyResponseBindingModel currencyResponseBindingModel = currencyService.getCurrencyValue(currencyReqModel);
		model.addAttribute("value",currencyResponseBindingModel.getConvertorValue());
		
		return "currency";
	}
	
	
	
	
	

}
