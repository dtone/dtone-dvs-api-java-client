package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PartyIdentifier {

	@JsonProperty(value = "mobile_number")
	private String mobileNumber;

	@JsonProperty(value = "account_number")
	private String accountNumber;

	@JsonProperty(value = "account_qualifier")
	private String accountQualifier;

	public PartyIdentifier() {
	}

	public PartyIdentifier(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public PartyIdentifier(String mobileNumber, String accountNumber) {
		this.mobileNumber = mobileNumber;
		this.accountNumber = accountNumber;
	}

	public PartyIdentifier(String mobileNumber, String accountNumber, String accountQualifier) {
		this.mobileNumber = mobileNumber;
		this.accountNumber = accountNumber;
		this.accountQualifier = accountQualifier;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountQualifier() {
		return accountQualifier;
	}

	public void setAccountQualifier(String accountQualifier) {
		this.accountQualifier = accountQualifier;
	}

	@Override
	public String toString() {
		return "PartyIdentifier [mobileNumber=" + mobileNumber + ", accountNumber=" + accountNumber
				+ ", accountQualifier=" + accountQualifier + "]";
	}

}
