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
public class TransactionResponse {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "external_id")
	private String externalId;

	@JsonProperty(value = "creation_date")
	private String creationDate;

	@JsonProperty(value = "confirmation_expiration_date")
	private String confirmationExpirationDate;

	@JsonProperty(value = "confirmation_date")
	private String confirmationDate;

	@JsonProperty(value = "status")
	private Status status;

	@JsonProperty(value = "operator_reference")
	private String operatorReference;

	@JsonProperty(value = "pin")
	private Pin pin;

	@JsonProperty(value = "product")
	private Product product;

	@JsonProperty(value = "prices")
	private Prices prices;

	@JsonProperty(value = "rates")
	private Rates rates;

	@JsonProperty(value = "benefits")
	private List<Benefit> benefits;

	@JsonProperty(value = "promotions")
	private List<Promotion> promotions;

	@JsonProperty(value = "requested_values")
	private Values requestedValues;

	@JsonProperty(value = "adjusted_values")
	private Values adjustedValues;

	@JsonProperty(value = "sender")
	private Party sender;

	@JsonProperty(value = "beneficiary")
	private Party beneficiary;

	@JsonProperty(value = "debit_party_identifier")
	private PartyIdentifier debitPartyIdentifier;

	@JsonProperty(value = "credit_party_identifier")
	private PartyIdentifier creditPartyIdentifier;

}
