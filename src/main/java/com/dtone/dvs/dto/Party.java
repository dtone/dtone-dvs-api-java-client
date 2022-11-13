package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
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

	@JsonProperty(value = "address_text")
	private String addressText;

	@JsonProperty(value = "address_city")
	private String addressCity;

	@JsonProperty(value = "address_country_iso_code")
	private String addressCountryIsoCode;

	@JsonProperty(value = "address_postal_code")
	private String addressPostalCode;

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

	public String getAddressText() {
		return addressText;
	}

	public void setAddressText(String addressText) {
		this.addressText = addressText;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressCountryIsoCode() {
		return addressCountryIsoCode;
	}

	public void setAddressCountryIsoCode(String addressCountryIsoCode) {
		this.addressCountryIsoCode = addressCountryIsoCode;
	}

	public String getAddressPostalCode() {
		return addressPostalCode;
	}

	public void setAddressPostalCode(String addressPostalCode) {
		this.addressPostalCode = addressPostalCode;
	}

	@Override
	public String toString() {
		return "Party [lastName=" + lastName + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", nationalityCountryIsoCode=" + nationalityCountryIsoCode + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", addressText=" + addressText + ", addressCity=" + addressCity
				+ ", addressCountryIsoCode=" + addressCountryIsoCode + ", addressPostalCode=" + addressPostalCode + "]";
	}

}
