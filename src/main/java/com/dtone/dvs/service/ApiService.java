package com.dtone.dvs.service;

import com.dtone.dvs.dto.ApiRequest;
import com.dtone.dvs.dto.ApiResponse;
import com.dtone.dvs.dto.Page;
import com.dtone.dvs.exception.DvsApiException;
import com.dtone.dvs.util.ApiResponseBuilder;
import com.fasterxml.jackson.core.type.TypeReference;

public class ApiService {

	private RestApiInvokeService restApiInvokeService = null;
	private ApiResponseBuilder apiResponseBuilder = null;

	private String apiKey;
	private String apiSecret;
	private String url;

	public ApiService(String url, String apiKey, String apiSecret) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.url = url;
		this.restApiInvokeService = new RestApiInvokeService(apiKey, apiSecret);
		this.apiResponseBuilder = new ApiResponseBuilder();
	}

	public ApiService(RestApiInvokeService restApiInvokeService, ApiResponseBuilder apiResponseBuilder, String url,
			String apiKey, String apiSecret) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.url = url;
		this.restApiInvokeService = restApiInvokeService;
		this.apiResponseBuilder = apiResponseBuilder;
	}

	public <T> ApiResponse<T> httpGet(String url, ApiResponse<T> apiResponse, TypeReference<T> typeReference)
			throws DvsApiException {
		try {
			return apiResponseBuilder.prepareResponse(apiResponse, typeReference, restApiInvokeService.executeGet(url));
		} catch (Exception e) {
			throw new DvsApiException(e);
		}
	}

	public <T> Page<ApiResponse<T>> httpGetPageable(String apiOperation, String url, ApiResponse<T> apiResponse,
			TypeReference<T> typeReference) throws DvsApiException {
		try {
			ApiResponse<T> apiResponseResult = apiResponseBuilder.prepareResponse(apiResponse, typeReference,
					restApiInvokeService.executeGet(url));

			Page<ApiResponse<T>> page = new Page<>(apiOperation, getUrl(), getApiKey(), getApiSecret(),
					apiResponseResult);

			page.setTotalPages(apiResponseResult.getTotalPages());
			page.setTotalRecords(apiResponseResult.getTotalRecords());
			page.setCurrentPage(apiResponseResult.getCurrentPage());
			page.setNextPage(apiResponseResult.getNextPage());
			page.setPreviousPage(apiResponseResult.getPreviousPage());
			page.setRecordsPerPage(apiResponseResult.getRecordsPerPage());

			return page;

		} catch (Exception e) {
			throw new DvsApiException(e);
		}
	}

	public <T> ApiResponse<T> httpPost(String uri, ApiResponse<T> apiResponse, TypeReference<T> typeReference,
			ApiRequest apiRequest) throws DvsApiException {
		try {
			return apiResponseBuilder.prepareResponse(apiResponse, typeReference,
					restApiInvokeService.executePost(uri, apiRequest));
		} catch (Exception e) {
			throw new DvsApiException(e);
		}
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getApiSecret() {
		return apiSecret;
	}

	public String getUrl() {
		return url;
	}

}
