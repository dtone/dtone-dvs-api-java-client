package com.dtone.dvs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHeader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dtone.dvs.DvsApiClient;
import com.dtone.dvs.dto.ApiResponse;
import com.dtone.dvs.dto.Service;
import com.dtone.dvs.util.ApiResponseBuilder;
import com.dtone.dvs.util.ErrorCodes;
import com.dtone.dvs.util.MockTestUtils;
import com.fasterxml.jackson.core.type.TypeReference;

public class ApiResponseBuilderTest {

	@InjectMocks
	ApiResponseBuilder apiResponseBuilder = new ApiResponseBuilder();

	HttpGet mockHttpGet = mock(HttpGet.class);
	DvsApiClient mockDvsClient = mock(DvsApiClient.class);
	HttpResponse mockHttpResponse = mock(HttpResponse.class);
	StatusLine mockStatusLine = mock(StatusLine.class);
	HttpEntity mockHttpEntity = mock(HttpEntity.class);

	@Mock
	HttpResponse httpResponse = mock(CloseableHttpResponse.class);

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testHttpGetSuccessResponse() throws Exception {
		
		when(httpResponse.getStatusLine()).thenReturn(mockStatusLine);
		when(mockStatusLine.getStatusCode()).thenReturn(200);

		when(httpResponse.getAllHeaders()).thenReturn(MockTestUtils.getMockHttpHeaders());

		when(httpResponse.getEntity()).thenReturn(mockHttpEntity);

		when(mockHttpEntity.getContent()).thenReturn(MockTestUtils.getInputStream());

		ApiResponse<List<Service>> services = apiResponseBuilder.prepareResponse(new ApiResponse<List<Service>>(),
				new TypeReference<List<Service>>() {
				}, httpResponse);

		assertNotNull(services.getResult());
		assertFalse(services.getResult().isEmpty());
		assertEquals("Topup", services.getResult().get(0).getName());
	}

	@Test
	public void testHttpGetFailureResponse() throws Exception {
		when(httpResponse.getStatusLine()).thenReturn(mockStatusLine);
		when(mockStatusLine.getStatusCode()).thenReturn(404);

		Header[] mockHeaders = new Header[] { new BasicHeader("a", "b") };
		when(httpResponse.getAllHeaders()).thenReturn(mockHeaders);

		when(httpResponse.getEntity()).thenReturn(mockHttpEntity);

		InputStream is = new ByteArrayInputStream(
				ApiResponseBuilder.getObjectMapper().writeValueAsString(MockTestUtils.getErrorResponse()).getBytes());

		when(mockHttpEntity.getContent()).thenReturn(is);

		ApiResponse<List<Service>> services = apiResponseBuilder.prepareResponse(new ApiResponse<List<Service>>(),
				new TypeReference<List<Service>>() {
				}, httpResponse);

		assertNull(services.getResult());
		assertFalse(services.getErrors().isEmpty());
		assertEquals(ErrorCodes.SERVICE_NOT_FOUND.getCode(), services.getErrors().get(0).getCode());
	}
	
	@Test
	public void testHttpGetFailureResponse429() throws Exception {
		when(httpResponse.getStatusLine()).thenReturn(mockStatusLine);
		when(mockStatusLine.getStatusCode()).thenReturn(429);
		when(mockStatusLine.getReasonPhrase()).thenReturn("Too many requests");

		Header[] mockHeaders = new Header[] { new BasicHeader("a", "b") };
		when(httpResponse.getAllHeaders()).thenReturn(mockHeaders);

		when(httpResponse.getEntity()).thenReturn(mockHttpEntity);

		when(mockHttpEntity.getContent()).thenReturn(new ByteArrayInputStream("".getBytes()));

		ApiResponse<List<Service>> services = apiResponseBuilder.prepareResponse(new ApiResponse<List<Service>>(),
				new TypeReference<List<Service>>() {
				}, httpResponse);

		assertNull(services.getResult());
		assertEquals("429", services.getErrors().get(0).getCode());
	}
	
	

}
