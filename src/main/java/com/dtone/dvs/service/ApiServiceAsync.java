package com.dtone.dvs.service;

import java.util.concurrent.CompletableFuture;

import com.dtone.dvs.dto.ApiRequest;
import com.dtone.dvs.dto.ApiResponse;
import com.dtone.dvs.dto.PageAsync;
import com.dtone.dvs.util.ApiResponseBuilderAsync;
import com.fasterxml.jackson.core.type.TypeReference;

public class ApiServiceAsync {

	private RestApiInvokeServiceAsync restApiInvokeService = null;
	private ApiResponseBuilderAsync apiResponseBuilder = null;

	private String apiKey;
	private String apiSecret;
	private String url;

	public ApiServiceAsync(String url, String apiKey, String apiSecret) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.url = url;
		this.restApiInvokeService = new RestApiInvokeServiceAsync(apiKey, apiSecret);
		this.apiResponseBuilder = new ApiResponseBuilderAsync();
	}

	public ApiServiceAsync(RestApiInvokeServiceAsync restApiInvokeService, ApiResponseBuilderAsync apiResponseBuilder, String url,
                         String apiKey, String apiSecret) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.url = url;
		this.restApiInvokeService = restApiInvokeService;
		this.apiResponseBuilder = apiResponseBuilder;
	}

	public <T> CompletableFuture<ApiResponse<T>> httpGet(String url, ApiResponse<T> apiResponse, TypeReference<T> typeReference) {
			return apiResponseBuilder.prepareResponse(apiResponse, typeReference,
					restApiInvokeService.executeGet(url));
	}

	public <T> CompletableFuture<PageAsync<CompletableFuture<ApiResponse<T>>>> httpGetPageable(String apiOperation, String url, ApiResponse<T> apiResponse,
																																														 TypeReference<T> typeReference) {
			CompletableFuture<ApiResponse<T>> resultJob = apiResponseBuilder.prepareResponse(apiResponse, typeReference,
					restApiInvokeService.executeGet(url));

			PageAsync<CompletableFuture<ApiResponse<T>>> page = new PageAsync<>(apiOperation, getUrl(), getApiKey(), getApiSecret(),
					resultJob);

			return resultJob.thenCompose(result -> {
				page.setTotalPages(result.getTotalPages());
				page.setTotalRecords(result.getTotalRecords());
				page.setCurrentPage(result.getCurrentPage());
				page.setNextPage(result.getNextPage());
				page.setPreviousPage(result.getPreviousPage());
				page.setRecordsPerPage(result.getRecordsPerPage());
				return CompletableFuture.completedFuture(page);
			});
	}

	public <T> CompletableFuture<ApiResponse<T>> httpPost(String uri, ApiResponse<T> apiResponse,
																											 TypeReference<T> typeReference,
																											 ApiRequest apiRequest) {
			return apiResponseBuilder.prepareResponse(apiResponse, typeReference,
					restApiInvokeService.executePost(uri, apiRequest));
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
