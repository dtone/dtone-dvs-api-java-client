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
public class Status {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "message")
	private String message;
	
	@JsonProperty(value = "class")
	private StatusClass statusClass;
}
