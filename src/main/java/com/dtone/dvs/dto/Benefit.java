package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Benefit {

	@JsonProperty(value = "type")
	private String type;

	@JsonProperty(value = "unit_type")
	private String unitType;
	
	@JsonProperty(value = "unit")
	private String unit;

	@JsonProperty(value = "amount")
	private Amount amount;
	
	@JsonProperty(value = "additional_information")
	private String additionalInformation;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	@Override
	public String toString() {
		return "Benefit [type=" + type + ", unitType=" + unitType + ", unit=" + unit + ", amount=" + amount
				+ ", additionalInformation=" + additionalInformation + "]";
	}

}
