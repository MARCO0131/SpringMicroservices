package com.currency.conversionservice.bean;

import java.math.BigDecimal;





public class CurrencyConversion {
	

	

	private String from;
	private BigDecimal quantity;
	private String to;
	private BigDecimal convertionMultiple;
	private String environment;
	private BigDecimal totalCalculatedAmount;
	public CurrencyConversion() {
		super();
	}
	public CurrencyConversion(String from, BigDecimal quantity, String to, BigDecimal convertionMultiple,
			String environment, BigDecimal totalCalculatedAmount) {
		super();
		this.from = from;
		this.quantity = quantity;
		this.to = to;
		this.convertionMultiple = convertionMultiple;
		this.environment = environment;
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConvertionMultiple() {
		return convertionMultiple;
	}
	public void setConvertionMultiple(BigDecimal convertionMultiple) {
		this.convertionMultiple = convertionMultiple;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	
	

}
