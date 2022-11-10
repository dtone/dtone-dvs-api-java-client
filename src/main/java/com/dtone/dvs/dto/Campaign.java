package com.dtone.dvs.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Campaign {
	@JsonProperty(value = "id")
	private String id;

	@JsonProperty(value = "title")
	private UnitTypes title;

	@JsonProperty(value = "description")
	private String description;

	@JsonProperty(value = "terms")
	private BigDecimal terms;

	@JsonProperty(value = "start_date")
	private String startDate;

	@JsonProperty(value = "end_date")
	private String endDate;

	@JsonProperty(value = "products")
	private List<Product> products;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UnitTypes getTitle() {
		return title;
	}

	public void setTitle(UnitTypes title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getTerms() {
		return terms;
	}

	public void setTerms(BigDecimal terms) {
		this.terms = terms;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Campaign [id=" + id + ", title=" + title + ", description=" + description + ", terms=" + terms
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", products=" + products + "]";
	}

}
