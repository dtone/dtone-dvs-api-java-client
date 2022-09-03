package com.dtone.dvs.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Operator {
  private Long id;

  private String name;

  private List<Region> regions;

  private Country country;

  private Boolean identified;
}
