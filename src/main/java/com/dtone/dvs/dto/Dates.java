package com.dtone.dvs.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dates {
	@JsonProperty(value = "due")
	private Date due;

	@JsonProperty(value = "statement")
	private Date statement;

	public Date getDue() {
		return due;
	}

	public void setDue(Date due) {
		this.due = due;
	}

	public Date getStatement() {
		return statement;
	}

	public void setStatement(Date statement) {
		this.statement = statement;
	}

}
