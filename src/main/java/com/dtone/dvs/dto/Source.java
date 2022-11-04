package com.dtone.dvs.dto;

import com.dtone.dvs.util.NumberUtils;
import com.dtone.dvs.util.RangedProductUtils;
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

	/**
	 * Get amount for fixed type product
	 * 
	 */
	public Double getAmount() {
		return NumberUtils.toDouble(amount);
	}

	/**
	 * Get amount for ranged type product
	 * 
	 */
	public AmountRanged getAmountRanged() {
		return RangedProductUtils.toAmountRanged(amount);
	}

	public void setAmount(Object amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Source [unitType=" + unitType + ", unit=" + unit + ", amount=" + amount + "]";
	}

}
