package com.dtone.dvs.util;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import com.dtone.dvs.dto.ApiResponse;
import com.dtone.dvs.dto.ErrorResponse;
import com.dtone.dvs.exception.DvsApiException;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiResponseBuilder {

	/**
	 * Prepare API response
	 * 
	 * @param <T>         the result type
	 * @param apiResponse the api response object
	 * @param typeReference   the response type
	 * @param response    the http response
	 * @return the final api response
	 * @throws IOException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws DvsApiException
	 */
	public <T> ApiResponse<T> prepareResponse(ApiResponse<T> apiResponse, TypeReference<T> typeReference,
			HttpResponse response) throws IOException {
		int statusCode = response.getStatusLine().getStatusCode();
		setPageDetails(apiResponse, response.getAllHeaders());

		apiResponse.setCode(statusCode);
		apiResponse.setSuccess(true);
		HttpEntity httpEntity = response.getEntity();

		if (statusCode < 400) {
			apiResponse.setResult(extractResult(httpEntity, typeReference));
		} else {
			apiResponse.setSuccess(false);

			if (httpEntity != null && response.getEntity().getContent().available() != 0) {
				apiResponse.setErrors(extractResult(httpEntity, new TypeReference<ErrorResponse>() {
				}).getErrors());
			} else {
				apiResponse.getErrors().add(new com.dtone.dvs.dto.Error(String.valueOf(statusCode),
						response.getStatusLine().getReasonPhrase()));
			}

		}
		return apiResponse;
	}

	private static <T> void setPageDetails(ApiResponse<T> apiResponse, Header[] headers) {
		for (Header header : headers) {
			switch (header.getName()) {
			case Constants.CURRENT_PAGE_HEADER:
				apiResponse.setCurrentPage(Integer.parseInt(header.getValue()));
				break;
			case Constants.RECORDS_PER_PAGE_HEADER:
				apiResponse.setRecordsPerPage(Integer.parseInt(header.getValue()));
				break;
			case Constants.TOTAL_RECORDS_HEADER:
				apiResponse.setTotalRecords(Integer.parseInt(header.getValue()));
				break;
			case Constants.TOTAL_PAGES_HEADER:
				apiResponse.setTotalPages(Integer.parseInt(header.getValue()));
				break;
			case Constants.NEXT_PAGE_HEADER:
				apiResponse.setNextPage(Integer.parseInt(header.getValue()));
				break;
			case Constants.PREVIOUS_PAGE_HEADER:
				apiResponse.setPreviousPage(Integer.parseInt(header.getValue()));
				break;
			default:
			}
		}
	}

	/**
	 * Method to extract the response object from HTTP response
	 * 
	 * @param <T>          the result type
	 * @param httpEntity   the HTTP entity
	 * @param valueTypeRef the result type reference
	 * @return the result
	 * @throws IOException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 */
	public static <T> T extractResult(HttpEntity httpEntity, TypeReference<T> valueTypeRef) throws IOException {
		return getObjectMapper().readValue(httpEntity.getContent(), valueTypeRef);
	}

	/**
	 * Method to get new ObjcetMapper object
	 * 
	 * @return objectMapper
	 */
	public static ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		return objectMapper;
	}

}
