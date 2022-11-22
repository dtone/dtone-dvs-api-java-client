package com.dtone.dvs.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;

import com.dtone.dvs.dto.ApiRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestApiInvokeService {

	private String apiKey;
	private String apiSecret;

	private HttpClient httpClient;

	public RestApiInvokeService(String apiKey, String apiSecret) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;

		CredentialsProvider provider = new BasicCredentialsProvider();
		provider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(this.getApiKey(), this.getApiSecret()));
		final HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		httpClientBuilder.setDefaultCredentialsProvider(provider);
		httpClient = httpClientBuilder.build();
	}

	public RestApiInvokeService(String apiKey, String apiSecret, HttpClient httpClient) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.httpClient = httpClient;
	}

	public HttpResponse executeGet(String url) throws IOException {
		return httpClient.execute(getHttpGet(url));
	}

	public HttpResponse executePost(String url, ApiRequest apiRequest) throws IOException {
		return httpClient.execute(getHttpPost(url, apiRequest));
	}

	private static HttpPost getHttpPost(String url, ApiRequest apiRequest)
			throws UnsupportedEncodingException, JsonProcessingException {
		HttpPost httpPost = new HttpPost(url);
		if (null != apiRequest) {
			httpPost.setEntity(new StringEntity(new ObjectMapper().writeValueAsString(apiRequest)));
		}

		httpPost.addHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
		httpPost.addHeader(HttpHeaders.USER_AGENT, "DVS-APICLIENT-SDK/2.0.0 JAVA");

		return httpPost;
	}

	private static HttpGet getHttpGet(String url) {
		return new HttpGet(url);
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getApiSecret() {
		return apiSecret;
	}

	public HttpClient getHttpClient() {
		return httpClient;
	}

}
