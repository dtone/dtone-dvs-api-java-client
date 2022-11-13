package com.dtone.dvs;

import java.util.List;

import com.dtone.dvs.dto.ApiResponse;
import com.dtone.dvs.dto.Balance;
import com.dtone.dvs.dto.BalanceFilter;
import com.dtone.dvs.dto.BenefitType;
import com.dtone.dvs.dto.Campaign;
import com.dtone.dvs.dto.CampaignFilter;
import com.dtone.dvs.dto.Country;
import com.dtone.dvs.dto.LookupOperatorRequest;
import com.dtone.dvs.dto.Operator;
import com.dtone.dvs.dto.Page;
import com.dtone.dvs.dto.Product;
import com.dtone.dvs.dto.ProductFilter;
import com.dtone.dvs.dto.Promotion;
import com.dtone.dvs.dto.PromotionFilter;
import com.dtone.dvs.dto.Service;
import com.dtone.dvs.dto.StatementDetail;
import com.dtone.dvs.dto.StatementFilter;
import com.dtone.dvs.dto.Transaction;
import com.dtone.dvs.dto.TransactionFilter;
import com.dtone.dvs.dto.TransactionRequest;
import com.dtone.dvs.exception.DvsApiException;
import com.dtone.dvs.helper.DvsApiClientHelper;

public class DvsApiClient {

	private DvsApiClientHelper dvsApiClientHelper;

	public DvsApiClient(String baseUrl, String apiKey, String apiSecret) {
		this.dvsApiClientHelper = new DvsApiClientHelper(baseUrl, apiKey, apiSecret);
	}

	public DvsApiClient(DvsApiClientHelper dvsClientHelper) {
		this.dvsApiClientHelper = dvsClientHelper;
	}

	// Services - Begin

	/**
	 * Get services
	 * 
	 * @return paginated list of services
	 */
	public Page<ApiResponse<List<Service>>> getServices() throws DvsApiException {
		return this.dvsApiClientHelper.getAllServices();
	}

	/**
	 * Get services by page number and records per page
	 * 
	 * @param pageNumber     the page number the page number
	 * @param recordsPerPage the number of records per page the number of records
	 *                       per page
	 * @return list of services
	 */
	public ApiResponse<List<Service>> getServices(int pageNumber, int recordsPerPage) throws DvsApiException {
		return this.dvsApiClientHelper.getServices(pageNumber, recordsPerPage);
	}

	/**
	 * Get services by id
	 * 
	 * @param serviceId the service id
	 * @return service
	 */
	public ApiResponse<Service> getService(Long serviceId) throws DvsApiException {
		return this.dvsApiClientHelper.getService(String.valueOf(serviceId));
	}

	// Services - End

	// Countries - Begin

	/**
	 * Get countries
	 * 
	 * @return paginated list of countries
	 */
	public Page<ApiResponse<List<Country>>> getCountries() throws DvsApiException {
		return this.dvsApiClientHelper.getAllCountries();
	}

	/**
	 * Get countries by page number and records per page
	 * 
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return
	 */
	public ApiResponse<List<Country>> getCountries(int pageNumber, int recordsPerPage) throws DvsApiException {
		return this.dvsApiClientHelper.getCountries(pageNumber, recordsPerPage);
	}

	/**
	 * Get country by country ISO code
	 * 
	 * @param countryIsoCode the country ISO code
	 * @return country
	 */
	public ApiResponse<Country> getCountry(String countryIsoCode) throws DvsApiException {
		return this.dvsApiClientHelper.getCountry(countryIsoCode);
	}

	// Countries - End

	// Operators - Begin

	/**
	 * Get operators
	 * 
	 * @return paginated list of operators
	 */
	public Page<ApiResponse<List<Operator>>> getOperators() throws DvsApiException {
		return this.dvsApiClientHelper.getAllOperators();
	}

	/**
	 * Get operators by page number and records per page
	 * 
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return list of operators
	 */
	public ApiResponse<List<Operator>> getOperators(int pageNumber, int recordsPerPage) throws DvsApiException {
		return this.dvsApiClientHelper.getOperators(pageNumber, recordsPerPage);
	}

	/**
	 * Get operators by country ISO code
	 * 
	 * @param countryIsoCode
	 * @return list of operators
	 */
	public ApiResponse<List<Operator>> getOperators(String countryIsoCode) throws DvsApiException {
		return this.dvsApiClientHelper.getOperators(countryIsoCode, 0, 0);
	}

