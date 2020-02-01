package com.ms.model;

import lombok.Data;

@Data
public class CurrencyResponseBindingModel {
	
	private Double currencyValue;
	private String currencyFrom;
	private String currencyTo;
	private Double convertorValue;


}
