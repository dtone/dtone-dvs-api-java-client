package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Amount {

	@JsonProperty(value = "base")
	private Object base;

	@JsonProperty(value = "promotion_bonus")
	private Object promotionBonus;

	@JsonProperty(value = "total_excluding_tax")
	private Object totalExcludingTax;

	public Object getBase() {
		return base;
	}

	public void setBase(Object base) {
		this.base = base;
	}

	public Object getPromotionBonus() {
		return promotionBonus;
	}

	public void setPromotionBonus(Object promotionBonus) {
		this.promotionBonus = promotionBonus;
	}

	public Object getTotalExcludingTax() {
		return totalExcludingTax;
	}

	public void setTotalExcludingTax(Object totalExcludingTax) {
		this.totalExcludingTax = totalExcludingTax;
	}

	@Override
	public String toString() {
		return "Amount [base=" + base + ", promotionBonus=" + promotionBonus + ", totalExcludingTax="
				+ totalExcludingTax + "]";
	}

}
