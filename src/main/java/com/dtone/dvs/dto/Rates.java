package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rates {

	@JsonProperty(value = "base")
	private Double base;

	@JsonProperty(value = "wholesale")
	private Double wholesale;

	@JsonProperty(value = "discount_from_base")
	private Double discountFromBase;

	public Double getBase() {
		return base;
	}

	public void setBase(Double base) {
		this.base = base;
	}

	public Double getWholesale() {
		return wholesale;
	}

	public void setWholesale(Double wholesale) {
		this.wholesale = wholesale;
	}

	public Double getDiscountFromBase() {
		return discountFromBase;
	}

	public void setDiscountFromBase(Double discountFromBase) {
		this.discountFromBase = discountFromBase;
	}

	@Override
	public String toString() {
		return "Rates [base=" + base + ", wholesale=" + wholesale + ", discountFromBase=" + discountFromBase + "]";
	}

}
