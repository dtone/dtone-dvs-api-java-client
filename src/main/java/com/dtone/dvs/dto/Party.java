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
public class Party {

	@JsonProperty(value = "last_name")
	private String lastName;

	@JsonProperty(value = "first_name")
	private String firstName;

	@JsonProperty(value = "middle_name")
	private String middleName;

	@JsonProperty(value = "nationality_country_iso_code")
	private String nationalityCountryIsoCode;

	@JsonProperty(value = "mobile_number")
	private String mobileNumber;

	@JsonProperty(value = "email")
	private String email;

}
