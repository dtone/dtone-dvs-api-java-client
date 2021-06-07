package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Values {

	@JsonProperty(value = "source")
	private Source source;

	@JsonProperty(value = "destination")
	private Source destination;

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Source getDestination() {
		return destination;
	}

	public void setDestination(Source destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Values [source=" + source + ", destination=" + destination + "]";
	}

}
