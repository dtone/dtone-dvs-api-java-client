package com.dtone.dvs.dto;

import java.util.HashMap;
import java.util.Map;

import com.dtone.dvs.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PromotionFilter {

	private String countryIsoCode;
	private Long operatorId;
	private Long productId;

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

}
