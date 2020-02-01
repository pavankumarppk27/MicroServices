package com.ms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CURRENCY_EXCHANGE_MASTER")
public class CurrencyExchangeEntity {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer currencyId;

	@Column
	private String currencyFrom;

	@Column
	private String currencyTo;

	@Column
	private Double currencyValue;

}
