package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPrice {

	@JsonProperty(value = "unit_type")
	private String unitType;

	@JsonProperty(value = "unit")
	private String unit;

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

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

}
