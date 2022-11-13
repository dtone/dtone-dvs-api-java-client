package com.dtone.dvs.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionFixed extends Transaction {

	@JsonProperty(value = "benefits")
	private List<BenefitFixed> benefits;

	public List<BenefitFixed> getBenefits() {
		return benefits;
	}

	public void setBenefits(List<BenefitFixed> benefits) {
		this.benefits = benefits;
	}

	@Override
	public String toString() {
		return "TransactionFixed [benefits=" + benefits + ", id=" + getId() + ", externalId="
				+ getExternalId() + ", creationDate=" + getCreationDate() + ", confirmationExpirationDate="
				+ getConfirmationExpirationDate() + ", confirmationDate=" + getConfirmationDate()
				+ ", status=" + getStatus() + ", operatorReference=" + getOperatorReference() + ", pin="
				+ getPin() + ", product=" + getProduct() + ", prices=" + getPrices() + ", rates="
				+ getRates() + ", promotions=" + getPromotions() + ", requestedValues=" + getRequestedValues()
				+ ", beneficiary=" + getBeneficiary() + ", debitPartyIdentifier=" + getDebitPartyIdentifier()
				+ ", creditPartyIdentifier=" + getCreditPartyIdentifier() + ", statementIdentifier="
				+ getStatementIdentifier() + ", callbackUrl=" + getCallbackUrl() + "]";
	}

}
