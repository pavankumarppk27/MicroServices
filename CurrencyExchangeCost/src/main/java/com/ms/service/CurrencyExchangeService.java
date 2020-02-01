package com.ms.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.entity.CurrencyExchangeEntity;
import com.ms.model.CurrencyExchangeModel;
import com.ms.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {
	
	@Autowired
	private CurrencyExchangeRepository repo;
	
	public CurrencyExchangeModel getCurrencyValue(String currencyFrom,String currencyTo) {
		
		CurrencyExchangeModel currencyExchangeModel=new CurrencyExchangeModel();
		CurrencyExchangeEntity currencyExchangeEntity = repo.findByCurrencyFromAndCurrencyTo(currencyFrom, currencyTo);
	    BeanUtils.copyProperties(currencyExchangeEntity, currencyExchangeModel);
	    
		return currencyExchangeModel;
	}
}
