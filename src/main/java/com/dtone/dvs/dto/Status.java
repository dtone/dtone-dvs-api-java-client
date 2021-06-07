package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "message")
	private String message;

	@JsonProperty(value = "class")
	private StatusClass statusClass;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StatusClass getStatusClass() {
		return statusClass;
	}

	public void setStatusClass(StatusClass statusClass) {
		this.statusClass = statusClass;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", message=" + message + ", statusClass=" + statusClass + "]";
	}

}
