package com.dtone.dvs.dto;

public class Validity {
	private String unit;
	private Long quantity;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Validity [unit=" + unit + ", quantity=" + quantity + "]";
	}

}
