package com.dtone.dvs.util;

import com.dtone.dvs.dto.AmountRanged;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RangedProductUtils {

	private static final ObjectMapper mapper = new ObjectMapper();

	public static AmountRanged toAmountRanged(Object object) {

		if (null == object) {
			return null;
		}

		try {
			return mapper.convertValue(object, new TypeReference<AmountRanged>() {
			});
		} catch (Exception e) {
			return null;
		}

	}

}
