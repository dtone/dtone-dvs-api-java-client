package com.dtone.dvs.dto;

import java.util.HashMap;
import java.util.Map;

import com.dtone.dvs.util.Constants;

public class TransactionFilter {

	private String externalId;

	public TransactionFilter() {
	}

	public TransactionFilter(String externalId) {
		this.externalId = externalId;
	}

	public Map<String, String> getQueryParameterMap() {
		Map<String, String> queryParameterMap = new HashMap<>();

		if (null != externalId) {
			queryParameterMap.put(Constants.EXTERNAL_ID, externalId);
		}

		if (queryParameterMap.isEmpty()) {
			return null;
		}
		return queryParameterMap;

	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	@Override
	public String toString() {
		return "TransactionFilter [externalId=" + externalId + "]";
	}

}
