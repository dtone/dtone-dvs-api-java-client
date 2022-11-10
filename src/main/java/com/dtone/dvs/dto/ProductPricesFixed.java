package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPricesFixed {

	@JsonProperty(value = "wholesale")
	private ProductPriceFixed wholesale;

	@JsonProperty(value = "retail")
	private ProductPriceFixed retail;

	public ProductPriceFixed getWholesale() {
		return wholesale;
	}

	public void setWholesale(ProductPriceFixed wholesale) {
		this.wholesale = wholesale;
	}

	public ProductPriceFixed getRetail() {
		return retail;
	}

	public void setRetail(ProductPriceFixed retail) {
		this.retail = retail;
	}

	@Override
	public String toString() {
		return "ProductPricesFixed [wholesale=" + wholesale + ", retail=" + retail + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
