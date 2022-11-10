package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPriceRanged extends ProductPrice {

	@JsonProperty(value = "amount")
	private AmountRanged amount;

	public AmountRanged getAmount() {
		return amount;
	}

	public void setAmount(AmountRanged amount) {
		this.amount = amount;
	}

}
