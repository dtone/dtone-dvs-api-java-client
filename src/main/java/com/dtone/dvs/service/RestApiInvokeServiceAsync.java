package com.dtone.dvs.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

import com.dtone.dvs.dto.ApiRequest;
import com.dtone.dvs.util.ApiResponseBuilderAsync;
import com.dtone.dvs.util.Constants;
import com.dtone.dvs.util.HttpConstants;

public class RestApiInvokeServiceAsync {

	private final String apiKey;
	private final String apiSecret;

	private HttpClient httpClient;

	public RestApiInvokeServiceAsync(String apiKey, String apiSecret) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;

		var auth = buildAuth(apiKey, apiSecret);
		httpClient = HttpClient.newBuilder()
				.authenticator(auth)
				.build();
	}

	public RestApiInvokeServiceAsync(String apiKey, String apiSecret, HttpClient httpClient) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.httpClient = httpClient;
	}

	private Authenticator buildAuth(String username, String password) {
		return new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(apiKey, apiSecret.toCharArray());
			}
		};
	}

	public CompletableFuture<HttpResponse<InputStream>> executeGet(String url) throws IOException, URISyntaxException {
		return httpClient.sendAsync(getHttpGet(url),
				HttpResponse.BodyHandlers.ofInputStream());
	}

	public CompletableFuture<HttpResponse<InputStream>> executePost(String url, InputStream stream)
			throws IOException, URISyntaxException {
		return httpClient.sendAsync(getHttpPost(url, stream),
				HttpResponse.BodyHandlers.ofInputStream());
	}

	public CompletableFuture<HttpResponse<InputStream>> executePost(String url, ApiRequest request)
			throws IOException, URISyntaxException {
		if (request != null) {
			return httpClient.sendAsync(getHttpPost(url,
							ApiResponseBuilderAsync.getObjectMapper().
									writerFor(request.getClass())
									.writeValueAsBytes(request)),
					HttpResponse.BodyHandlers.ofInputStream());
		} else {
			return httpClient.sendAsync(getHttpPost(url),
					HttpResponse.BodyHandlers.ofInputStream());
		}
	}

	public CompletableFuture<HttpResponse<InputStream>> executePost(String url,
			String postBody)
			throws IOException, URISyntaxException {
		return httpClient.sendAsync(getHttpPost(url,
						postBody.getBytes(StandardCharsets.UTF_8)),
				HttpResponse.BodyHandlers.ofInputStream());
	}

	public HttpRequest getHttpGet(String url) throws URISyntaxException {
		return buildBaseRequest(url)
				.GET().build();
	}

	public HttpRequest getHttpPost(String url, InputStream stream) throws URISyntaxException {
		return buildBaseRequest(url)
				.POST(HttpRequest.BodyPublishers.ofInputStream(()->
						stream)).build();
	}

	public HttpRequest getHttpPost(String url, byte[] body) throws URISyntaxException {
		return buildBaseRequest(url)
				.POST(HttpRequest.BodyPublishers.ofByteArray(body)).build();
	}

	public HttpRequest getHttpPost(String url) throws URISyntaxException {
		return buildBaseRequest(url)
				.POST(HttpRequest.BodyPublishers.noBody()).build();
	}

	private HttpRequest.Builder buildBaseRequest(String url) throws URISyntaxException {
		return HttpRequest.newBuilder(new URI(url))
				.header(HttpConstants.CONTENT_TYPE, HttpConstants.APPLICATION_JSON)
				.header(HttpConstants.USER_AGENT, Constants.DVS_SDK_VERSION);
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
