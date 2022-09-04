package com.dtone.dvs.util;

public class Constants {

	public static final String DVS_SDK_VERSION = "DVS-ASYNC-CLIENT-SDK/2.0.0 JAVA";

	private Constants() { }
	
	//Pagination Response Headers
	public static final String TOTAL_PAGES_HEADER = "X-Total-Pages";
	public static final String TOTAL_RECORDS_HEADER = "X-Total";
	public static final String RECORDS_PER_PAGE_HEADER = "X-Per-Page";
	public static final String CURRENT_PAGE_HEADER = "X-Page";
	public static final String NEXT_PAGE_HEADER = "X-Next-Page";
	public static final String PREVIOUS_PAGE_HEADER = "X-Prev-Page";

	//Common
	public static final String QUESTION_MARK = "?";
	public static final String AMPERSAND = "&";
	public static final String SLASH = "/";
	public static final String EQUAL = "=";
	public static final String SINGLE_SPACE = " ";
	public static final String EMPTY_STRING = "";
	public static final String LEFT_BRACKET = "[";
	public static final String RIGHT_BRACKET = "]";

	//URL
	public static final String CONTEXT_ROOT = "/v1/";

	public static final String SERVICES = CONTEXT_ROOT + "services";
	public static final String COUNTRIES = CONTEXT_ROOT + "countries";
	public static final String OPERATORS = CONTEXT_ROOT + "operators";
	public static final String BENEFIT_TYPES = CONTEXT_ROOT + "benefit-types";
	public static final String PROMOTIONS = CONTEXT_ROOT + "promotions";
	public static final String PRODUCTS = CONTEXT_ROOT + "products";
	public static final String TRANSACTION_SYNC = CONTEXT_ROOT + "sync/transactions";
	public static final String TRANSACTION_ASYNC = CONTEXT_ROOT + "async/transactions";
	public static final String TRANSACTIONS = CONTEXT_ROOT + "transactions";
	public static final String CONFIRM_TRANSACTION_SYNC = CONTEXT_ROOT + "sync/transactions/{}/confirm";
	public static final String CONFIRM_TRANSACTION_ASYNC = CONTEXT_ROOT + "async/transactions/{}/confirm";
	public static final String CANCEL_TRANSACTION = CONTEXT_ROOT + "transactions/{}/cancel";
	public static final String BALANCES = CONTEXT_ROOT + "balances";
	public static final String OPERATOR_LOOKUP = CONTEXT_ROOT + "lookup/mobile-number";
	public static final String STATEMENT_INQUIRY = CONTEXT_ROOT + "lookup/statement-inquiry/{}";

	//Path Param
	public static final String PATH_PARAM_PLACEHOLDER = "{}";
	
	//Query Param Pagination
	public static final String PER_PAGE = "per_page";
	public static final String PAGE = "page";
	
	//Query Param
	public static final String OPERATOR_ID = "operator_id";
	public static final String PRODUCT_ID = "product_id";
	public static final String COUNTRY_ISO_CODE = "country_iso_code";
	public static final String BENEFIT_TYPES_QP = "benefit_types";
	public static final String REGION = "region";
	public static final String TYPE = "type";
	public static final String SERVICE_ID = "service_id";
	public static final String UNIT_TYPE = "unit_type";
	public static final String UNIT = "unit";
	public static final String EXTERNAL_ID = "external_id";
	public static final String ACCOUNT_QUALIFIER = "account_qualifier";
}
