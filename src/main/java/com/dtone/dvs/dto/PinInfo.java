package com.dtone.dvs.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PinInfo {

	@JsonProperty(value = "usage_info")
	private List<String> usageInfo;

	@JsonProperty(value = "validity")
	private Validity validity;

	@JsonProperty(value = "terms")
	private String terms;

	public List<String> getUsageInfo() {
		return usageInfo;
	}

	public void setUsageInfo(List<String> usageInfo) {
		this.usageInfo = usageInfo;
	}

	public Validity getValidity() {
		return validity;
	}

	public void setValidity(Validity validity) {
		this.validity = validity;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	@Override
	public String toString() {
		return "PinInfo [usageInfo=" + usageInfo + ", validity=" + validity + ", terms=" + terms + "]";
	}

}
