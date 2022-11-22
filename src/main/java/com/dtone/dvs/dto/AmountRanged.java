package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AmountRanged {

	@JsonProperty(value = "min")
	private Double min;

	@JsonProperty(value = "max")
	private Double max;

	@JsonProperty(value = "increment", required = false)
	private Double increment;

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}

	public Double getIncrement() {
		return increment;
	}

	public void setIncrement(Double increment) {
		this.increment = increment;
	}

	@Override
	public String toString() {
		return "AmountRanged [min=" + min + ", max=" + max + ", increment=" + increment + "]";
	}

}
