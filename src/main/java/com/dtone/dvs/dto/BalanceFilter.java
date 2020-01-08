package com.dtone.dvs.dto;

import java.util.HashMap;
import java.util.Map;

import com.dtone.dvs.util.Constants;

public class BalanceFilter {

	private UnitTypes unitTypes;

	private String unit;

	public BalanceFilter(String unit) {
		this.unit = unit;
	}

	public BalanceFilter(UnitTypes unitTypes) {
		this.unitTypes = unitTypes;
	}

	public BalanceFilter(UnitTypes unitTypes, String unit) {
		this.unitTypes = unitTypes;
		this.unit = unit;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public UnitTypes getUnitTypes() {
		return unitTypes;
	}

	public void setUnitTypes(UnitTypes unitTypes) {
		this.unitTypes = unitTypes;
	}

	@Override
	public String toString() {
		return "BalanceFilter [unitTypes=" + unitTypes + ", unit=" + unit + "]";
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
