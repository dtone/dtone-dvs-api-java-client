package com.dtone.dvs;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.dtone.dvs.dto.ApiResponse;
import com.dtone.dvs.dto.Balance;
import com.dtone.dvs.dto.BenefitType;
import com.dtone.dvs.dto.Country;
import com.dtone.dvs.dto.Operator;
import com.dtone.dvs.dto.Page;
import com.dtone.dvs.dto.Product;
import com.dtone.dvs.dto.ProductFilter;
import com.dtone.dvs.dto.Promotion;
import com.dtone.dvs.dto.PromotionFilter;
import com.dtone.dvs.dto.Service;
import com.dtone.dvs.dto.TransactionFilter;
import com.dtone.dvs.dto.TransactionRequest;
import com.dtone.dvs.dto.Transaction;
import com.dtone.dvs.helper.DvsApiClientHelper;
import com.dtone.dvs.service.ApiService;
import com.dtone.dvs.util.MockTestUtils;

@SuppressWarnings("unchecked")
public class DvsApiClientHelperMockTest {

	@Mock
	ApiService apiService = mock(ApiService.class);

	@InjectMocks
	DvsApiClientHelper dvsApiClientHelper = new DvsApiClientHelper(apiService, "Url");

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testServiceAPIs() throws Exception {
		when(apiService.httpGetPageable(Mockito.any(), Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getPageableServices());
		Page<ApiResponse<List<Service>>> apiResponseAllServices = dvsApiClientHelper.getAllServices();
		assertNotNull(apiResponseAllServices.first());

		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getServices());
		ApiResponse<List<Service>> apiResponseServices = dvsApiClientHelper.getServices(1, 100);
		assertNotNull(apiResponseServices.getResult());

		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getService());
		ApiResponse<Service> apiResponseService = dvsApiClientHelper.getService("1");
		assertNotNull(apiResponseService.getResult());

	}

	@Test
	public void testCountryAPIs() throws Exception {
		when(apiService.httpGetPageable(Mockito.any(), Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getPageableCountries());
		Page<ApiResponse<List<Country>>> apiresponseAllCountries = dvsApiClientHelper.getAllCountries();
		assertNotNull(apiresponseAllCountries.first().getResult());

		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getCountries());
		ApiResponse<List<Country>> apiResponseCountries = dvsApiClientHelper.getCountries(1, 100);
		assertNotNull(apiResponseCountries.getResult());

		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getCountry());
		ApiResponse<Country> apiResponseCountry = dvsApiClientHelper.getCountry("BGD");
		assertNotNull(apiResponseCountry.getResult());
	}

	@Test
	public void testOperatorAPIs() throws Exception {
		when(apiService.httpGetPageable(Mockito.any(), Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getPageableOperators());
		Page<ApiResponse<List<Operator>>> apiResponseAllOperators = dvsApiClientHelper.getAllOperators();
		assertNotNull(apiResponseAllOperators.first().getResult());

		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getOperators());
		ApiResponse<List<Operator>> apiResponseOperators = dvsApiClientHelper.getOperators(1, 100);
		assertNotNull(apiResponseOperators.getResult());

		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getOperator());
		ApiResponse<Operator> apiResponseOperator = dvsApiClientHelper.getOperator(1L);
		assertNotNull(apiResponseOperator.getResult());

		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getOperators());
		ApiResponse<List<Operator>> apiResponseOperatorsByIsoCodeFilter = dvsApiClientHelper.getOperators("BGD", 1,
				100);
		assertNotNull(apiResponseOperatorsByIsoCodeFilter.getResult());

		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getOperators());
		ApiResponse<List<Operator>> apiResponseLookupOperators = dvsApiClientHelper.lookupOperators("8888888888", 1,
				100);
		assertNotNull(apiResponseLookupOperators.getResult());
	}

	@Test
	public void testBalanceAPIs() throws Exception {
		when(apiService.httpGetPageable(Mockito.any(), Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getPageableBalances());
		Page<ApiResponse<List<Balance>>> apiresponseAllBalances = dvsApiClientHelper.getAllBalances();
		assertNotNull(apiresponseAllBalances.first().getResult());

		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getBalances());
		ApiResponse<List<Balance>> apiResponseBalances = dvsApiClientHelper.getBalances(1, 100);
		assertNotNull(apiResponseBalances.getResult());
	}

	@Test
	public void testBenefitTypeAPIs() throws Exception {
		when(apiService.httpGetPageable(Mockito.any(), Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getPageableBenefitTypes());
		Page<ApiResponse<List<BenefitType>>> apiresponseAllBenefitTypes = dvsApiClientHelper.getAllBenefitTypes();
		assertNotNull(apiresponseAllBenefitTypes.first().getResult());

		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getBenefitTypes());
		ApiResponse<List<BenefitType>> apiResponseBenefitTypes = dvsApiClientHelper.getBenefitTypes(1, 100);
		assertNotNull(apiResponseBenefitTypes.getResult());
	}

	@Test
	public void testPromotionAPIs() throws Exception {
		when(apiService.httpGetPageable(Mockito.any(), Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getPageablePromotions());
		Page<ApiResponse<List<Promotion>>> apiresponseAllPromotions = dvsApiClientHelper.getAllPromotions();
		assertNotNull(apiresponseAllPromotions.first().getResult());

		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getPromotions());
		ApiResponse<List<Promotion>> apiResponsePromotions = dvsApiClientHelper.getPromotions(1, 100);
		assertNotNull(apiResponsePromotions.getResult());

		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getPromotion());
		ApiResponse<Promotion> apiResponsePromotion = dvsApiClientHelper.getPromotion(1L);
		assertNotNull(apiResponsePromotion.getResult());

		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getPromotions());
		ApiResponse<List<Promotion>> apiResponsePromotionsFilters = dvsApiClientHelper
				.getPromotions(new PromotionFilter("BGD", 1L, 1L), 1, 100);
		assertNotNull(apiResponsePromotionsFilters.getResult());
	}

	@Test
	public void testProductAPIs() throws Exception {
		when(apiService.httpGetPageable(Mockito.any(), Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getPageableProducts());
		Page<ApiResponse<List<Product>>> apiResponseAllProducts = dvsApiClientHelper.getAllProducts();
		assertNotNull(apiResponseAllProducts.first().getResult());

		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getProducts());
		ApiResponse<List<Product>> apiResponseProducts = dvsApiClientHelper.getProducts(new ProductFilter(), 1, 100);
		assertNotNull(apiResponseProducts.getResult());

		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getProduct());
		ApiResponse<Product> apiResponseProduct = dvsApiClientHelper.getProduct(1L);
		assertNotNull(apiResponseProduct.getResult());
	}

	@Test
	public void testTransactionAPIs() throws Exception {
		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getTransactions());
		ApiResponse<List<Transaction>> apiResponseTransactionsFiltersAll = dvsApiClientHelper
				.getTransactions(new TransactionFilter("NEX-123"), 1, 100);
		assertNotNull(apiResponseTransactionsFiltersAll.getResult());

		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getTransactions());
		ApiResponse<List<Transaction>> apiResponseTransactions = dvsApiClientHelper
				.getTransactions(new TransactionFilter("NEX-123"), 1, 100);
		assertNotNull(apiResponseTransactions.getResult());

		when(apiService.httpGet(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any()))
				.thenReturn(MockTestUtils.getTransaction());
		ApiResponse<Transaction> apiResponseTransaction = dvsApiClientHelper.getTransaction(1L);
		assertNotNull(apiResponseTransaction.getResult());

		when(apiService.httpPost(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any(), Mockito.any()))
				.thenReturn(MockTestUtils.getTransaction());
		ApiResponse<Transaction> apiResponseTransactionPost = dvsApiClientHelper
				.postTransaction(new TransactionRequest());
		assertNotNull(apiResponseTransactionPost.getResult());

		when(apiService.httpPost(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any(), Mockito.any()))
				.thenReturn(MockTestUtils.getTransaction());
		ApiResponse<Transaction> apiResponseTransactionConfirm = dvsApiClientHelper.confirmTransaction(1L);
		assertNotNull(apiResponseTransactionConfirm.getResult());

		when(apiService.httpPost(Mockito.any(), Mockito.any(ApiResponse.class), Mockito.any(), Mockito.any()))
				.thenReturn(MockTestUtils.getTransaction());
		ApiResponse<Transaction> apiResponseTransactionCancel = dvsApiClientHelper.cancelTransaction(1L);
		assertNotNull(apiResponseTransactionCancel.getResult());
	}

}
