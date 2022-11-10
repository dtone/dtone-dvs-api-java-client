package com.dtone.dvs.dto;

import java.util.HashMap;
import java.util.Map;

import com.dtone.dvs.util.Constants;

public class CampaignFilter {

	private Integer page;

	private Integer perPage;

	private String countryIsoCode;

	private Long operatorId;

	private Long productId;

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

	public String getCountryIsoCode() {
		return countryIsoCode;
	}

	public void setCountryIsoCode(String countryIsoCode) {
		this.countryIsoCode = countryIsoCode;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Map<String, String> getQueryParameterMap() {
		Map<String, String> queryParameterMap = new HashMap<>();

		if (null != productId) {
			queryParameterMap.put(Constants.PRODUCT_ID, String.valueOf(productId));
		}

		if (null != operatorId) {
			queryParameterMap.put(Constants.OPERATOR_ID, String.valueOf(operatorId));
		}

		if (null != countryIsoCode) {
			queryParameterMap.put(Constants.COUNTRY_ISO_CODE, countryIsoCode);
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
