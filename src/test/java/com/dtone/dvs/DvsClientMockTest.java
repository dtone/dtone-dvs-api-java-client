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

import com.dtone.dvs.DvsApiClient;
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
import com.dtone.dvs.util.MockTestUtils;

public class DvsClientMockTest {

	@Mock
	DvsApiClientHelper dvsClientHelper = mock(DvsApiClientHelper.class);

	@InjectMocks
	private DvsApiClient dvsClient = new DvsApiClient(dvsClientHelper);

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testServiceAPIs() throws Exception {
		when(dvsClientHelper.getAllServices()).thenReturn(MockTestUtils.getPageableServices());
		Page<ApiResponse<List<Service>>> apiResponseAllServices = dvsClient.getServices();
		assertNotNull(apiResponseAllServices.first().getResult());

		when(dvsClientHelper.getServices(Mockito.anyInt(), Mockito.anyInt())).thenReturn(MockTestUtils.getServices());
		ApiResponse<List<Service>> apiResponseServices = dvsClient.getServices(1, 100);
		assertNotNull(apiResponseServices.getResult());

		when(dvsClientHelper.getService(Mockito.anyString())).thenReturn(MockTestUtils.getService());
		ApiResponse<Service> apiResponseService = dvsClient.getService(1L);
		assertNotNull(apiResponseService.getResult());
	}

	@Test
	public void testCountryAPIs() throws Exception {
		when(dvsClientHelper.getAllCountries()).thenReturn(MockTestUtils.getPageableCountries());
		Page<ApiResponse<List<Country>>> apiresponseAllCountries = dvsClient.getCountries();
		assertNotNull(apiresponseAllCountries.first().getResult());

		when(dvsClientHelper.getCountries(Mockito.anyInt(), Mockito.anyInt())).thenReturn(MockTestUtils.getCountries());
		ApiResponse<List<Country>> apiResponseCountries = dvsClient.getCountries(1, 100);
		assertNotNull(apiResponseCountries.getResult());

		when(dvsClientHelper.getCountry(Mockito.anyString())).thenReturn(MockTestUtils.getCountry());
		ApiResponse<Country> apiResponseCountry = dvsClient.getCountry("BGD");
		assertNotNull(apiResponseCountry.getResult());
	}

