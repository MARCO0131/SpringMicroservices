package com.currency.exchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currency.exchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Integer >{
	
	CurrencyExchange findByFromAndTo(String from ,String to);

}
