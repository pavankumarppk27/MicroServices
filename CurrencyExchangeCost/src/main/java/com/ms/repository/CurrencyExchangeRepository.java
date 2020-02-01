package com.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.entity.CurrencyExchangeEntity;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeEntity, Integer> {

	public CurrencyExchangeEntity findByCurrencyFromAndCurrencyTo(String currencyFrom,String currencyTo);
	
	
}
