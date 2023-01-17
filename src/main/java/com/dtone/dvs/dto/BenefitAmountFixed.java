package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BenefitAmountFixed {

	@JsonProperty(value = "base")
	private Double base;

	@JsonProperty(value = "promotion_bonus")
	private Double promotionBonus;

	@JsonProperty(value = "total_excluding_tax")
	private Double totalExcludingTax;

	@JsonProperty(value = "total_including_tax")
	private Double totalIncludingTax;

	public Double getBase() {
		return base;
	}

	public void setBase(Double base) {
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

	public Double getTotalIncludingTax() {
		return totalIncludingTax;
	}

	public void setTotalIncludingTax(Double totalIncludingTax) {
		this.totalIncludingTax = totalIncludingTax;
	}

	@Override
	public String toString() {
		return "BenefitAmountFixed [base=" + base + ", promotionBonus=" + promotionBonus + ", totalExcludingTax="
				+ totalExcludingTax + ", totalIncludingTax=" + totalIncludingTax + "]";
	}

}
