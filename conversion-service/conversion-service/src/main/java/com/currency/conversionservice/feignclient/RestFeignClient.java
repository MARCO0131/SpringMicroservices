package com.currency.conversionservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.currency.conversionservice.bean.CurrencyConversion;

//@FeignClient(name="currency-exchange-service",url ="localhost:8000")
@FeignClient(name="currency-exchange-service")
public interface RestFeignClient{
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retriveValue(@PathVariable String from,
			@PathVariable String to);

}
