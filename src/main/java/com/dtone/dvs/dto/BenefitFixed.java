package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BenefitFixed extends Benefit {

	@JsonProperty(value = "amount")
	private BenefitAmountFixed amount;

	public BenefitAmountFixed getAmount() {
		return amount;
	}

	public void setAmount(BenefitAmountFixed amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "BenefitFixed [amount=" + amount + "]";
	}

}
