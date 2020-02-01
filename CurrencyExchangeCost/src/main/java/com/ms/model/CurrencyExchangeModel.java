package com.ms.model;

import lombok.Data;

@Data
public class CurrencyExchangeModel {
	
	private Integer currencyId;
	private String currencyFrom;
	private String currencyTo;
	private Double currencyValue;
	

}
