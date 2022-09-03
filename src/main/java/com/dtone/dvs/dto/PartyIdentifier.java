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
public class PartyIdentifier {
	
	@JsonProperty(value = "mobile_number")
	private String mobileNumber;

	@JsonProperty(value = "account_number")
	private String accountNumber;

}
