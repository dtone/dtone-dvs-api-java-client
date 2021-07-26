package com.dtone.dvs.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountBalance {
	@JsonProperty(value = "unit_type")
	private UnitTypes unitType;

	@JsonProperty(value = "unit")
	private String unit;

	@JsonProperty(value = "amount")
	private BigDecimal amount;

	public UnitTypes getUnitType() {
		return unitType;
	}

	public void setUnitType(UnitTypes unitType) {
		this.unitType = unitType;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
