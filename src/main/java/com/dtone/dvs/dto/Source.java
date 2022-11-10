package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Source {

	@JsonProperty(value = "unit_type")
	private String unitType;

	@JsonProperty(value = "unit")
	private String unit;

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

}
