package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductPricesRanged {

	@JsonProperty(value = "wholesale")
	private ProductPriceRanged wholesale;

	@JsonProperty(value = "retail")
	private ProductPriceRanged retail;

	public ProductPriceRanged getWholesale() {
		return wholesale;
	}

	public void setWholesale(ProductPriceRanged wholesale) {
		this.wholesale = wholesale;
	}

	public ProductPriceRanged getRetail() {
		return retail;
	}

	public void setRetail(ProductPriceRanged retail) {
		this.retail = retail;
	}

	@Override
	public String toString() {
		return "ProductPricesRanged [wholesale=" + wholesale + ", retail=" + retail + "]";
	}

}
