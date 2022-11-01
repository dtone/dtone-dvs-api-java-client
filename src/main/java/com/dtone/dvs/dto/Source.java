package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Source {

	@JsonProperty(value = "unit_type")
	private String unitType;

	@JsonProperty(value = "unit")
	private String unit;

	@JsonProperty(value = "amount")
	private Object amount;

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

	public Object getAmount() {
		return amount;
	}

	public void setAmount(Object amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Source [unitType=" + unitType + ", unit=" + unit + ", amount=" + amount + "]";
	}

}
