package com.dtone.dvs.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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

	@JsonProperty(value = "required_statement_identifier_fields")
	private List<List<String>> requiredStatementIdentifierFields;

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

	@JsonProperty(value = "validity", required = false)
	private Validity validity;
}