	/**
	 * Get operators by country ISO code, page number and records per page
	 * 
	 * @param countryIsoCode the country ISO code
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return list of operators
	 */
	public ApiResponse<List<Operator>> getOperators(String countryIsoCode, int pageNumber, int recordsPerPage)
			throws DvsApiException {
		return this.dvsApiClientHelper.getOperators(countryIsoCode, pageNumber, recordsPerPage);
	}

	/**
	 * Get operator by id
	 * 
	 * @param operatorId the operator id
	 * @return operator
	 */
	public ApiResponse<Operator> getOperator(Long operatorId) throws DvsApiException {
		return this.dvsApiClientHelper.getOperator(operatorId);
	}

	/**
	 * Get list of operators by mobile number
	 * 
	 * @param mobileNumber the mobile number
	 * @return list of operators
	 */
	public ApiResponse<List<Operator>> lookupOperators(String mobileNumber) throws DvsApiException {
		return this.dvsApiClientHelper.lookupOperators(mobileNumber, 0, 0);
	}

	/**
	 * Get list of operators by mobile number, page number and records per page
	 * 
	 * @param mobileNumber
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return list of operators
	 */
	public ApiResponse<List<Operator>> lookupOperators(String mobileNumber, int pageNumber, int recordsPerPage)
			throws DvsApiException {
		return this.dvsApiClientHelper.lookupOperators(mobileNumber, pageNumber, recordsPerPage);
	}

	/**
	 * Get list of operators by mobile number
	 * 
	 * @param mobileNumber the mobile number
	 * @return list of operators
	 */
	public ApiResponse<List<Operator>> lookupOperators(LookupOperatorRequest lookupOperatorRequest)
			throws DvsApiException {
		return this.dvsApiClientHelper.lookupOperators(lookupOperatorRequest, 0, 0);
	}

	/**
	 * Get list of operators by mobile number, page number and records per page
	 * 
	 * @param mobileNumber
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return list of operators
	 */
	public ApiResponse<List<Operator>> lookupOperators(LookupOperatorRequest lookupOperatorRequest, int pageNumber,
			int recordsPerPage) throws DvsApiException {
		return this.dvsApiClientHelper.lookupOperators(lookupOperatorRequest, pageNumber, recordsPerPage);
	}

	// Operators - End

	// Benefit Types - Begin

	/**
	 * Get benefit types
	 * 
	 * @return paginated list of benefit types
	 */
	public Page<ApiResponse<List<BenefitType>>> getBenefitTypes() throws DvsApiException {
		return this.dvsApiClientHelper.getAllBenefitTypes();
	}

	/**
	 * Get benefit types by page number and records per page
	 * 
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return list of benefit types
	 */
	public ApiResponse<List<BenefitType>> getBenefitTypes(int pageNumber, int recordsPerPage) throws DvsApiException {
		return this.dvsApiClientHelper.getBenefitTypes(pageNumber, recordsPerPage);
	}

	// Benefit Types - End

	// Promotions - Begin

	/**
	 * Get promotions
	 * 
	 * @return paginated list of promotions
	 */
	public Page<ApiResponse<List<Promotion>>> getPromotions() throws DvsApiException {
		return this.dvsApiClientHelper.getAllPromotions();
	}

	/**
	 * Get promotions by page number and records per page
	 * 
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return list of promotions
	 */
	public ApiResponse<List<Promotion>> getPromotions(int pageNumber, int recordsPerPage) throws DvsApiException {
		return this.dvsApiClientHelper.getPromotions(pageNumber, recordsPerPage);
	}

	/**
	 * Get promotions by filters
	 * 
	 * @param promotionFilter the promotionFilter instance
	 * @return list of promotions
	 */
	public ApiResponse<List<Promotion>> getPromotions(PromotionFilter promotionFilter) throws DvsApiException {
		return this.dvsApiClientHelper.getPromotions(promotionFilter, 0, 0);
	}

	/**
	 * Get promotions by filters, page number and records per page
	 * 
	 * @param promotionFilter the promotionFilter instance
	 * @param pageNumber      he page number
	 * @param recordsPerPage  the number of records per page
	 * @return list of promotions
	 */
	public ApiResponse<List<Promotion>> getPromotions(PromotionFilter promotionFilter, int pageNumber,
			int recordsPerPage) throws DvsApiException {
		return this.dvsApiClientHelper.getPromotions(promotionFilter, pageNumber, recordsPerPage);
	}

