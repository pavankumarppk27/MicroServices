package com.ms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import com.ms.config.CurrencyAppProps;
import com.ms.constants.CurrencyAppConstants;
import com.ms.model.CurrencyRequestBindingModel;
import com.ms.model.CurrencyResponseBindingModel;

@Service
public class CurrencyService {

	@Autowired
	private CurrencyAppProps props;

	@Autowired
	private Environment env;

	private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyService.class);

	//@HystrixCommand(fallbackMethod ="erroFallBackMethod")
	public CurrencyResponseBindingModel getCurrencyValue(CurrencyRequestBindingModel currencyReqModel) {

		LOGGER.info("in side getCurrencyValue()");

		/*
		 * //reading url by using Environment
		 * 
		 * String GET_URL=env.getProperty("web-client.messages.GET_CURRENCY_VALUES");
		 * System.out.println("GET_URL:"+GET_URL);
		 */

		// reading url from CurrencyAppProps( by using @ConfigurationProperties()
		// annotation)
		String url = props.getMessages().get(CurrencyAppConstants.GET_CURRENCY_VALUES);

		LOGGER.info("reading the Rest Url from CurrencyAppConstants class");

		// using RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		LOGGER.info("creating the RestTemplate Object");

		// String url =
		// "http://localhost:4466/getCurrencyConvertorValue/from/{from}/to/{to}/value/{value}";
		CurrencyResponseBindingModel currencyResponseBindingModel = restTemplate.getForObject(url,
				CurrencyResponseBindingModel.class, currencyReqModel.getCurrencyFrom(),
				currencyReqModel.getCurrencyTo(), currencyReqModel.getCurrencyValue());

		LOGGER.info("calling the CurrencyConvertorValue Class by using RestTemplate and invoking with from:"
				+ currencyReqModel.getCurrencyFrom() + " and to: " + currencyReqModel.getCurrencyTo());

		// using webclient
		Builder builder = WebClient.builder();
		LOGGER.info("creating the builder object");
		WebClient build = builder.build();
		LOGGER.info("creatin WebClient Object by using builder");
		CurrencyResponseBindingModel currencyResponseBinding = build.get()
				                                               .uri(url, currencyReqModel.getCurrencyFrom(), currencyReqModel.getCurrencyTo(),
						                                                 currencyReqModel.getCurrencyValue())
				                                               .retrieve()
				                                               .bodyToMono(CurrencyResponseBindingModel.class)
				                                               .block();

		LOGGER.info("getting the response:" + currencyResponseBinding);
		
		
		
		return currencyResponseBinding;
	}

	public String erroFallBackMethod() {

		return "Something Problem is Occured. Try Later..!";
	}

}
