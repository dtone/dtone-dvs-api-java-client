package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatementDates {
	@JsonProperty(value = "due")
	private String due;

	@JsonProperty(value = "statement")
	private String statement;

	public String getDue() {
		return due;
	}

	public void setDue(String due) {
		this.due = due;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	@Override
	public String toString() {
		return "StatementDates [due=" + due + ", statement=" + statement + "]";
	}

}
