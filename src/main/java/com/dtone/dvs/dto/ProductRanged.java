package com.dtone.dvs.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductRanged extends Product {

	@JsonProperty(value = "benefits")
	private List<BenefitRanged> benefits;

	@JsonProperty(value = "source")
	private SourceRanged source;

	@JsonProperty(value = "destination")
	private SourceRanged destination;

	@JsonProperty(value = "prices")
	private ProductPricesRanged prices;

	public List<BenefitRanged> getBenefits() {
		return benefits;
	}

	public void setBenefits(List<BenefitRanged> benefits) {
		this.benefits = benefits;
	}

	public SourceRanged getSource() {
		return source;
	}

	public void setSource(SourceRanged source) {
		this.source = source;
	}

	public SourceRanged getDestination() {
		return destination;
	}

	public void setDestination(SourceRanged destination) {
		this.destination = destination;
	}

	public ProductPricesRanged getPrices() {
		return prices;
	}

	public void setPrices(ProductPricesRanged prices) {
		this.prices = prices;
	}

	@Override
	public String toString() {
		return "ProductRanged [benefits=" + benefits + ", source=" + source + ", destination=" + destination
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
