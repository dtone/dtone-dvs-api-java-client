package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Source extends ProductSource {
	public Source() {
	}

	public Source(String unitType, String unit, Double amount) {
		super(unitType, unit);
		this.amount = amount;
	}

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
		return "Source [amount=" + amount + ", unitType=" + getUnitType() + ", unit=" + getUnit() + "]";
	}

}
