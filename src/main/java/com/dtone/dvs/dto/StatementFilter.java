package com.dtone.dvs.dto;

import java.util.HashMap;
import java.util.Map;

import com.dtone.dvs.util.Constants;

public class StatementFilter {

	private String accountNumber;

	private Integer page;

	private Integer perPage;

	private Long productId;

	private String accountQualifier;

	public StatementFilter() {
	}

	public StatementFilter(String accountNumber, Long productId) {
		this.accountNumber = accountNumber;
		this.productId = productId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getAccountQualifier() {
		return accountQualifier;
	}

	public void setAccountQualifier(String accountQualifier) {
		this.accountQualifier = accountQualifier;
	}

	public Map<String, String> getQueryParameterMap() {
		Map<String, String> queryParameterMap = new HashMap<>();

		queryParameterMap.put(Constants.PRODUCT_ID, String.valueOf(productId));

		if (null != accountQualifier) {
			queryParameterMap.put(Constants.ACCOUNT_QUALIFIER, accountQualifier);
		}

		if (null != page) {
			queryParameterMap.put(Constants.PAGE, String.valueOf(page));
		}

		if (null != perPage) {
			queryParameterMap.put(Constants.PER_PAGE, String.valueOf(perPage));
		}

		if (queryParameterMap.isEmpty()) {
			return null;
		}

		return queryParameterMap;

	}

}