	/**
	 * Get promotion by id
	 * 
	 * @param promotionId the promotion id
	 * @return promotion
	 */
	public ApiResponse<Promotion> getPromotion(Long promotionId) throws DvsApiException {
		return this.dvsApiClientHelper.getPromotion(promotionId);
	}

	// Promotions - End

	/**
	 * Get products
	 * 
	 * @return paginated list of products
	 */
	public Page<ApiResponse<List<Product>>> getProducts() throws DvsApiException {
		return this.dvsApiClientHelper.getAllProducts();
	}

	/**
	 * Get products by page number and records per page
	 * 
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return list of products
	 */
	public ApiResponse<List<Product>> getProducts(int pageNumber, int recordsPerPage) throws DvsApiException {
		return this.dvsApiClientHelper.getProducts(new ProductFilter(), pageNumber, recordsPerPage);
	}

	/**
	 * Get products by filters
	 * 
	 * @param productFilter  the product filter object
	 * @param recordsPerPage the number of records per page
	 * @return list of products
	 */
	public ApiResponse<List<Product>> getProducts(ProductFilter productFilter) throws DvsApiException {
		return this.dvsApiClientHelper.getProducts(productFilter, 0, 0);
	}

	/**
	 * Get products by filters, page number and records per page
	 * 
	 * @param productFilter  the product filter object
	 * @param recordsPerPage the number of records per page
	 * @return list of products
	 */
	public ApiResponse<List<Product>> getProducts(ProductFilter productFilter, int pageNumber, int recordsPerPage)
			throws DvsApiException {
		return this.dvsApiClientHelper.getProducts(productFilter, pageNumber, recordsPerPage);
	}

	/**
	 * Get product by id
	 * 
	 * @param productId the product id
	 * @return product
	 */
	public ApiResponse<Product> getProduct(Long productId) throws DvsApiException {
		return this.dvsApiClientHelper.getProduct(productId);
	}

	// Products - End

	// Transactions - Begin

	/**
	 * Create a new transaction asynchronously
	 * 
	 * @param transactionRequest the transaction request
	 * @return transaction
	 */
	public ApiResponse<Transaction> createTransaction(TransactionRequest transactionRequest) throws DvsApiException {
		return this.dvsApiClientHelper.postTransaction(transactionRequest);
	}

	/**
	 * Confirm a transaction asynchronously
	 * 
	 * @param transactionId the transaction id
	 * @return transaction
	 */
	public ApiResponse<Transaction> confirmTransaction(Long transactionId) throws DvsApiException {
		return this.dvsApiClientHelper.confirmTransaction(transactionId);
	}

	/**
	 * Cancel a transaction
	 * 
	 * @param transactionId the transaction id
	 * @return transaction
	 */
	public ApiResponse<Transaction> cancelTransaction(Long transactionId) throws DvsApiException {
		return this.dvsApiClientHelper.cancelTransaction(transactionId);
	}

	/**
	 * Get transactions
	 * 
	 * @return paginated list of transactions
	 */
	public Page<ApiResponse<List<Transaction>>> getTransactions() throws DvsApiException {
		return this.dvsApiClientHelper.getAllTransactions();
	}

	/**
	 * Get transactions by external id
	 * 
	 * transactionFilter the TransactionFilter instance
	 * 
	 * @return list of transactions
	 */
	public ApiResponse<List<Transaction>> getTransactions(TransactionFilter transactionFilter) throws DvsApiException {
		return this.dvsApiClientHelper.getTransactions(transactionFilter, 0, 0);
	}

	/**
	 * Get transactions by external id, page number and records per page
	 * 
	 * transactionFilter the TransactionFilter instance
	 * 
	 * @param pageNUmber
	 * @param recordsPerPage the number of records per page
	 * @return list of transactions
	 */
	public ApiResponse<List<Transaction>> getTransactions(TransactionFilter transactionFilter, int pageNumber,
			int recordsPerPage) throws DvsApiException {
		return this.dvsApiClientHelper.getTransactions(transactionFilter, pageNumber, recordsPerPage);
	}

