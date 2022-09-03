package com.dtone.dvs.dto;

import java.util.HashMap;
import java.util.List;
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
public class ProductFilter {

	private ProductType type;

	private Long serviceId;

	private String countryIsoCode;

	private Long operatorId;

	private String region;

	private List<BenefitTypes> benefitTypes;

	public Map<String, String> getQueryParameterMap() {
		Map<String, String> queryParameterMap = new HashMap<>();

		if (null != type) {
			queryParameterMap.put(Constants.TYPE, type.toString());
		}

		if (null != serviceId && serviceId > 0L) {
			queryParameterMap.put(Constants.SERVICE_ID, String.valueOf(serviceId));
		}

		if (null != countryIsoCode) {
			queryParameterMap.put(Constants.COUNTRY_ISO_CODE, countryIsoCode);
		}

		if (null != operatorId && operatorId > 0L) {
			queryParameterMap.put(Constants.OPERATOR_ID, String.valueOf(operatorId));
		}

		if (null != region) {
			queryParameterMap.put(Constants.REGION, region);
		}

		if (null != benefitTypes) {
			queryParameterMap.put(Constants.BENEFIT_TYPES_QP,
					benefitTypes.toString().replace(Constants.RIGHT_BRACKET, Constants.EMPTY_STRING)
							.replace(Constants.LEFT_BRACKET, Constants.EMPTY_STRING).replaceAll(Constants.SINGLE_SPACE, Constants.EMPTY_STRING));
		}

		if (queryParameterMap.isEmpty()) {
			return null;
		}
		return queryParameterMap;

	}

}
