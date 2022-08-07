package com.currency.conversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currency.conversionservice.bean.CurrencyConversion;
import com.currency.conversionservice.feignclient.RestFeignClient;

@RestController
public class CurrencyConversionController {
	
	
	@Autowired
	private RestFeignClient restFeignClient;
	
	
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getCurrency(@PathVariable String from,@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		HashMap<String , String > var = new HashMap<String, String>();
		var.put("from", from);
		var.put("to", to);
		ResponseEntity<CurrencyConversion> responseEntity= new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class, var);
		CurrencyConversion currencyExchange = responseEntity.getBody();
		currencyExchange.setTotalCalculatedAmount(quantity.multiply(currencyExchange.getConvertionMultiple()));
		return new CurrencyConversion(from,quantity,to,currencyExchange.getConvertionMultiple()
				,currencyExchange.getEnvironment(),currencyExchange.getTotalCalculatedAmount());
	}
	
	
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getCurrencyFeign(@PathVariable String from,@PathVariable String to, @PathVariable BigDecimal quantity) {
			CurrencyConversion currencyConversion = restFeignClient.retriveValue(from, to);
			currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConvertionMultiple()));
				
			return new CurrencyConversion(from,quantity,to,currencyConversion.getConvertionMultiple()
												,currencyConversion.getEnvironment(),
												currencyConversion.getTotalCalculatedAmount());
	}

	
	
}