	/**
	 * Get transaction by id
	 * 
	 * @param transactionId the transaction id
	 * @return transaction
	 */
	public ApiResponse<Transaction> getTransaction(Long transactionId) throws DvsApiException {
		return this.dvsApiClientHelper.getTransaction(transactionId);
	}

	// Transactions - End

	// Balances - Begin

	/**
	 * Get balances
	 * 
	 * @return list of balances
	 */
	public Page<ApiResponse<List<Balance>>> getBalances() throws DvsApiException {
		return this.dvsApiClientHelper.getAllBalances();
	}

	/**
	 * Get balances by page number and records per page
	 * 
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return list of balances
	 */
	public ApiResponse<List<Balance>> getBalances(int pageNumber, int recordsPerPage) throws DvsApiException {
		return this.dvsApiClientHelper.getBalances(pageNumber, recordsPerPage);
	}

	/**
	 * Get balances by unit and unit type
	 * 
	 * @return list of balances
	 */
	public ApiResponse<List<Balance>> getBalances(BalanceFilter balanceFilter) throws DvsApiException {
		return this.dvsApiClientHelper.getBalances(balanceFilter);
	}

	// Balances - End

	// Statement Inquiry - Begin

	/**
	 * Get statement
	 * 
	 * @return paginated list of statement
	 */
	private Page<ApiResponse<List<StatementDetail>>> getStatements() throws DvsApiException {
		return this.dvsApiClientHelper.getAllStatements();
	}

	/**
	 * Get statements by page number and records per page
	 * 
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return list of statements
	 */
	private ApiResponse<List<StatementDetail>> getStatements(int pageNumber, int recordsPerPage)
			throws DvsApiException {
		return this.dvsApiClientHelper.getStatements(new StatementFilter(), pageNumber, recordsPerPage);
	}

	/**
	 * Get statements by filters
	 * 
	 * @return statements details
	 */
	private ApiResponse<List<StatementDetail>> getStatements(StatementFilter statementFilter) throws DvsApiException {
		return this.dvsApiClientHelper.getStatements(statementFilter);
	}

	/**
	 * Get statements by filters, page number and records per page
	 * 
	 * @param statementFilter the statement filter object
	 * @param recordsPerPage  the number of records per page
	 * @return list of statements
	 */
	private ApiResponse<List<StatementDetail>> getStatements(StatementFilter statementFilter, int pageNumber,
			int recordsPerPage) throws DvsApiException {
		return this.dvsApiClientHelper.getStatements(statementFilter, pageNumber, recordsPerPage);
	}

	// Statement Inquiry - End

	// Campaigns - Begin

	/**
	 * Get campaigns
	 * 
	 * @return paginated list of campaigns
	 */
	private Page<ApiResponse<List<Campaign>>> getCampaigns() throws DvsApiException {
		return this.dvsApiClientHelper.getAllCampaigns();
	}

	/**
	 * Get campaigns by page number and records per page
	 * 
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return list of campaigns
	 */
	private ApiResponse<List<Campaign>> getCampaigns(int pageNumber, int recordsPerPage) throws DvsApiException {
		return this.dvsApiClientHelper.getCampaigns(new CampaignFilter(), pageNumber, recordsPerPage);
	}

	/**
	 * Get campaigns by filters
	 * 
	 * @param campaignFilter the campaign filter object
	 * @param recordsPerPage the number of records per page
	 * @return list of campaigns
	 */
	private ApiResponse<List<Campaign>> getCampaigns(CampaignFilter campaignFilter) throws DvsApiException {
		return this.dvsApiClientHelper.getCampaigns(campaignFilter, 0, 0);
	}

	/**
	 * Get campaigns by filters, page number and records per page
	 * 
	 * @param campaignFilter the campaign filter object
	 * @param recordsPerPage the number of records per page
	 * @return list of campaigns
	 */
	private ApiResponse<List<Campaign>> getCampaigns(CampaignFilter campaignFilter, int pageNumber, int recordsPerPage)
			throws DvsApiException {
		return this.dvsApiClientHelper.getCampaigns(campaignFilter, pageNumber, recordsPerPage);
	}

	/**
	 * Get campaign by id
	 * 
	 * @param campaignId the campaign id
	 * @return campaign
	 */
	private ApiResponse<Campaign> getCampaign(Long campaignId) throws DvsApiException {
		return this.dvsApiClientHelper.getCampaign(campaignId);
	}

	// Campaigns - End

}
