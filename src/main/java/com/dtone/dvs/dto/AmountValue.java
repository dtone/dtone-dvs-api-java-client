package com.dtone.dvs.dto;

import java.math.BigDecimal;

import com.dtone.dvs.serdes.AmountValueDes;
import com.dtone.dvs.serdes.AmountValueSer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonDeserialize(using = AmountValueDes.class)
@JsonSerialize(using = AmountValueSer.class)
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
