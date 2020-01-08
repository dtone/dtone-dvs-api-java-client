package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {
	@JsonProperty(value = "iso_code")
	private String isoCode;
	
	private String name;
	
	private String regions;

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegions() {
		return regions;
	}

	public void setRegions(String regions) {
		this.regions = regions;
	}

	@Override
	public String toString() {
		return "Country [isoCode=" + isoCode + ", name=" + name + ", regions=" + regions + "]";
	}

}
