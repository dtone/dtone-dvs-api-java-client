package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getNationalityCountryIsoCode() {
		return nationalityCountryIsoCode;
	}

	public void setNationalityCountryIsoCode(String nationalityCountryIsoCode) {
		this.nationalityCountryIsoCode = nationalityCountryIsoCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Party [lastName=" + lastName + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", nationalityCountryIsoCode=" + nationalityCountryIsoCode + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + "]";
	}

}
