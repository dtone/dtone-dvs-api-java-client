package com.dtone.dvs;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.dtone.dvs.dto.ApiResponse;
import com.dtone.dvs.dto.Page;
import com.dtone.dvs.dto.Service;
import com.dtone.dvs.dto.TransactionRequest;
import com.dtone.dvs.dto.Transaction;
import com.dtone.dvs.exception.DvsApiException;
import com.dtone.dvs.service.ApiService;
import com.dtone.dvs.service.RestApiInvokeService;
import com.dtone.dvs.util.ApiResponseBuilder;
import com.dtone.dvs.util.MockTestUtils;
import com.fasterxml.jackson.core.type.TypeReference;

@SuppressWarnings("unchecked")
public class ApiServiceMockTest {

	@Mock
	RestApiInvokeService mockRestApiInvokeService = mock(RestApiInvokeService.class);

	@Mock
	ApiResponseBuilder mockApiResponseBuilder = mock(ApiResponseBuilder.class);

	@InjectMocks
	ApiService apiService = new ApiService(mockRestApiInvokeService, mockApiResponseBuilder, "", "", "");

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testHttpGet() throws Exception {
		when(mockApiResponseBuilder.prepareResponse(Mockito.any(ApiResponse.class), Mockito.any(), Mockito.any()))
				.thenReturn(MockTestUtils.getServices());

		ApiResponse<List<Service>> services = apiService.httpGet("", new ApiResponse<List<Service>>(),
				new TypeReference<List<Service>>() {
				});

		assertNotNull(services.getResult());
	}

	@Test(expected = DvsApiException.class)
	public void testHttpGetException() throws Exception {
		when(mockRestApiInvokeService.executeGet(Mockito.anyString())).thenThrow(new IOException());

		apiService.httpGet("", new ApiResponse<List<Service>>(), new TypeReference<List<Service>>() {
		});
	}

	@Test
	public void testHttpGetPageable() throws Exception {
		when(mockApiResponseBuilder.prepareResponse(Mockito.any(ApiResponse.class), Mockito.any(), Mockito.any()))
				.thenReturn(MockTestUtils.getServices());

		Page<ApiResponse<List<Service>>> services = apiService.httpGetPageable("", "", new ApiResponse<List<Service>>(),
				new TypeReference<List<Service>>() {
				});

		assertNotNull(services.first().getResult());
	}

	@Test(expected = DvsApiException.class)
	public void testHttpGetPageableException() throws Exception {
		when(mockRestApiInvokeService.executeGet(Mockito.anyString())).thenThrow(new IOException());

		apiService.httpGetPageable("", "", new ApiResponse<List<Service>>(),
				new TypeReference<List<Service>>() {
				});
	}
	
	@Test
	public void testHttpPost() throws Exception {
		when(mockApiResponseBuilder.prepareResponse(Mockito.any(ApiResponse.class), Mockito.any(), Mockito.any()))
				.thenReturn(MockTestUtils.getServices());

		ApiResponse<Transaction> services = apiService.httpPost("", new ApiResponse<Transaction>(),
				new TypeReference<Transaction>() {
				}, new TransactionRequest());

		assertNotNull(services.getResult());
	}

	@Test(expected = DvsApiException.class)
	public void testHttpPostException() throws Exception {
		when(mockRestApiInvokeService.executePost(Mockito.anyString(), Mockito.any())).thenThrow(new IOException());

		apiService.httpPost("", new ApiResponse<Transaction>(),
				new TypeReference<Transaction>() {
				}, new TransactionRequest());
	}

}
