package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StatementIdentifier {

	@JsonProperty(value = "reference")
	private String reference;

	@JsonProperty(value = "due_date")
	private String dueDate;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "StatementIdentifier [reference=" + reference + ", dueDate=" + dueDate + "]";
	}

}
