package com.dtone.dvs.dto;

import com.dtone.dvs.util.NumberUtils;
import com.dtone.dvs.util.RangedProductUtils;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Amount {

	@JsonProperty(value = "base")
	private Object base;

	@JsonProperty(value = "promotion_bonus")
	private Object promotionBonus;

	@JsonProperty(value = "total_excluding_tax")
	private Object totalExcludingTax;

	/**
	 * Get base for fixed type product
	 * 
	 */
	public Double getBase() {
		return NumberUtils.toDouble(base);
	}
	
	/**
	 * Get base for ranged type product
	 * 
	 */
	public AmountRanged getBaseRanged() {
		return RangedProductUtils.toAmountRanged(base);
	}

	public void setBase(Object base) {
		this.base = base;
	}

	/**
	 * Get promotion bonus for fixed type product
	 * 
	 */
	public Double getPromotionBonus() {
		return NumberUtils.toDouble(promotionBonus);
	}
	
	/**
	 * Get promotion bonus for ranged type product
	 * 
	 */
	public AmountRanged getPromotionBonusRanged() {
		return RangedProductUtils.toAmountRanged(promotionBonus);
	}

	public void setPromotionBonus(Object promotionBonus) {
		this.promotionBonus = promotionBonus;
	}

	/**
	 * Get total excluding tax for fixed type product
	 * 
	 */
	public Double getTotalExcludingTax() {
		return NumberUtils.toDouble(totalExcludingTax);
	}
	
	/**
	 * Get total excluding tax for ranged type product
	 * 
	 */
	public AmountRanged getTotalExcludingTaxRanged() {
		return RangedProductUtils.toAmountRanged(totalExcludingTax);
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
