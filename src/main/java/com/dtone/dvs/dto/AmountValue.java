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
public class AmountValue {

  /**
   * Minimum amount
   */
  @JsonProperty(value = "min")
  private BigDecimal min;

  /**
   * Maximum amount
   */
  @JsonProperty(value = "max")
  private BigDecimal max;

  /**
   * Single node value for non-ranged products
   */
  private BigDecimal value;

}
