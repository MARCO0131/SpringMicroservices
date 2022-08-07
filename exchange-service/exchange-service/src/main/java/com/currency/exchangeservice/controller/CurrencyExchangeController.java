package com.currency.exchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.currency.exchangeservice.bean.CurrencyExchange;
import com.currency.exchangeservice.service.CurrencyExchangeService;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/")
	public String hello() {
		return "hello world";
	}
	
	@GetMapping("/from/{from}/to/{to}")
	public CurrencyExchange retriveValue(@PathVariable String from,
			@PathVariable String to){
		
		
		CurrencyExchange currencyExchange = currencyExchangeService.find(from, to);
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
		
	}

}
