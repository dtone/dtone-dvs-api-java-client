package com.dtone.dvs.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Dates {
	@JsonProperty(value = "due")
	private Date due;

	@JsonProperty(value = "statement")
	private Date statement;

}
