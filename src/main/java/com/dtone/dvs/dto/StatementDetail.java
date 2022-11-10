package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatementDetail {

	@JsonProperty(value = "reference")
	private String reference;

	@JsonProperty(value = "dates")
	private StatementDates dates;

	@JsonProperty(value = "balance")
	private StatementBalance balance;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public StatementDates getDates() {
		return dates;
	}

	public void setDates(StatementDates dates) {
		this.dates = dates;
	}

	public StatementBalance getBalance() {
		return balance;
	}

	public void setBalance(StatementBalance balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "StatementDetail [reference=" + reference + ", dates=" + dates + ", balance=" + balance + "]";
	}

}
