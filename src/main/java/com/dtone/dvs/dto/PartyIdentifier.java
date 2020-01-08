package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PartyIdentifier {
	
	@JsonProperty(value = "mobile_number")
	private String mobileNumber;

	@JsonProperty(value = "account_number")
	private String accountNumber;

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

	@Override
	public String toString() {
		return "PartyIdentifier [mobileNumber=" + mobileNumber + ", accountNumber=" + accountNumber + "]";
	}

}
