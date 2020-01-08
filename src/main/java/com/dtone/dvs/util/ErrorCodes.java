package com.dtone.dvs.util;

public enum ErrorCodes {

	UNAUTHORIZED("1000401", "Unauthorized"), 
	RESOURCE_NOT_FOUND("1000404", "Resource not found"),
	PRODUCT_NOT_AVAILABLE("1003001", "Product is not available in your account"),
	PRODUCT_AMOUNT_OUT_OF_RANGE("1003002", "Requested product amount is out of range"),
	PRODUCT_UNIT_IS_INVALID("1003003", "Requested product unit is invalid"),
	BENEFITS_NOT_DEFINED("1003101", "Benefits not defined for available products"),
	PROMOTION_NOT_FOUND("1003201", "Promotion not found"),
	CREDIT_PARTY_MOBILE_NUMBER_INVALID("1005003", "Credit party mobile number is invalid"),
	SERVICE_NOT_FOUND("1005004", "Service not found"), 
	COUNTRY_NOT_FOUND("1005005", "Country not found"),
	OPERATOR_NOT_FOUND("1005006", "Operator not found"),
	SENDER_MOBILE_NUMBER_INVALID("1005503", "Sender mobile number is invalid"),
	INSUFFICIENT_BALANCE("1006001", "Insufficient balance"),
	DEBIT_PARTY_MOBILE_NUMBER_INVALID("1006003", "Debit party mobile number is invalid"),
	ACCOUNT_BALANCE_NOT_FOUND("1006009", "Account balance not found"),
	BENEFICIARY_MOBILE_NUMBER_INVALID("1006503", "Beneficiary mobile number is invalid"),
	TXN_EXTERNAL_ID_ALREADY_USED("1007001", "Transaction external ID has already been used"),
	TXN_ALREADY_CONFIRMED("1007002", "Transaction has already been confirmed"),
	TXN_CANNOT_BE_CONFIRMED("1007004", "Transaction can no longer be confirmed"),
	TXN_ALREADY_CANCELLED("1007005", "Transaction has already been cancelled"),
	TXN_CANNOT_BE_CANCELLED("1007007", "Transaction can no longer be cancelled"),
	TXN_NOT_FOUND("1008004", "Transaction not found"),
	SYSTEM_ERROR("1009001", "Unexpected error, please contact our support team");

	private String code;
	private String message;

	ErrorCodes(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
