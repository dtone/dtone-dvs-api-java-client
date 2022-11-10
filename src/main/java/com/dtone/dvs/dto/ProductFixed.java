package com.dtone.dvs.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductFixed extends Product {

	@JsonProperty(value = "benefits")
	private List<BenefitFixed> benefits;

	@JsonProperty(value = "source")
	private SourceFixed source;

	@JsonProperty(value = "destination")
	private SourceFixed destination;

	@JsonProperty(value = "prices")
	private ProductPricesFixed prices;

	public List<BenefitFixed> getBenefits() {
		return benefits;
	}

	public void setBenefits(List<BenefitFixed> benefits) {
		this.benefits = benefits;
	}

	public SourceFixed getSource() {
		return source;
	}

	public void setSource(SourceFixed source) {
		this.source = source;
	}

	public SourceFixed getDestination() {
		return destination;
	}

	public void setDestination(SourceFixed destination) {
		this.destination = destination;
	}

	public ProductPricesFixed getPrices() {
		return prices;
	}

	public void setPrices(ProductPricesFixed prices) {
		this.prices = prices;
	}

	@Override
	public String toString() {
		return "ProductFixed [benefits=" + benefits + ", source=" + source + ", destination=" + destination
				+ ", prices=" + prices + ", getId()=" + getId() + ", getName()=" + getName() + ", getDescription()="
				+ getDescription() + ", getType()=" + getType() + ", getService()=" + getService() + ", getOperator()="
				+ getOperator() + ", getRegions()=" + getRegions() + ", getRequiredDebitPartyIdentifierFields()="
				+ getRequiredDebitPartyIdentifierFields() + ", getRequiredCreditPartyIdentifierFields()="
				+ getRequiredCreditPartyIdentifierFields() + ", getRequiredSenderFields()=" + getRequiredSenderFields()
				+ ", getRequiredBeneficiaryFields()=" + getRequiredBeneficiaryFields()
				+ ", getRequiredStatementIdentifierFields()=" + getRequiredStatementIdentifierFields()
				+ ", getAvailabilityZones()=" + getAvailabilityZones() + ", getRates()=" + getRates()
				+ ", getPromotions()=" + getPromotions() + ", getValidity()=" + getValidity() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
