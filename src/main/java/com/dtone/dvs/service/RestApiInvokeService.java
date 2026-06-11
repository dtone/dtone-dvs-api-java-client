package com.dtone.dvs.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.dtone.dvs.dto.ApiRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.CredentialsProvider;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.StringEntity;

public class RestApiInvokeService {

	private String apiKey;
	private String apiSecret;

	private HttpClient httpClient;

	public RestApiInvokeService(String apiKey, String apiSecret) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		BasicCredentialsProvider provider = new BasicCredentialsProvider();
		provider.setCredentials(new AuthScope(null, null, -1,null, null), new UsernamePasswordCredentials(this.getApiKey(), this.getApiSecret().toCharArray()));
		final HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		httpClientBuilder.setDefaultCredentialsProvider(provider);
		httpClient = httpClientBuilder.build();
	}

	public RestApiInvokeService(String apiKey, String apiSecret, HttpClient httpClient) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.httpClient = httpClient;
	}

	public ClassicHttpResponse executeGet(String url) throws IOException {
		return (ClassicHttpResponse) httpClient.execute(getHttpGet(url));
	}

	public ClassicHttpResponse executePost(String url, ApiRequest apiRequest) throws IOException {
		return (ClassicHttpResponse) httpClient.execute(getHttpPost(url, apiRequest));
	}

	private static HttpPost getHttpPost(String url, ApiRequest apiRequest)
			throws UnsupportedEncodingException, JsonProcessingException {
		HttpPost httpPost = new HttpPost(url);
		if (null != apiRequest) {
			httpPost.setEntity(new StringEntity(new ObjectMapper().writeValueAsString(apiRequest)));
		}

		httpPost.addHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
		httpPost.addHeader(HttpHeaders.USER_AGENT, "DVS-APICLIENT-SDK/2.0.2 JAVA");

		return httpPost;
	}

	private static ClassicHttpRequest getHttpGet(String url) {
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
