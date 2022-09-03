package com.dtone.dvs.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ApiResponse<T> {
	private boolean success;
	private int code;
	private List<Error> errors;
	private T result;

	private int totalPages;
	private int totalRecords;
	private int currentPage;
	private int recordsPerPage;
	private int nextPage;
	private int previousPage;

	public ApiResponse(boolean success, Integer code, List<Error> errors) {
		this.success = success;
		this.code = code;
		this.errors = errors;
	}

	public List<Error> getErrors() {
		if (null == errors) {
			errors = new ArrayList<>();
		}
		return errors;
	}

}
