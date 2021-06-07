package com.dtone.dvs.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "description")
	private String description;

	@JsonProperty(value = "type")
	private String type;

	@JsonProperty(value = "service")
	private Service service;

	@JsonProperty(value = "operator")
	private Operator operator;

	@JsonProperty(value = "regions")
	private List<Region> regions;

	@JsonProperty(value = "required_debit_party_identifier_fields")
	private List<List<String>> requiredDebitPartyIdentifierFields;

	@JsonProperty(value = "required_credit_party_identifier_fields")
	private List<List<String>> requiredCreditPartyIdentifierFields;

	@JsonProperty(value = "required_sender_fields")
	private List<List<String>> requiredSenderFields;

	@JsonProperty(value = "required_beneficiary_fields")
	private List<List<String>> requiredBeneficiaryFields;

	@JsonProperty(value = "availability_zones")
	private List<String> availabilityZones;

	@JsonProperty(value = "source")
	private Source source;

	@JsonProperty(value = "destination")
	private Source destination;

	@JsonProperty(value = "prices")
	private Prices prices;

	@JsonProperty(value = "rates")
	private Rates rates;

	@JsonProperty(value = "benefits")
	private List<Benefit> benefits;

	@JsonProperty(value = "promotions")
	private List<Promotion> promotions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public List<List<String>> getRequiredDebitPartyIdentifierFields() {
		return requiredDebitPartyIdentifierFields;
	}

	public void setRequiredDebitPartyIdentifierFields(List<List<String>> requiredDebitPartyIdentifierFields) {
		this.requiredDebitPartyIdentifierFields = requiredDebitPartyIdentifierFields;
	}

	public List<List<String>> getRequiredCreditPartyIdentifierFields() {
		return requiredCreditPartyIdentifierFields;
	}

	public void setRequiredCreditPartyIdentifierFields(List<List<String>> requiredCreditPartyIdentifierFields) {
		this.requiredCreditPartyIdentifierFields = requiredCreditPartyIdentifierFields;
	}

	public List<List<String>> getRequiredSenderFields() {
		return requiredSenderFields;
	}

	public void setRequiredSenderFields(List<List<String>> requiredSenderFields) {
		this.requiredSenderFields = requiredSenderFields;
	}

	public List<List<String>> getRequiredBeneficiaryFields() {
		return requiredBeneficiaryFields;
	}

	public void setRequiredBeneficiaryFields(List<List<String>> requiredBeneficiaryFields) {
		this.requiredBeneficiaryFields = requiredBeneficiaryFields;
	}

	public List<String> getAvailabilityZones() {
		return availabilityZones;
	}

	public void setAvailabilityZones(List<String> availabilityZones) {
		this.availabilityZones = availabilityZones;
	}

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

	public Prices getPrices() {
		return prices;
	}

	public void setPrices(Prices prices) {
		this.prices = prices;
	}

	public Rates getRates() {
		return rates;
	}

	public void setRates(Rates rates) {
		this.rates = rates;
	}

	public List<Benefit> getBenefits() {
		return benefits;
	}

	public void setBenefits(List<Benefit> benefits) {
		this.benefits = benefits;
	}

	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type + ", service="
				+ service + ", operator=" + operator + ", regions=" + regions + ", requiredDebitPartyIdentifierFields="
				+ requiredDebitPartyIdentifierFields + ", requiredCreditPartyIdentifierFields="
				+ requiredCreditPartyIdentifierFields + ", requiredSenderFields=" + requiredSenderFields
				+ ", requiredBeneficiaryFields=" + requiredBeneficiaryFields + ", availabilityZones="
				+ availabilityZones + ", source=" + source + ", destination=" + destination + ", prices=" + prices
				+ ", rates=" + rates + ", benefits=" + benefits + ", promotions=" + promotions + "]";
	}

}
