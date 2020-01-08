package com.dtone.dvs.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import com.dtone.dvs.dto.ApiResponse;
import com.dtone.dvs.dto.Balance;
import com.dtone.dvs.dto.BenefitType;
import com.dtone.dvs.dto.Country;
import com.dtone.dvs.dto.Error;
import com.dtone.dvs.dto.ErrorResponse;
import com.dtone.dvs.dto.Operator;
import com.dtone.dvs.dto.Page;
import com.dtone.dvs.dto.PartyIdentifier;
import com.dtone.dvs.dto.Product;
import com.dtone.dvs.dto.Promotion;
import com.dtone.dvs.dto.Service;
import com.dtone.dvs.dto.TransactionRequest;
import com.dtone.dvs.dto.TransactionResponse;
import com.dtone.dvs.util.ApiResponseBuilder;
import com.dtone.dvs.util.Constants;
import com.dtone.dvs.util.ErrorCodes;
import com.fasterxml.jackson.core.JsonProcessingException;

public class MockTestUtils {

	public static InputStream getInputStream() throws JsonProcessingException {
		List<Service> serviceList = new ArrayList<Service>();
		Service service = new Service();
		service.setId(1L);
		service.setName("Topup");
		serviceList.add(service);

		InputStream is = new ByteArrayInputStream(
				ApiResponseBuilder.getObjectMapper().writeValueAsString(serviceList).getBytes());
		return is;
	}

	public static ErrorResponse getErrorResponse() throws JsonProcessingException {
		List<Error> errorList = new ArrayList<Error>();
		errorList.add(new Error(ErrorCodes.SERVICE_NOT_FOUND.getCode(), ErrorCodes.SERVICE_NOT_FOUND.getMessage()));

		return new ErrorResponse(errorList);
	}

	public static Header[] getMockHttpHeaders() {
		Header[] mockHeaders = new Header[6];
		mockHeaders[0] = new BasicHeader(Constants.CURRENT_PAGE_HEADER, "1");
		mockHeaders[1] = new BasicHeader(Constants.RECORDS_PER_PAGE_HEADER, "50");
		mockHeaders[2] = new BasicHeader(Constants.TOTAL_RECORDS_HEADER, "100");
		mockHeaders[3] = new BasicHeader(Constants.TOTAL_PAGES_HEADER, "2");
		mockHeaders[4] = new BasicHeader(Constants.NEXT_PAGE_HEADER, "2");
		mockHeaders[5] = new BasicHeader(Constants.PREVIOUS_PAGE_HEADER, "0");
		return mockHeaders;
	}

	public static ApiResponse<List<Service>> getServices() {
		ApiResponse<List<Service>> apiResponse = new ApiResponse<List<Service>>();
		apiResponse.setResult(new ArrayList<Service>());

		return apiResponse;
	}

	public static ApiResponse<Service> getService() {
		ApiResponse<Service> apiResponse = new ApiResponse<Service>();
		apiResponse.setResult(new Service());

		return apiResponse;
	}

	public static Page<ApiResponse<List<Service>>> getPageableServices() {
		ApiResponse<List<Service>> apiResponse = new ApiResponse<List<Service>>();
		apiResponse.setResult(new ArrayList<Service>());

		return new Page<ApiResponse<List<Service>>>("", "", "", "", apiResponse);
	}

	public static ApiResponse<List<Country>> getCountries() {
		ApiResponse<List<Country>> apiResponse = new ApiResponse<List<Country>>();
		apiResponse.setResult(new ArrayList<Country>());

		return apiResponse;
	}

	public static ApiResponse<Country> getCountry() {
		ApiResponse<Country> apiResponse = new ApiResponse<Country>();
		apiResponse.setResult(new Country());

		return apiResponse;
	}

	public static Page<ApiResponse<List<Country>>> getPageableCountries() {
		ApiResponse<List<Country>> apiResponse = new ApiResponse<List<Country>>();
		apiResponse.setResult(new ArrayList<Country>());

		return new Page<ApiResponse<List<Country>>>("", "", "", "", apiResponse);
	}

	public static ApiResponse<List<Operator>> getOperators() {
		ApiResponse<List<Operator>> apiResponse = new ApiResponse<List<Operator>>();
		apiResponse.setResult(new ArrayList<Operator>());

		return apiResponse;
	}