	@Test
	public void testOperatorAPIs() throws Exception {
		when(dvsClientHelper.getAllOperators()).thenReturn(MockTestUtils.getPageableOperators());
		Page<ApiResponse<List<Operator>>> apiResponseAllOperators = dvsClient.getOperators();
		assertNotNull(apiResponseAllOperators.first().getResult());

		when(dvsClientHelper.getOperators(Mockito.anyInt(), Mockito.anyInt())).thenReturn(MockTestUtils.getOperators());
		ApiResponse<List<Operator>> apiResponseOperators = dvsClient.getOperators(1, 100);
		assertNotNull(apiResponseOperators.getResult());

		when(dvsClientHelper.getOperator(Mockito.anyLong())).thenReturn(MockTestUtils.getOperator());
		ApiResponse<Operator> apiResponseOperator = dvsClient.getOperator(1L);
		assertNotNull(apiResponseOperator.getResult());

		when(dvsClientHelper.getOperators(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(MockTestUtils.getOperators());
		ApiResponse<List<Operator>> apiResponseOperatorsByIsoCode = dvsClient.getOperators("BGD");
		assertNotNull(apiResponseOperatorsByIsoCode.getResult());

		when(dvsClientHelper.getOperators(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(MockTestUtils.getOperators());
		ApiResponse<List<Operator>> apiResponseOperatorsByIsoCodeFilter = dvsClient.getOperators("BGD", 1, 100);
		assertNotNull(apiResponseOperatorsByIsoCodeFilter.getResult());

		when(dvsClientHelper.lookupOperators(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(MockTestUtils.getOperators());
		ApiResponse<List<Operator>> apiResponseLookupOperatorsAll = dvsClient.lookupOperators("8888888888");
		assertNotNull(apiResponseLookupOperatorsAll.getResult());

		when(dvsClientHelper.lookupOperators(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(MockTestUtils.getOperators());
		ApiResponse<List<Operator>> apiResponseLookupOperators = dvsClient.lookupOperators("8888888888", 1, 100);
		assertNotNull(apiResponseLookupOperators.getResult());
	}

	@Test
	public void testBalanceAPIs() throws Exception {
		when(dvsClientHelper.getAllBalances()).thenReturn(MockTestUtils.getPageableBalances());
		Page<ApiResponse<List<Balance>>> apiresponseAllBalances = dvsClient.getBalances();
		assertNotNull(apiresponseAllBalances.first().getResult());

		when(dvsClientHelper.getBalances(Mockito.anyInt(), Mockito.anyInt())).thenReturn(MockTestUtils.getBalances());
		ApiResponse<List<Balance>> apiResponseBalances = dvsClient.getBalances(1, 100);
		assertNotNull(apiResponseBalances.getResult());
	}

	@Test
	public void testBenefitTypeAPIs() throws Exception {
		when(dvsClientHelper.getAllBenefitTypes()).thenReturn(MockTestUtils.getPageableBenefitTypes());
		Page<ApiResponse<List<BenefitType>>> apiresponseAllBenefitTypes = dvsClient.getBenefitTypes();
		assertNotNull(apiresponseAllBenefitTypes.first().getResult());

		when(dvsClientHelper.getBenefitTypes(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(MockTestUtils.getBenefitTypes());
		ApiResponse<List<BenefitType>> apiResponseBenefitTypes = dvsClient.getBenefitTypes(1, 100);
		assertNotNull(apiResponseBenefitTypes.getResult());
	}

	@Test
	public void testPromotionAPIs() throws Exception {
		when(dvsClientHelper.getAllPromotions()).thenReturn(MockTestUtils.getPageablePromotions());
		Page<ApiResponse<List<Promotion>>> apiresponseAllPromotions = dvsClient.getPromotions();
		assertNotNull(apiresponseAllPromotions.first().getResult());

		when(dvsClientHelper.getPromotions(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(MockTestUtils.getPromotions());
		ApiResponse<List<Promotion>> apiResponsePromotions = dvsClient.getPromotions(1, 100);
		assertNotNull(apiResponsePromotions.getResult());

		when(dvsClientHelper.getPromotion(Mockito.anyLong())).thenReturn(MockTestUtils.getPromotion());
		ApiResponse<Promotion> apiResponsePromotion = dvsClient.getPromotion(1L);
		assertNotNull(apiResponsePromotion.getResult());

		when(dvsClientHelper.getPromotions(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(MockTestUtils.getPromotions());
		ApiResponse<List<Promotion>> apiResponsePromotionsFiltersAll = dvsClient
				.getPromotions(new PromotionFilter("BGD", 1L, 1L));
		assertNotNull(apiResponsePromotionsFiltersAll.getResult());

		when(dvsClientHelper.getPromotions(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(MockTestUtils.getPromotions());
		ApiResponse<List<Promotion>> apiResponsePromotionsFilters = dvsClient
				.getPromotions(new PromotionFilter("BGD", 1L, 1L), 1, 100);
		assertNotNull(apiResponsePromotionsFilters.getResult());
	}

	@Test
	public void testProductAPIs() throws Exception {
		when(dvsClientHelper.getAllProducts()).thenReturn(MockTestUtils.getPageableProducts());
		Page<ApiResponse<List<Product>>> apiResponseAllProducts = dvsClient.getProducts();
		assertNotNull(apiResponseAllProducts.first().getResult());

		when(dvsClientHelper.getProducts(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(MockTestUtils.getProducts());
		ApiResponse<List<Product>> apiResponseProducts = dvsClient.getProducts(1, 100);
		assertNotNull(apiResponseProducts.getResult());

		when(dvsClientHelper.getProducts(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(MockTestUtils.getProducts());
		ApiResponse<List<Product>> apiResponseProductsFilter = dvsClient.getProducts(new ProductFilter());
		assertNotNull(apiResponseProductsFilter.getResult());

		when(dvsClientHelper.getProducts(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(MockTestUtils.getProducts());
		ApiResponse<List<Product>> apiResponseProductsFilterPage = dvsClient.getProducts(new ProductFilter(), 1, 100);
		assertNotNull(apiResponseProductsFilterPage.getResult());

		when(dvsClientHelper.getProduct(Mockito.anyLong())).thenReturn(MockTestUtils.getProduct());
		ApiResponse<Product> apiResponseProduct = dvsClient.getProduct(1L);
		assertNotNull(apiResponseProduct.getResult());
	}

	@Test
	public void testTransactionAPIs() throws Exception {
		when(dvsClientHelper.getTransactions(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(MockTestUtils.getTransactions());
		ApiResponse<List<Transaction>> apiResponseTransactionsFiltersAll = dvsClient
				.getTransactions(new TransactionFilter("NEX-123"));
		assertNotNull(apiResponseTransactionsFiltersAll.getResult());

		when(dvsClientHelper.getTransactions(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(MockTestUtils.getTransactions());
		ApiResponse<List<Transaction>> apiResponseTransactions = dvsClient
				.getTransactions(new TransactionFilter("NEX-123"), 1, 100);
		assertNotNull(apiResponseTransactions.getResult());

		when(dvsClientHelper.getTransaction(Mockito.anyLong())).thenReturn(MockTestUtils.getTransaction());
		ApiResponse<Transaction> apiResponseTransaction = dvsClient.getTransaction(1L);
		assertNotNull(apiResponseTransaction.getResult());

		when(dvsClientHelper.postTransaction(Mockito.any())).thenReturn(MockTestUtils.getTransaction());
		ApiResponse<Transaction> apiResponseTransactionPost = dvsClient
				.createTransaction(new TransactionRequest());
		assertNotNull(apiResponseTransactionPost.getResult());

		when(dvsClientHelper.confirmTransaction(Mockito.anyLong())).thenReturn(MockTestUtils.getTransaction());
		ApiResponse<Transaction> apiResponseTransactionConfirm = dvsClient.confirmTransaction(1L);
		assertNotNull(apiResponseTransactionConfirm.getResult());

		when(dvsClientHelper.cancelTransaction(Mockito.anyLong())).thenReturn(MockTestUtils.getTransaction());
		ApiResponse<Transaction> apiResponseTransactionCancel = dvsClient.cancelTransaction(1L);
		assertNotNull(apiResponseTransactionCancel.getResult());
	}

}
