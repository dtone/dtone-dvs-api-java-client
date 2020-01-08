package com.dtone.dvs.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Promotion {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "title")
	private String title;
	
	@JsonProperty(value = "description")
	private String description;
	
	@JsonProperty(value = "terms")
	private String terms;
	
	@JsonProperty(value = "start_date")
	private String startDate;
	
	@JsonProperty(value = "end_date")
	private String endDate;
	
	@JsonProperty(value = "operator")
	private Operator operator;
	
	@JsonProperty(value = "products")
	private List<Product> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
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

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Promotion [id=" + id + ", title=" + title + ", description=" + description + ", terms=" + terms
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", operator=" + operator + ", products="
				+ products + "]";
	}

}
