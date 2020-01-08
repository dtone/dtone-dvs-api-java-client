package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pin {

	@JsonProperty(value = "code")
	private String code;

	@JsonProperty(value = "serial")
	private String serial;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	@Override
	public String toString() {
		return "Status [code=" + code + ", serial=" + serial + "]";
	}

}
