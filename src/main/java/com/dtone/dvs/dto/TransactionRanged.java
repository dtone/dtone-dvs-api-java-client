package com.dtone.dvs.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionRanged extends Transaction {

	@JsonProperty(value = "benefits")
	private List<BenefitRanged> benefits;

	public List<BenefitRanged> getBenefits() {
		return benefits;
	}

	public void setBenefits(List<BenefitRanged> benefits) {
		this.benefits = benefits;
	}

	@Override
	public String toString() {
		return "TransactionRanged [benefits=" + benefits + ", id=" + getId() + ", externalId="
				+ getExternalId() + ", creationDate=" + getCreationDate() + ", confirmationExpirationDate="
				+ getConfirmationExpirationDate() + ", confirmationDate=" + getConfirmationDate()
				+ ", status=" + getStatus() + ", operatorReference=" + getOperatorReference() + ", pin="
				+ getPin() + ", product=" + getProduct() + ", prices=" + getPrices() + ", rates="
				+ getRates() + ", promotions=" + getPromotions() + ", requestedValues=" + getRequestedValues()
				+ ", adjustedValues=" + getAdjustedValues() + ", sender=" + getSender()
				+ ", beneficiary=" + getBeneficiary() + ", debitPartyIdentifier=" + getDebitPartyIdentifier()
				+ ", creditPartyIdentifier=" + getCreditPartyIdentifier() + ", statementIdentifier="
				+ getStatementIdentifier() + ", callbackUrl=" + getCallbackUrl() + "]";
	}

}
