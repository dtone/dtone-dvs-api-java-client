package com.dtone.dvs.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AccountBalance {
	@JsonProperty(value = "unit_type")
	private UnitTypes unitType;

	@JsonProperty(value = "unit")
	private String unit;

	@JsonProperty(value = "amount")
	private BigDecimal amount;

}
