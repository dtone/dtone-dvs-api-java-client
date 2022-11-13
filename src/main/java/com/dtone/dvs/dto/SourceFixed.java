package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SourceFixed extends ProductSource {

	@JsonProperty(value = "amount")
	private Double amount;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "SourceFixed [amount=" + amount + ", unitType=" + getUnitType() + ", unit=" + getUnit() + "]";
	}

}
