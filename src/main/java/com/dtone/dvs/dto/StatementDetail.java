package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StatementDetail {

	@JsonProperty(value = "reference")
	private String reference;

	@JsonProperty(value = "dates")
	private Dates dates;

	@JsonProperty(value = "balance")
	private AccountBalance balance;

}
