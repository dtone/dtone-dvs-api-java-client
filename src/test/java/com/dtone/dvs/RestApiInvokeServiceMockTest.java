package com.dtone.dvs;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.dtone.dvs.dto.TransactionRequest;
import com.dtone.dvs.service.RestApiInvokeService;

public class RestApiInvokeServiceMockTest {

	@Mock
	HttpClient mockHttpClient = mock(HttpClient.class);

	@InjectMocks
	RestApiInvokeService mockRestApiInvokeService = new RestApiInvokeService("", "", mockHttpClient);

	@Mock
	HttpResponse mockHttpResponse = mock(HttpResponse.class);

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testObjectInitialization() throws Exception {
		RestApiInvokeService restApiInvokeService = new RestApiInvokeService("", "");
		assertNotNull(restApiInvokeService.getHttpClient());
	}

	@Test
	public void testExecuteGet() throws Exception {
		when(mockHttpClient.execute(Mockito.any())).thenReturn(mockHttpResponse);
		assertNotNull(mockRestApiInvokeService.executeGet(""));
	}

	@Test(expected = Exception.class)
	public void testExecuteGetException() throws Exception {
		when(mockRestApiInvokeService.getHttpClient().execute(Mockito.any())).thenThrow(new ClientProtocolException());
		mockRestApiInvokeService.executeGet("");
	}

	@Test
	public void testExecutePost() throws Exception {
		when(mockHttpClient.execute(Mockito.any())).thenReturn(mockHttpResponse);
		assertNotNull(mockRestApiInvokeService.executePost("", new TransactionRequest()));
	}

	@Test(expected = Exception.class)
	public void testExecutePostException() throws Exception {
		when(mockRestApiInvokeService.getHttpClient().execute(Mockito.any())).thenThrow(new ClientProtocolException());
		mockRestApiInvokeService.executePost("", new TransactionRequest());
	}

}
