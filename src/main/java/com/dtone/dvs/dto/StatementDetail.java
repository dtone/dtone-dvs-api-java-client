package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatementDetail {

	@JsonProperty(value = "reference")
	private String reference;

	@JsonProperty(value = "dates")
	private Dates dates;

	@JsonProperty(value = "balance")
	private AccountBalance balance;

}
