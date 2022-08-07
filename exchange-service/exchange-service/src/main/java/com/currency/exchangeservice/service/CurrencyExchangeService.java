package com.currency.exchangeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currency.exchangeservice.bean.CurrencyExchange;
import com.currency.exchangeservice.repository.CurrencyExchangeRepository;


@Service
public class CurrencyExchangeService {
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	public CurrencyExchange find(String from , String to) {
		CurrencyExchange currencyExchange =  currencyExchangeRepository.findByFromAndTo(from, to);
		if(currencyExchange==null) {
			throw new RuntimeException(from +" from to "+to+"does not exist");
		}
		return currencyExchange;
	}
}