	public static ApiResponse<Operator> getOperator() {
		ApiResponse<Operator> apiResponse = new ApiResponse<Operator>();
		apiResponse.setResult(new Operator());

		return apiResponse;
	}

	public static Page<ApiResponse<List<Operator>>> getPageableOperators() {
		ApiResponse<List<Operator>> apiResponse = new ApiResponse<List<Operator>>();
		apiResponse.setResult(new ArrayList<Operator>());

		return new Page<ApiResponse<List<Operator>>>("", "", "", "", apiResponse);
	}

	public static ApiResponse<List<Balance>> getBalances() {
		ApiResponse<List<Balance>> apiResponse = new ApiResponse<List<Balance>>();
		apiResponse.setResult(new ArrayList<Balance>());

		return apiResponse;
	}

	public static Page<ApiResponse<List<Balance>>> getPageableBalances() {
		ApiResponse<List<Balance>> apiResponse = new ApiResponse<List<Balance>>();
		apiResponse.setResult(new ArrayList<Balance>());

		return new Page<ApiResponse<List<Balance>>>("", "", "", "", apiResponse);
	}

	public static ApiResponse<List<BenefitType>> getBenefitTypes() {
		ApiResponse<List<BenefitType>> apiResponse = new ApiResponse<List<BenefitType>>();
		apiResponse.setResult(new ArrayList<BenefitType>());

		return apiResponse;
	}

	public static Page<ApiResponse<List<BenefitType>>> getPageableBenefitTypes() {
		ApiResponse<List<BenefitType>> apiResponse = new ApiResponse<List<BenefitType>>();
		apiResponse.setResult(new ArrayList<BenefitType>());

		return new Page<ApiResponse<List<BenefitType>>>("", "", "", "", apiResponse);
	}

	public static ApiResponse<List<Promotion>> getPromotions() {
		ApiResponse<List<Promotion>> apiResponse = new ApiResponse<List<Promotion>>();
		apiResponse.setResult(new ArrayList<Promotion>());

		return apiResponse;
	}

	public static Page<ApiResponse<List<Promotion>>> getPageablePromotions() {
		ApiResponse<List<Promotion>> apiResponse = new ApiResponse<List<Promotion>>();
		apiResponse.setResult(new ArrayList<Promotion>());

		return new Page<ApiResponse<List<Promotion>>>("", "", "", "", apiResponse);
	}

	public static ApiResponse<Promotion> getPromotion() {
		ApiResponse<Promotion> apiResponse = new ApiResponse<Promotion>();
		apiResponse.setResult(new Promotion());

		return apiResponse;
	}

	public static ApiResponse<List<Product>> getProducts() {
		ApiResponse<List<Product>> apiResponse = new ApiResponse<List<Product>>();
		apiResponse.setResult(new ArrayList<Product>());

		return apiResponse;
	}

	public static ApiResponse<Product> getProduct() {
		ApiResponse<Product> apiResponse = new ApiResponse<Product>();
		apiResponse.setResult(new Product());

		return apiResponse;
	}

	public static Page<ApiResponse<List<Product>>> getPageableProducts() {
		ApiResponse<List<Product>> apiResponse = new ApiResponse<List<Product>>();
		apiResponse.setResult(new ArrayList<Product>());

		return new Page<ApiResponse<List<Product>>>("", "", "", "", apiResponse);
	}

	public static ApiResponse<List<TransactionResponse>> getTransactions() {
		ApiResponse<List<TransactionResponse>> apiResponse = new ApiResponse<List<TransactionResponse>>();
		apiResponse.setResult(new ArrayList<TransactionResponse>());

		return apiResponse;
	}

	public static ApiResponse<TransactionResponse> getTransaction() {
		ApiResponse<TransactionResponse> apiResponse = new ApiResponse<TransactionResponse>();
		apiResponse.setResult(new TransactionResponse());

		return apiResponse;
	}
	
	public static TransactionRequest getTransactionRequest() {
		TransactionRequest transactionRequest = new TransactionRequest();
		transactionRequest.setProductId(5L);
		transactionRequest.setAutoConfirm(false);

		PartyIdentifier creditPartyIdentifier = new PartyIdentifier();
		creditPartyIdentifier.setMobileNumber("+628123456100");
		creditPartyIdentifier.setAccountNumber("628123456100");
		transactionRequest.setCreditPartyIdentifier(creditPartyIdentifier);
		return transactionRequest;
	}

}
