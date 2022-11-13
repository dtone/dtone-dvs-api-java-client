package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class LookupOperatorRequest extends ApiRequest {

	public LookupOperatorRequest(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LookupOperatorRequest(String mobileNumber, Integer page, Integer perPage) {
		this.mobileNumber = mobileNumber;
		this.page = page;
		this.perPage = perPage;
	}

	@JsonProperty(value = "mobile_number")
	private String mobileNumber;

	@JsonProperty(value = "page")
	private Integer page;

	@JsonProperty(value = "per_page")
	private Integer perPage;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPerPage() {
		return perPage;
	}

	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}

	@Override
	public String toString() {
		return "LookupOperatorRequest [mobileNumber=" + mobileNumber + ", page=" + page + ", perPage=" + perPage + "]";
	}

}
