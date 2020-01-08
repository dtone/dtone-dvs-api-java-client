package com.dtone.dvs.dto;

import java.util.List;

public class ErrorResponse {
	private List<Error> errors;

	public ErrorResponse() {
	}

	public ErrorResponse(List<Error> errors) {
		this.errors = errors;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

}
