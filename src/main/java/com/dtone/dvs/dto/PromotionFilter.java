package com.dtone.dvs.dto;

import java.util.HashMap;
import java.util.Map;

import com.dtone.dvs.util.Constants;

public class PromotionFilter {

	private String countryIsoCode;
	private Long operatorId;
	private Long productId;

	public PromotionFilter(String countryIsoCode, Long operatorId, Long productId) {
		this.countryIsoCode = countryIsoCode;
		this.operatorId = operatorId;
		this.productId = productId;
	}

	public PromotionFilter() {
	}

	public Map<String, String> getQueryParameterMap() {
		Map<String, String> queryParameterMap = new HashMap<>();

		if (null != countryIsoCode) {
			queryParameterMap.put(Constants.COUNTRY_ISO_CODE, countryIsoCode);
		}

		if (null != operatorId && operatorId > 0L) {
			queryParameterMap.put(Constants.OPERATOR_ID, String.valueOf(operatorId));
		}

		if (null != productId && productId > 0L) {
			queryParameterMap.put(Constants.PRODUCT_ID, String.valueOf(productId));
		}

		if (queryParameterMap.isEmpty()) {
			return null;
		}
		return queryParameterMap;

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

	@Override
	public String toString() {
		return "PromotionFilter [countryIsoCode=" + countryIsoCode + ", operatorId=" + operatorId + ", productId="
				+ productId + "]";
	}

}
