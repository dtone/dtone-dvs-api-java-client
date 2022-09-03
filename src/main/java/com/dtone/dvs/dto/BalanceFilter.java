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
public class BalanceFilter {

	private UnitTypes unitTypes;

	private String unit;

	public BalanceFilter(String unit) {
		this.unit = unit;
	}

	public BalanceFilter(UnitTypes unitTypes) {
		this.unitTypes = unitTypes;
	}

	public Map<String, String> getQueryParameterMap() {
		Map<String, String> queryParameterMap = new HashMap<>();

		if (null != unit) {
			queryParameterMap.put(Constants.UNIT, unit);
		}

		if (null != unitTypes) {
			queryParameterMap.put(Constants.UNIT_TYPE, unitTypes.toString());
		}

		if (queryParameterMap.isEmpty()) {
			return null;
		}
		return queryParameterMap;

	}

}
