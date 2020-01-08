package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class TransactionRequest extends ApiRequest {

	@JsonProperty(value = "external_id")
	private String externalId;

	@JsonProperty(value = "product_id")
	private Long productId;

	@JsonProperty(value = "calculation_mode")
	private CalculationMode calculationMode;

	@JsonProperty(value = "source")
	private Source source;

	@JsonProperty(value = "destination")
	private Source destination;

	@JsonProperty(value = "auto_confirm")
	private Boolean autoConfirm;

	@JsonProperty(value = "sender")
	private Party sender;

	@JsonProperty(value = "beneficiary")
	private Party beneficiary;

	@JsonProperty(value = "debit_party_identifier")
	private PartyIdentifier debitPartyIdentifier;

	@JsonProperty(value = "credit_party_identifier")
	private PartyIdentifier creditPartyIdentifier;

	@JsonProperty(value = "callback_url")
	private String callbackUrl;

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public CalculationMode getCalculationMode() {
		return calculationMode;
	}

	public void setCalculationMode(CalculationMode calculationMode) {
		this.calculationMode = calculationMode;
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

	public Boolean getAutoConfirm() {
		return autoConfirm;
	}

	public void setAutoConfirm(Boolean autoConfirm) {
		this.autoConfirm = autoConfirm;
	}

	public Party getSender() {
		return sender;
	}

	public void setSender(Party sender) {
		this.sender = sender;
	}

	public Party getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Party beneficiary) {
		this.beneficiary = beneficiary;
	}

	public PartyIdentifier getDebitPartyIdentifier() {
		return debitPartyIdentifier;
	}

	public void setDebitPartyIdentifier(PartyIdentifier debitPartyIdentifier) {
		this.debitPartyIdentifier = debitPartyIdentifier;
	}

	public PartyIdentifier getCreditPartyIdentifier() {
		return creditPartyIdentifier;
	}

	public void setCreditPartyIdentifier(PartyIdentifier creditPartyIdentifier) {
		this.creditPartyIdentifier = creditPartyIdentifier;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

}
