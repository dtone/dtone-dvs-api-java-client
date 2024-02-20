package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BenefitAmountRanged {

	@JsonProperty(value = "base")
	private AmountRanged base;

	@JsonProperty(value = "promotion_bonus")
	private AmountRanged promotionBonus;

	@JsonProperty(value = "total_excluding_tax")
	private AmountRanged totalExcludingTax;

	@JsonProperty(value = "total_including_tax")
	private AmountRanged totalIncludingTax;

	public AmountRanged getBase() {
		return base;
	}

	public void setBase(AmountRanged base) {
		this.base = base;
	}

	public AmountRanged getPromotionBonus() {
		return promotionBonus;
	}

	public void setPromotionBonus(AmountRanged promotionBonus) {
		this.promotionBonus = promotionBonus;
	}

	public AmountRanged getTotalExcludingTax() {
		return totalExcludingTax;
	}

	public void setTotalExcludingTax(AmountRanged totalExcludingTax) {
		this.totalExcludingTax = totalExcludingTax;
	}

	public AmountRanged getTotalIncludingTax() {
		return totalIncludingTax;
	}

	public void setTotalIncludingTax(AmountRanged totalIncludingTax) {
		this.totalIncludingTax = totalIncludingTax;
	}

	@Override
	public String toString() {
		return "BenefitAmountRanged [base=" + base + ", promotionBonus=" + promotionBonus + ", totalExcludingTax="
				+ totalExcludingTax + ", totalIncludingTax=" + totalIncludingTax + "]";
	}

}
