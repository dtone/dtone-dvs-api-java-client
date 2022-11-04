package com.dtone.dvs.util;

public class NumberUtils {

	public static Double toDouble(Object object) {

		if (null == object) {
			return null;
		}

		try {
			if (object instanceof Integer) {
				return Double.valueOf(object.toString());
			} else {
				return (Double) object;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
