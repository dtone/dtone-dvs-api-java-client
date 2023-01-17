package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {

	@JsonProperty(value = "unit_type")
	private String unitType;

	@JsonProperty(value = "unit")
	private String unit;

	@JsonProperty(value = "amount")
	private Double amount;

	@JsonProperty(value = "fee")
	private Double fee;

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Price [unitType=" + unitType + ", unit=" + unit + ", amount=" + amount + ", fee=" + fee + "]";
	}

}
