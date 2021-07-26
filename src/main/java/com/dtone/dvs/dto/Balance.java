package com.dtone.dvs.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Balance {
	@JsonProperty(value = "id")
	private String id;
	
	@JsonProperty(value = "unit_type")
	private UnitTypes unitType;
	
	@JsonProperty(value = "unit")
	private String unit;
	
	@JsonProperty(value = "available")
	private BigDecimal available;
	
	@JsonProperty(value = "holding")
	private BigDecimal holding;
	
	@JsonProperty(value = "credit_limit")
	private Long creditLimit;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public BigDecimal getAvailable() {
		return available;
	}

	public void setAvailable(BigDecimal available) {
		this.available = available;
	}

	public BigDecimal getHolding() {
		return holding;
	}

	public void setHolding(BigDecimal holding) {
		this.holding = holding;
	}

	public Long getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Long creditLimit) {
		this.creditLimit = creditLimit;
	}

	@Override
	public String toString() {
		return "Balance [id=" + id + ", unitType=" + unitType + ", unit=" + unit + ", available=" + available
				+ ", holding=" + holding + ", creditLimit=" + creditLimit + "]";
	}

}
