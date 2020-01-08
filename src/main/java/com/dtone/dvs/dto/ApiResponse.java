package com.dtone.dvs.dto;

import java.util.ArrayList;
import java.util.List;

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

	public ApiResponse() {
	}

	public ApiResponse(boolean success, Integer code, List<Error> errors) {
		this.success = success;
		this.code = code;
		this.errors = errors;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<Error> getErrors() {
		if (null == errors) {
			errors = new ArrayList<>();
		}
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}
	
	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	@Override
	public String toString() {
		return "ApiResponse [success=" + success + ", code=" + code + ", errors=" + errors + ", result=" + result
				+ ", totalPages=" + totalPages + ", totalRecords=" + totalRecords + ", currentPage=" + currentPage
				+ ", recordsPerPage=" + recordsPerPage + "]";
	}

}
