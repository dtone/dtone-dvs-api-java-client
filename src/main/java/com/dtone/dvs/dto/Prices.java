package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Prices {

	@JsonProperty(value = "wholesale")
	private Price wholesale;

	@JsonProperty(value = "retail")
	private Price retail;

	public Price getWholesale() {
		return wholesale;
	}

	public void setWholesale(Price wholesale) {
		this.wholesale = wholesale;
	}

	public Price getRetail() {
		return retail;
	}

	public void setRetail(Price retail) {
		this.retail = retail;
	}

	@Override
	public String toString() {
		return "Prices [wholesale=" + wholesale + ", retail=" + retail + "]";
	}

}
