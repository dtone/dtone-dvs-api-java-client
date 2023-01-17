package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rates {

	@JsonProperty(value = "base")
	private Double base;

	@JsonProperty(value = "wholesale")
	private Double wholesale;

	@JsonProperty(value = "retail", required = false)
	private Double retail;

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

	public Double getRetail() {
		return retail;
	}

	public void setRetail(Double retail) {
		this.retail = retail;
	}

	@Override
	public String toString() {
		return "Rates [base=" + base + ", wholesale=" + wholesale + ", retail=" + retail + "]";
	}

}
