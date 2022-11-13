package com.dtone.dvs.dto;

import java.util.List;

public class ErrorResponse {
	private List<ApiError> errors;

	public ErrorResponse() {
	}

	public ErrorResponse(List<ApiError> errors) {
		this.errors = errors;
	}

	public List<ApiError> getErrors() {
		return errors;
	}

	public void setErrors(List<ApiError> errors) {
		this.errors = errors;
	}

}
