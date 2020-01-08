package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Amount {

	@JsonProperty(value = "base")
	private String base;

	@JsonProperty(value = "promotion_bonus")
	private Double promotionBonus;

	@JsonProperty(value = "total_excluding_tax")
	private Double totalExcludingTax;

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Double getPromotionBonus() {
		return promotionBonus;
	}

	public void setPromotionBonus(Double promotionBonus) {
		this.promotionBonus = promotionBonus;
	}

	public Double getTotalExcludingTax() {
		return totalExcludingTax;
	}

	public void setTotalExcludingTax(Double totalExcludingTax) {
		this.totalExcludingTax = totalExcludingTax;
	}

	@Override
	public String toString() {
		return "Amount [base=" + base + ", promotionBonus=" + promotionBonus + ", totalExcludingTax="
				+ totalExcludingTax + "]";
	}

}
