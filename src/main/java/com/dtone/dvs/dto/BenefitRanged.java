package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BenefitRanged extends Benefit {

	@JsonProperty(value = "amount")
	private BenefitAmountRanged amount;

	public BenefitAmountRanged getAmount() {
		return amount;
	}

	public void setAmount(BenefitAmountRanged amount) {
		this.amount = amount;
	}

}