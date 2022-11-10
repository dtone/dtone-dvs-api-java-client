package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SourceRanged extends Source {

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
		return "SourceRanged [amount=" + amount + ", getUnitType()=" + getUnitType() + ", getUnit()=" + getUnit()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
