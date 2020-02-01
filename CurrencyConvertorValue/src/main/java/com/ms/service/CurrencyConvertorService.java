package com.ms.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.model.CurrencyConvertorModel;
import com.ms.model.CurrencyExchangeModel;

@Service
public class CurrencyConvertorService {

	
	
	
public CurrencyConvertorModel getCurrencyConvertorValue(String currencyFrom, String currencyTo,Double value) {
	
		String url="http://localhost:4455/getCurrencyValue/currencyFrom/"+currencyFrom+"/currencyTo/"+currencyTo;
		
		CurrencyConvertorModel convertorModel=new CurrencyConvertorModel();
		
		//CurrencyExchangeModel currencyExchangeModel=new CurrencyExchangeModel();
		
		RestTemplate template=new RestTemplate();	
		CurrencyExchangeModel currencyExchangeModel = template.getForObject(url, CurrencyExchangeModel.class);
		BeanUtils.copyProperties(currencyExchangeModel, convertorModel);
		convertorModel.setConvertorValue(value*currencyExchangeModel.getCurrencyValue());
		
		return convertorModel;
	}
	
}
