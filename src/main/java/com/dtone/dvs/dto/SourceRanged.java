package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceRanged extends ProductSource {

	@JsonProperty(value = "amount")
	private AmountRanged amount;

	public AmountRanged getAmount() {
		return amount;
	}

	public void setAmount(AmountRanged amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "SourceRanged [amount=" + amount + ", unitType=" + getUnitType() + ", unit=" + getUnit() + "]";
	}

}
