package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Amount {

  @JsonProperty(value = "base")
  private AmountValue base;

  @JsonProperty(value = "promotion_bonus")
  private AmountValue promotionBonus;

  @JsonProperty(value = "total_excluding_tax")
  private AmountValue totalExcludingTax;

}
