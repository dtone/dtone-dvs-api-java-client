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
public class StatementFilter {

	private String accountNumber;

	private Integer page;

	private Integer perPage;

	private Long productId;

	private String accountQualifier;

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

		return queryParameterMap;

	}

}
